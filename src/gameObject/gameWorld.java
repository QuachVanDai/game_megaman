package gameObject;

import java.awt.Graphics2D;

import user_interface.gameFrame;

public class gameWorld {

	megaman me;
	physicalMap phy;
	camera camera;

	public gameWorld() {
		me = new megaman(30, 30, this);
		phy = new physicalMap(0, 0,this);
		camera = new camera(0, 0, gameFrame.SCREEN_WIDTH, gameFrame.SCREEN_HEIGHT, null);
	}

	public void update() {
		me.update();
		camera.update();
	}

	public void render(Graphics2D g2) {
			me.draw(g2);
			phy.draw(g2);
	}
}
