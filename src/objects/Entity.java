package objects;

import gui.Camera;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import main.Constants;
import tools.Animation;
import tools.Utilities;
import tools.Vector2D;

/**
 * Entity represents some moving thing on the screen.
 * Will contain things like collision detection, drawing etc.
 * @author Mary
 */
public abstract class Entity extends GameObject{

	protected Rectangle ground; // the ground below player, or null if they're in the air
	protected Vector2D movement = new Vector2D(0,0);

	public Entity(int x, int y){
		super(x,y);
	}

	/**
	 * Return a copy of this Entity's movement vector.
	 * @return a Vector2D
	 */
	public Vector2D getMovementVector(){
		return new Vector2D(movement.x(),movement.y());
	}

	/**
	 * Apply the movement vector to the position vector.
	 * @param tiles: list of all tiles in the map.
	 */
	public void step(List<Tile> tiles){

		if (movement.isZeroVector()) return;
		Vector2D goal = position.add(movement);
		float distBetween = Utilities.distance(position,goal);
		float distTravelled = 0;
		Vector2D pos = getPosition();
		List<Tile> nearby = Utilities.getNearby(pos, tiles);
		Vector2D unit = movement.unitVector();

		while (
			distTravelled < distBetween // check you haven't travelled too far
			&&
			!(Utilities.colliding(new Rectangle( (int)pos.add(unit).x(),(int)pos.add(unit).y(),Constants.PLAYER_WIDTH,Constants.PLAYER_HEIGHT), nearby))) //check you haven't hit anything
		{
			pos=pos.add(unit);
			distTravelled++;
		}
		position = pos;

	}

	public boolean on(int x, int y){
		return Utilities.isPixelTransparent(x, y, animation.getImage());
	}

}
