package com.eightbitdreams.breakout.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Filter;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {
	private Texture tPaddle, tBall, tBlock;
	public static final Assets instance = new Assets();

	private Assets () {
		init();
	}
	
	private void init () {
		Pixmap pixmap = new Pixmap(40, 5, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.setFilter(Filter.BiLinear);
		pixmap.fill();
		tPaddle = new Texture(pixmap);
		tBlock = new Texture(pixmap);
		pixmap = new Pixmap(8,8,Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fillCircle(0, 0, 4);
		tBall = new Texture(pixmap);
	}
	
	public Texture getTPaddle () {
		return tPaddle;
	}
	
	public Texture getTBall () {
		return tBall;
	}
	
	public Texture getTBlock () {
		return tBlock;
	}

	@Override
	public void dispose() {
		tPaddle.dispose();
		tBall.dispose();
		tBlock.dispose();
	}
}
