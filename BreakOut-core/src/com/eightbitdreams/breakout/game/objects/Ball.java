package com.eightbitdreams.breakout.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.eightbitdreams.breakout.game.Assets;

public class Ball {
	private Vector2 velocity;
	private Sprite spriteBall;
	private Circle bounds;
	
	public Ball (float x, float y) {
		init(x, y);
	}
	
	private void init(float x, float y) {
		velocity = new Vector2(0,0);
		spriteBall = new Sprite(Assets.instance.getTBall());
		spriteBall.setPosition(x, y);
		bounds = new Circle(spriteBall.getX(), spriteBall.getY(), spriteBall.getWidth() / 2);
	}
	
	public void update (float delta) {
		spriteBall.translate(velocity.x * delta, velocity.y * delta);
		bounds.setPosition(spriteBall.getX(), spriteBall.getY());
	}
	
	public void setVelocity(float x, float y) {
		velocity.x = x;
		velocity.y = y;
	}
	
	public Circle getBounds() {
		return bounds;
	}
	
	public void render(SpriteBatch batch) {
		spriteBall.draw(batch);
	}
}
