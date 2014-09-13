package entity;

import java.awt.Graphics;

import objects.GameObject;
import objects.Tile;
import tools.Vector2D;
import main.Constants;
import tools.Animation;

/**
 * Will contain things like collision detection, drawing etc.
 * @author Mary
 */
public abstract class Entity extends GameObject{
	protected Animation animation;
	protected Vector2D position;

	public Entity(int x, int y){
		position = new Vector2D(x*Constants.TILE_WIDTH,y*Constants.TILE_WIDTH);
	}


	public void draw(Graphics g) {
		System.out.println(getX() + "," + getY());
		g.drawImage(animation.getImage() , getX(), getY(), Constants.TILE_WIDTH, Constants.TILE_HEIGHT, null);
	}

	public int getX(){
		return position.x();
	}

	public int getY(){
		return position.y();
	}

	public int getWidth(){
		return Constants.TILE_WIDTH;
	}

	public int getHeight(){
		return Constants.TILE_HEIGHT;
	}


}
