package objects;

import gui.Camera;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Constants;
import tools.Animation;
import tools.Vector2D;

/**
 * Will contain things like collision detection, drawing etc.
 * @author Mary
 */
public abstract class Entity extends GameObject{

	protected Rectangle ground; // the ground below player, or null if they're in the air

	public Entity(int x, int y){
		super(x,y);
	}

}
