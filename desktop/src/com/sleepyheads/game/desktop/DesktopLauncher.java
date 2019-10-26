package com.sleepyheads.game.desktop;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sleepyheads.game.Client;
import com.sleepyheads.game.Server;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Griphon and Turtle";
		config.useGL30 = true;
		//config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		//config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		//config.fullscreen = true;
		config.width = 1600;
		config.height = 900;
		Server server = new Server();
		server.create();
		new LwjglApplication(new Client(config.width, config.height, server), config);
	}
}
