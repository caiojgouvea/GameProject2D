package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final int originalTileSize = 16;// 16x16 Tile
	final int scale = 3; // Escalar tamanho dos tiles
	public final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16; // Ratio 4:3
	final int maxScreenRow = 12; // Ratio 4:3
	final int screenWidth = tileSize * maxScreenCol;
	final int screenheight = tileSize * maxScreenRow;

	int FPS = 60;

	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this, keyH);

	// Posição do Jogador
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenheight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawIterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		while (gameThread != null) {

			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawIterval;

			lastTime = currentTime;

			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}
		}
	}

	public void update() {
		player.update();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		player.draw(g2);

		g2.dispose();
	}

}
