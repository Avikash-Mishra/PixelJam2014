package entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import objects.Tile;
import tools.Vector2D;
import main.Constants;

/**
 * Will contain things like collision detection, drawing etc.
 * @author Mary
 */
public abstract class Entity{

	private Image image;
	protected Vector2D position;

	public Entity(Image image, int x, int y){
		this.image = image;
		position = new Vector2D(x*Constants.TILE_WIDTH,y*Constants.TILE_WIDTH);
	}


	public void draw(Graphics g) {
		g.drawImage(image , position.x(), position.y(), image.getWidth(null), image.getHeight(null), null);
	}

	public int getX(){
		return position.x();
	}

	public int getY(){
		return position.y();
	}

	public int getWidth(){
		return image.getWidth(null);
	}

	public int getHeight(){
		return image.getHeight(null);
	}

}
