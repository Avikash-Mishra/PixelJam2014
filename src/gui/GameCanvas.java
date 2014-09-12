package gui;

import java.awt.Color;
import java.awt.Graphics;

import main.World;


/**
 * The display for the game
 * @author Avikash Mishra
 *
 */
public class GameCanvas extends Canvas {


	private GameFrame parent;
	private World world;

	/**
	 * Constructs a new GameCanvas with the given width and height
	 * @param width The Width of the canvas
	 * @param height The Height of the canvas
	 */
	public GameCanvas(int width, int height, GameFrame parent) {
		super(parent.getWidth(), parent.getHeight());
		this.parent = parent;
		parent.setBackground(Color.BLUE);
	}

	/**
	 * Draws everything.
	 */
	@Override
	public void paint(Graphics g){
		world.draw(g);

	}

}
