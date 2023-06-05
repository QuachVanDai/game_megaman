package effect;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class frameImage {
	private String name;
	private BufferedImage image;

	public frameImage(String name, BufferedImage image) {
		this.name = name;
		this.image = image;
	}

	public frameImage(frameImage f) {
		
		image = new BufferedImage(f.getWidthImage(), f.getHeightImage(), f.image.getType());
		Graphics g = image.getGraphics();
		g.drawImage(f.getImage(), 0, 0, null);
		name = f.name;

	}

	public void draw(int x, int y, Graphics2D g2) {

		g2.drawImage(image, x - image.getWidth() / 2, y - image.getHeight() / 2, null);

	}

	public frameImage() {
		name = null;
		image = null;
	}

	public int getWidthImage() {
		return image.getWidth();
	}

	public int getHeightImage() {
		return image.getHeight();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
