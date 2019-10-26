package com.sleepyheads.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sleepyheads.game.draw.Model;
import com.sleepyheads.game.draw.ModelSet;

public class GTGame extends ApplicationAdapter {
	PolygonSpriteBatch batch;
	Texture img;
	ModelSet models;
	
	@Override
	public void create () {
		batch = new PolygonSpriteBatch();
		img = new Texture("badlogic.jpg");
		models = new ModelSet();
		models.add(new Model(new float[] {400.0f, 400.0f, 500.0f, 400.0f, 500.0f, 500.0f, 400.0f, 400.0f}, Color.BLACK));
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
}
