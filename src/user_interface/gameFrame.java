package user_interface;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

import effect.cacheDataLoader;

public class gameFrame extends JFrame {
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 600;
	gamePanel gamePanel;

	public gameFrame() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = this.getToolkit(); // hoi chatgpt
		Dimension solution = toolkit.getScreenSize();

		try {
			cacheDataLoader.getInstance().LoadData();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		this.setBounds((solution.width - SCREEN_WIDTH) / 2, (solution.height - SCREEN_HEIGHT) / 2, SCREEN_WIDTH,
				SCREEN_HEIGHT);

		gamePanel = new gamePanel();
		add(gamePanel);
		addKeyListener(gamePanel);
	}

	public void startGame() {

		gamePanel.startGame();
		this.setVisible(true);

	}

	public static void main(String arg[]) {

		gameFrame gameFrame = new gameFrame();
		gameFrame.startGame();

	}
}
