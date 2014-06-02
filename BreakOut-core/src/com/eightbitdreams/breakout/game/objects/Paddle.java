package com.eightbitdreams.breakout.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.eightbitdreams.breakout.game.Assets;

public class Paddle {
	private Sprite spritePaddle;
	private Rectangle bounds;
	public Rectangle bound1, bound2, bound3;
	
	public Paddle (float x, float y) {
		init(x, y);
	}
	
	private void init(float x, float y) {
		spritePaddle = new Sprite(Assets.instance.getTPaddle());
		spritePaddle.setPosition(x, y);
		bounds = new Rectangle(spritePaddle.getX(), spritePaddle.getY(), spritePaddle.getWidth(), spritePaddle.getHeight());
		bound1 = new Rectangle(spritePaddle.getX(), spritePaddle.getY(), 10, 5);
		bound2 = new Rectangle(spritePaddle.getX() + 10, spritePaddle.getY(), 20, 5);
		bound3 = new Rectangle(spritePaddle.getX() + 30, spritePaddle.getY(), 10, 5);
	}
	
	public void setPosition(float x, float y) {
		spritePaddle.setPosition(x, y);
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public float getX() {
		return spritePaddle.getX();
	}
	
	public float getY() {
		return spritePaddle.getY();
	}
	
	public void update (float delta) {
		bounds.setPosition(spritePaddle.getX(), spritePaddle.getY());
		bound1.setPosition(spritePaddle.getX(), spritePaddle.getY());
		bound2.setPosition(spritePaddle.getX() + 10, spritePaddle.getY());
		bound3.setPosition(spritePaddle.getX() + 30, spritePaddle.getY());
	}
	
	public void moveBy (float x, float y) {
		spritePaddle.translate(x, y);
	}
	
	public void render(SpriteBatch batch) {
		spritePaddle.draw(batch);
	}
}
