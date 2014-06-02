package com.eightbitdreams.breakout.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.eightbitdreams.breakout.game.objects.Ball;
import com.eightbitdreams.breakout.game.objects.Block;
import com.eightbitdreams.breakout.game.objects.Paddle;

public class WorldController extends InputAdapter implements Disposable {

	private static final String TAG = WorldController.class.getName();
	public Array<Block>blocks;
	public Paddle paddle;
	public Ball ball;
	private float moveBallSpeedX;
	private float moveBallSpeedY;
	
	public WorldController () {
		init();
	}
	
	private void init() {
		Gdx.input.setInputProcessor(this);
		paddle = new Paddle(240, 30);
		ball = new Ball(240, 400);
		moveBallSpeedX = MathUtils.random(-300, 300);
		moveBallSpeedY = 300;
		ball.setVelocity(moveBallSpeedX, -moveBallSpeedY);
		initLevelBlocks();
	}
	
	private void initLevelBlocks() {
		blocks = new Array<Block>();
		int y = 750;
		float tint = 0.05f;
		for (int j =0; j < 8; j ++) {
			int x = 0;
			for (int i = 0; i < 12; i++){
				Block block = new Block(x, y);
				block.setTint(tint, tint, 1.0f);
				blocks.add(block);
				x += 40;
				tint += 0.05;
			}
			y -= 5;
		}
	}
	
	public void update (float delta) {
		inputPaddleX(delta);
		ball.setVelocity(moveBallSpeedX, moveBallSpeedY);
		ballMaxSpeed();
		paddle.update(delta);
		ball.update(delta);
		checkBallWallCollision();
		checkBallPaddleCollision();
		checkBlockCollision();
	}
	
	private void ballMaxSpeed() {
		if (moveBallSpeedX < 0 && moveBallSpeedX < -300)
			moveBallSpeedX = -300;
		if (moveBallSpeedX > 0 && moveBallSpeedX > 300)
			moveBallSpeedX = 300;
		if (moveBallSpeedY < 0 && moveBallSpeedY < -300)
			moveBallSpeedY = -400;
		if (moveBallSpeedY > 0 && moveBallSpeedY > 300)
			moveBallSpeedY = 300;
	}
	
	private void checkBallWallCollision () {
		if (ball.getBounds().x < 0)
			moveBallSpeedX *= -1;
		if (ball.getBounds().x > 470)
			moveBallSpeedX *= -1;
		if (ball.getBounds().y < 0)
			moveBallSpeedY *= -1;
		if (ball.getBounds().y > 790)
			moveBallSpeedY *= -1;
	}
	
	private void checkBallPaddleCollision () {
		if (Intersector.overlaps(ball.getBounds(), paddle.bound2)) {
			moveBallSpeedY *= -1;
		}
		if (Intersector.overlaps(ball.getBounds(), paddle.bound1)) {
			moveBallSpeedY *= -1;
			moveBallSpeedX -= 150;
		}
		if (Intersector.overlaps(ball.getBounds(), paddle.bound3)) {
			moveBallSpeedY *= -1;
			moveBallSpeedX += 150;
		}
	}
	
	private void checkBlockCollision () {
		for (Block block : blocks) {
			if (Intersector.overlaps(ball.getBounds(), block.getBounds())) {
				blocks.removeValue(block, false);
				moveBallSpeedY *= -1;
			}
		}
	}
	
	private void inputPaddleX(float delta) {
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			if (paddle.getX() > 0) {
				paddle.moveBy(-480 * delta, 0);
			} else if (paddle.getX() < 0)
				paddle.setPosition(0, paddle.getY());
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if (paddle.getX() < 480 - 40) {
				paddle.moveBy(480 * delta, 0);
			} else if (paddle.getX() > 480 - 30)
				paddle.setPosition(480-40, paddle.getY());
		}
	}
	
	@Override
	public boolean keyUp (int keycode) {
		// reset Game world
		if (keycode == Keys.R) {
			init();
			Gdx.app.debug(TAG, "Game world resetted");
		}
		return false;
	}

	@Override
	public void dispose() {
	}
}
