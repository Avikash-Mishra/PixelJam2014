package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

import entity.Player;
import main.World;


/**
 * The display for the game
 * @author Preet Nijjar
 *
 */
public class GameCanvas extends Canvas {


	private GameFrame parent;
	private World world;
	private Player player;

	/**
	 * Constructs a new GameCanvas with the given width and height
	 * @param width The Width of the canvas
	 * @param height The Height of the canvas
	 */
	public GameCanvas(int width, int height, GameFrame parent, World world) {
		super(parent.getWidth(), parent.getHeight());
		this.parent = parent;
		parent.setBackground(Color.BLUE);
		this.world = world;
		player = new Player(null,0,0);
		this.addKeyListener(new Listener());
	}

	/**
	 * Draws everything.
	 */
	@Override
	public void paint(Graphics g){
		world.draw(g);

	}


	private class Listener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {

			int code = e.getKeyCode();

			if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A || code == KeyEvent.VK_D){
				player.move(code);
			}
			else if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
				player.jump();
			}
			else if (code == KeyEvent.VK_SPACE){
				player.transform();
			}

		}

		@Override
		public void keyReleased(KeyEvent e){
			int code = e.getKeyCode();
			if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A || code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
				player.stop(code);
			}
		}

	}


}
