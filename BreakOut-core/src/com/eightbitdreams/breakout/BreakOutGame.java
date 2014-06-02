package com.eightbitdreams.breakout;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.eightbitdreams.breakout.game.Assets;
import com.eightbitdreams.breakout.game.WorldController;
import com.eightbitdreams.breakout.game.WorldRenderer;

public class BreakOutGame extends ApplicationAdapter {
	private static final String TAG = BreakOutGame.class.getName();
	
	private WorldController world;
	private WorldRenderer renderer;
	
	private boolean paused;
	
	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		// Load Assets
		world = new WorldController();
		renderer = new WorldRenderer(world);
		paused = false;
	}

	@Override
	public void render () {
		if (!paused) {
            world.update(Gdx.graphics.getDeltaTime());
		}
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.render();
	}
	
	@Override
	public void pause () {
		paused = true;
	}
	
	@Override
	public void resume () {
		paused = false;
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
		Assets.instance.dispose();
	}
}
