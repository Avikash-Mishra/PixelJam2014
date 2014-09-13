package objects;

import gui.Camera;

import java.awt.Graphics;

import main.Constants;
import tools.Animation;
import tools.Vector2D;

/**
 * Will contain things like collision detection, drawing etc.
 * @author Mary
 */
public abstract class Entity extends GameObject{

	public Entity(int x, int y){
		super(x,y);
	}

}
