package objects;

import gui.Camera;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.text.Position;

import tools.Animation;
import tools.Vector2D;
import main.Constants;

public abstract class GameObject {

	protected Animation animation;
	protected Vector2D position;

	public GameObject(int x, int y){
		position = new Vector2D(x*Constants.TILE_WIDTH,y*Constants.TILE_HEIGHT);
	}

	public void draw(Graphics g, Camera cam) {
		g.drawImage(animation.getImage() , getX() - cam.getX(), getY() - cam.getY(), Constants.TILE_WIDTH, Constants.TILE_HEIGHT, null);
	}

	public int getX(){
		return position.x();
	}

	public int getY(){
		return position.y();
	}

}
