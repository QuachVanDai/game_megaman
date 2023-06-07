package gameObject;

import java.awt.Graphics2D;

import user_interface.gameFrame;

public class gameWorld {

	megaman me;
	physicalMap phy;
	camera camera;
	bulletmanager bullet_ma;
	backGroundMap back_map;
	public gameWorld() {
		me = new megaman(200, 50, this);
		phy = new physicalMap(0, 0,this);
		camera = new camera(0, 0, gameFrame.SCREEN_WIDTH, gameFrame.SCREEN_HEIGHT, null);
		back_map = new backGroundMap(0,0, null);
		bullet_ma =  new bulletmanager(this);
	}

	public void update() {
		me.update();
		camera.update();
		bullet_ma.UpdateObjects();
	}

	public void render(Graphics2D g2) {
			phy.draw(g2);
			me.draw(g2);
			back_map.draw(g2);
		//	camera.update();
	}
}
