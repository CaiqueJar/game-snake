package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class World {

	public List<Tiles> tiles;

	public World() {
		tiles = new ArrayList<Tiles>();

		for (int xx = 0; xx < Game.WIDTH/16; xx++) {
			tiles.add(new Tiles(xx * 16, 0));
		}
		for (int xx = 0; xx < Game.WIDTH/16; xx++) {
			tiles.add(new Tiles(xx * 16, Game.WIDTH - 16));
		}

		for (int yy = 0; yy < Game.HEIGHT/16; yy++) {
			tiles.add(new Tiles(0, yy * 16));
		}

		for (int yy = 0; yy < Game.HEIGHT/16; yy++) {
			tiles.add(new Tiles(Game.HEIGHT - 16, yy * 16));
		}
	}
	
	public void tick() {
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).render(g);
		}
	}
}
