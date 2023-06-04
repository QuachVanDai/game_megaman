package user_interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import effect.cacheDataLoader;
import effect.frameImage;
import gameObject.megaman;

public class gamePanel extends JPanel implements Runnable, KeyListener {
	private Thread thread;
	private boolean isRunnning;
	private inputManager inputManager;
	frameImage f1;
	private BufferedImage image;
	private Graphics2D graph;
	megaman me = new megaman(100, 100, 100, 100, 0.1f);

	public gamePanel() {
		inputManager = new inputManager();
		image = new BufferedImage(gameFrame.SCREEN_WIDTH, gameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	public void paint(Graphics g2) {
		super.paint(g2);
	
		 g2.drawImage(image,0,0,this);

	}
	 public void updategame() {
		 me.update();
	 }
	public void renderGame() {
		if (image == null) {
			image = new BufferedImage(gameFrame.SCREEN_WIDTH, gameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		}
		if (image != null) {
			graph = (Graphics2D) image.getGraphics();
		}
		if(graph!=null) {
			graph.setColor(Color.RED);
			graph.fillRect(0, 0, gameFrame.SCREEN_WIDTH, gameFrame.SCREEN_HEIGHT);
			
			me.draw(graph);
		}
	}

	public void startGame() {
		if (thread == null) {
			isRunnning = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long previousTime = System.nanoTime();
		long currentTime;
		long sleepTime;
		long begintime = System.nanoTime();
		long period = 1000000000 / 80;
		while (isRunnning) {
			updategame();
			renderGame();
			repaint();
			long deltaTime = System.nanoTime() - begintime;
			sleepTime = period - deltaTime;
			try {
				if (sleepTime > 0) {
					thread.sleep(sleepTime / 1000000);
				} else {
					thread.sleep(period / 2000000);
				}
			} catch (Exception e) {
				// TODO: handle exception

			}
			begintime = System.nanoTime();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		inputManager.proceesKeypressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
