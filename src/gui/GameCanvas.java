package gui;

import java.awt.Color;
import java.awt.Graphics;


/**
 * The display for the game
 * @author Avikash Mishra
 *
 */
public class GameCanvas extends Canvas {


	private GameFrame parent;

	/**
	 * Constructs a new GameCanvas with the given width and height
	 * @param width The Width of the canvas
	 * @param height The Height of the canvas
	 */
	public GameCanvas(int width, int height, GameFrame parent) {
		super(parent.getWidth(), parent.getHeight());
		this.setBackground(Color.BLUE);
		this.parent = parent;
	}

	/**
	 * Draws everything.
	 */
	@Override
	public void paint(Graphics g){

	}



}
