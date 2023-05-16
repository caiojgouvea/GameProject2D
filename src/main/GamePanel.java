package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final int originalTileSize = 16;//16x16 Tile
	final int scale = 3;			// Escalar tamanho dos tiles
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16; 	// Ratio 4:3
	final int maxScreenRow = 12;	// Ratio 4:3
	final int screenWidth = tileSize * maxScreenCol;
	final int screenheight = tileSize * maxScreenRow;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenheight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
	
	
}
