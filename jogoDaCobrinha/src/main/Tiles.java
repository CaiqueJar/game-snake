package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Tiles extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Tiles(int x, int y) {
		super(x, y, 16, 16);
	
	}
	
	public void tick() {
		if(intersects(Game.player.x, Game.player.y, 16, 16)) {
			System.exit(1);
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, 16, 16);
	}
}
