package Entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Main.Constants;

/**
 * Will contain things like collision detection, drawing etc.
 * @author Mary
 */
public abstract class Entity {
	private BufferedImage image;
	private int x;
	private int y;


	public Entity(BufferedImage image, int x, int y){
		this.image = image;
		this.x = x;
		this.y = y;
	}


	public void draw(Graphics g) {
		g.drawImage(image , x, y, Constants.TILE_WIDTH, Constants.TILE_WIDTH, null);
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
}
