package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 320, HEIGHT = 320;
	
	public static int change = 120;
	
	public static Player player;
	public static Apples apple;

	public static Random random;
	
	public static World world;

	public Game() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.addKeyListener(this);

		random = new Random();

		world = new World();
		player = new Player(32, 32);
		apple = new Apples(random.nextInt(20) * 16, random.nextInt(20) * 16);
		apple = new Apples(0, 0);

	}

	public static void main(String[] args) {
		Game game = new Game();

		JFrame frame = new JFrame("Cobrinha");
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new Thread(game).start();

	}

	public void tick() {
		world.tick();
		player.tick();
		apple.tick();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, WIDTH, HEIGHT);

		player.render(g);
		apple.render(g);
		world.render(g);

		g.setFont(new Font("arial", Font.BOLD, 12));
		g.setColor(Color.white);
		g.drawString("score: " + player.score, 250, 12);

		bs.show();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			tick();
			render();
			
			try {
				Thread.sleep(change);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && !player.left) {
			player.right = true;
			player.left = false;
			player.down = false;
			player.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && !player.right) {
			player.left = true;
			player.right = false;
			player.down = false;
			player.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_UP && !player.down) {
			player.up = true;
			player.right = false;
			player.left = false;
			player.down = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && !player.up) {
			player.down = true;
			player.right = false;
			player.left = false;
			player.up = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.comeu = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
