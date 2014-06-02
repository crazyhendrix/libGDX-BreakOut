package com.eightbitdreams.breakout.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.eightbitdreams.breakout.game.Assets;

public class Block {
	private Sprite spriteBlock;
	private Rectangle bounds;
	
	
	public Block (float x, float y) {
		init(x, y);
	}
	
	private void init(float x, float y) {
		spriteBlock = new Sprite(Assets.instance.getTBlock());
		spriteBlock.setPosition(x, y);
		bounds = new Rectangle(spriteBlock.getX(), spriteBlock.getY(), 
				spriteBlock.getWidth(), spriteBlock.getHeight());
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void update (float delta) {
		bounds.setPosition(spriteBlock.getX(), spriteBlock.getY());
	}
	
	public void render(SpriteBatch batch) {
		spriteBlock.draw(batch);
	}
	
	public void setTint(float r, float g, float b) {
		spriteBlock.setColor(r, g, b, 1.0f);
	}
}
