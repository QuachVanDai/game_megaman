package gameObject;

import java.awt.Graphics2D;

public class gameWorld {

	megaman me;
	physicalMap phy;

	public gameWorld() {
		me = new megaman(100, 100, 100, 100, 0.1f);
		phy = new physicalMap(0, 0);
	}

	public void update() {
		me.update();
	}

	public void render(Graphics2D g2) {
			me.draw(g2);
			phy.draw(g2);
	}
}
