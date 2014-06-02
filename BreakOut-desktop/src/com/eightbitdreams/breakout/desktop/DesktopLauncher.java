package com.eightbitdreams.breakout.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.eightbitdreams.breakout.BreakOutGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "BreakOut";
		config.width = 480;
		config.height = 800;
		new LwjglApplication(new BreakOutGame(), config);
	}
}
