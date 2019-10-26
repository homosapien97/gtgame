package com.sleepyheads.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.sleepyheads.game.draw.Model;
import com.sleepyheads.game.draw.ModelSet;

public class GTGame extends ApplicationAdapter implements ApplicationListener, InputProcessor {
	PolygonSpriteBatch batch;
	Texture img;
	public ModelSet models;
	int w;
	int h;
	float mouseX;
	float mouseY;

	public GTGame(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	@Override
	public void create () {
		batch = new PolygonSpriteBatch();
		img = new Texture("badlogic.jpg");
		models = new ModelSet();
		models.add(new Model(new float[]
				{
						-50.0f, -50.0f,
						50.0f, -50.0f,
						50.0f, 50.0f,
						-50.0f, 50.0f,
						0.0f, 0.0f,
						-50.0f, -50.0f
				},
				Color.BLACK));
		Gdx.input.setInputProcessor(this);
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
		for(Model m : models) {
			m.draw(batch);
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
		return false;
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
		for(Model model : models) {
			model.setPosition(screenX, h - screenY);
		}
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
