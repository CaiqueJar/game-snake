package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean right, left, up, down, comeu, changeSpd;

	public int score, oldScore;
	
	public double spd = 16;

	public Rectangle[] corpo;

	public Player(int x, int y) {
		super(x, y, 16, 16);

		corpo = new Rectangle[20 * 20];
		corpo[0] = new Rectangle(x, y, 16, 16);

	}

	public void tick() {

		for (int i = score; i > 0; i--) {

			corpo[i].x = corpo[i - 1].x;
			corpo[i].y = corpo[i - 1].y;

			if (x == corpo[i].x && y == corpo[i].y && i > 1)
				System.exit(1);

		}

		if (right) {
			x += spd;
			corpo[0].x += spd;

		} else if (left) {
			x -= spd;
			corpo[0].x -= spd;

		}
		if (up) {
			y -= spd;
			corpo[0].y -= spd;

		} else if (down) {
			y += spd;
			corpo[0].y += spd;

		}

		if (comeu) {
			comeu = false;
			score++;
			corpo[score] = new Rectangle(x, y, 16, 16);
		}

		if(score % 5 == 0 && score > 0 && score != oldScore) {
			changeSpd = true;
			oldScore = score;
		}
		
		if(changeSpd) {
			changeSpd = false;
			Game.change -= 10;
		}
	}

	public void render(Graphics g) {

		for (int i = 0; i <= score; i++) {
			g.setColor(Color.green);

			g.fillRect(x, y, width, height);
			g.fillRect(corpo[i].x, corpo[i].y, width, height);

		}
	}
}
