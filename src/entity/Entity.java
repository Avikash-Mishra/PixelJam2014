package entity;

import java.awt.Graphics;

import main.Constants;
import tools.Animation;

/**
 * Will contain things like collision detection, drawing etc.
 * @author Mary
 */
public abstract class Entity{

	private Animation image;
	private int x;
	private int y;


	public Entity(Animation image, int x, int y){
		this.image = image;
		this.x = x;
		this.y = y;
	}


	public void draw(Graphics g) {
		g.drawImage(image.getImage() , x, y, Constants.TILE_WIDTH, Constants.TILE_HEIGHT, null);
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getWidth(){
		return Constants.TILE_WIDTH;
	}

	public int getHeight(){
		return Constants.TILE_HEIGHT;
	}

}
