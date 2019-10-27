package com.sleepyheads.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.sleepyheads.game.draw.Polygon;
import com.sleepyheads.game.draw.Model;
import com.sleepyheads.game.entity.Alice;
import com.sleepyheads.game.entity.Entity;
import com.sleepyheads.game.world.World;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Client extends ApplicationAdapter implements ApplicationListener, InputProcessor {
	PolygonSpriteBatch batch;
	Texture img;
	public HashSet<Model> models;
	int w;
	int h;
	float mouseX;
	float mouseY;
	Set<Event> events;
	Server server;


	public Client(int w, int h, Server server) {
		super();
		this.w = w;
		this.h = h;
		this.server = server;
		events = new HashSet<>();
		server.addClient(this);
	}

	@Override
	public void create () {
		batch = new PolygonSpriteBatch();
		img = new Texture("badlogic.jpg");
		models = new HashSet<>();
//		models.add(new Polygon(new float[]
//				{
//						-50.0f, -50.0f,
//						50.0f, -50.0f,
//						50.0f, 50.0f,
//						-50.0f, 50.0f,
//						0.0f, 0.0f,
//						-50.0f, -50.0f
//				},
//				Color.BLACK));
		//Model alice = new Model("models/alice_main.txt");
		//alice.setScale(0.5f);
		World world = new World();
		world.entities.add(new Alice());
		server.world = world;
//		alice.setPosition(200.0f, 200.0f);
//		alice.setRotation(-90.0f);
		Gdx.input.setInputProcessor(this);
		ConcurrentHashMap<Event, Object> dummy = new ConcurrentHashMap<>();
		events = dummy.newKeySet();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Starting Client Thread");
				SocketHints socketHints = new SocketHints();
				// Socket will time our in 4 seconds
				socketHints.connectTimeout = 4000;
				Socket socket = Gdx.net.newClientSocket(Net.Protocol.TCP, server.address, 9021, socketHints);
				ObjectOutputStream eventstream = null;
				try {
					eventstream = new ObjectOutputStream(socket.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				assert eventstream != null;
				// Loop forever
				while (true) {
					for (Event e : events) {
						try {
							eventstream.writeObject(e);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					events.clear();
					try {
						Thread.sleep(10);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
//		}).run();
		});
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		/*
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		 */
//		for(Model m : models) {
//			m.draw(batch);
//		}
		for(Entity e : server.world.entities) {
			e.model.draw(batch);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		for(Model model : models) {
			model.setPosition(screenX, h - screenY);
		}
		for(Entity e : server.world.entities) {
			e.model.setPosition(screenX, h - screenY);
		}
		System.out.println("click");
		events.add(new Event() {
			@Override
			public void happen(World world) {
				System.out.println("Hello");
			}
		});
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		mouseX = screenX;
		mouseY = screenY;
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
