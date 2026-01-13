package tictac;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	private static final int ORIGINAL_TILE_SIZE = 16; // 16 x 16 tile
	private static final int SCALE = 3;

	public static int tileSize = ORIGINAL_TILE_SIZE * SCALE; // 48 x 48 pixels
	private static final int maxScreenCol = 16;
	private static final int maxScreenRow = 12;
	private static final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	private static final int screenHeight = tileSize * maxScreenRow; // 576 pixels

	private static final int FPS = 30;

	int currentPlayer = 1;

	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Position position;

	Player player = new Player(this, keyH);

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		this.position = new Position(120, 120);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		// Two popular game loops
		// Established methods

		double drawInterval = 1000000000 / FPS; // 0.01666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {
			// 1 UPDATE: update information such as character position}
			update();
			// 2 DRAW: draw the screen with the updated information
			repaint();

			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;

				if (remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update() {
		player.update();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.white);

		g2.drawString("------------------------------", 250, 250);
		g2.drawString("|          |             |           |", 250, 259);
		g2.drawString("|          |             |           |", 250, 269);
		g2.drawString("|          |             |           |", 250, 279);
		g2.drawString("|          |             |           |", 250, 289);
		g2.drawString("------------------------------", 250, 299);
		g2.drawString("|          |             |           |", 250, 309);
		g2.drawString("|          |             |           |", 250, 319);
		g2.drawString("|          |             |           |", 250, 329);
		g2.drawString("|          |             |           |", 250, 339);
		g2.drawString("------------------------------", 250, 349);
		g2.drawString("|          |             |           |", 250, 359);
		g2.drawString("|          |             |           |", 250, 369);
		g2.drawString("|          |             |           |", 250, 379);
		g2.drawString("|          |             |           |", 250, 389);
		g2.drawString("------------------------------", 250, 399);

		this.player.draw(g2);

		g2.dispose();
	}
}
