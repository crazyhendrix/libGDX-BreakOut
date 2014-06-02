package com.eightbitdreams.breakout.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.eightbitdreams.breakout.game.objects.Block;
import com.eightbitdreams.breakout.util.Constants;

public class WorldRenderer implements Disposable{
	private static final String TAG = WorldRenderer.class.getName();

	private WorldController world;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	public WorldRenderer (WorldController world) {
		this.world = world;
		init();
	}
	
	private void init() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
		camera.update();
	}
	
	public void render() {
		renderTestObjects();
	}
	
	private void renderTestObjects() {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.disableBlending();
		for (Block block : world.blocks) {
			block.render(batch);
		}
		world.paddle.render(batch);
		world.ball.render(batch);
		batch.enableBlending();
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
