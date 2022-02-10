package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

public class Apples extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Apples(int x, int y) {
		super(x, y, 16, 16);

	}

	public void tick() {
		if (intersects(Game.player.x, Game.player.y, 16, 16)) {
			x = ThreadLocalRandom.current().nextInt(2, 18) * 16;
			y = ThreadLocalRandom.current().nextInt(2, 18) * 16;
			Game.player.comeu = true;
			
		}
		
		if(x == 0 || x == Game.WIDTH-16 || y == 0 || y == Game.HEIGHT-16) {
			System.out.println("opa");
			x = ThreadLocalRandom.current().nextInt(2, 18) * 16;
			y = ThreadLocalRandom.current().nextInt(2, 18) * 16;
		}
		
		for(int i = 0; i < Game.player.score; i++) {
			if(x == Game.player.corpo[i].x && y == Game.player.corpo[i].y) {
				x = ThreadLocalRandom.current().nextInt(2, 18) * 16;
				y = ThreadLocalRandom.current().nextInt(2, 18) * 16;
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
}
