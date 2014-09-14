package objects;

import java.awt.Rectangle;
import java.util.List;

import main.Constants;
import tools.Utilities;
import tools.Vector2D;

/**
 * Entity represents some moving thing on the screen.
 * Will contain things like collision detection, drawing etc.
 * @author Mary
 */
public abstract class Entity extends GameObject{


	protected boolean grounded = true;
	protected Vector2D movement = new Vector2D(0,0);
	private static final Vector2D JUMP_VECTOR = new Vector2D(0,-10);

	public Entity(int x, int y){
		super(x,y);
	}

	/**
	 * Return a copy of this Entity's movement vector.
	 * @return a Vector2D
	 */
	public Vector2D getMovementVector(Vector2D movement){
		return new Vector2D(movement.x(),movement.y());
	}

	public void jump(){
		if (!grounded) return;
		movement = movement.add(JUMP_VECTOR);
	}

	/**
	 * Apply the movement vector to the position vector.
	 * @param tiles: list of all tiles in the map.
	 */
	public void step(List<Tile> tiles){

		// get nearby tiles
		List<Tile> nearby = Utilities.getNearby(position, tiles);

		// apply gravity
		applyGravity(nearby);

		// move
		if (movement.isZeroVector()) return;
		Vector2D start = getPosition();
		Vector2D goal = position.add(movement);
		float distBetween = Utilities.distance(position,goal);
		float distTravelled = 0;
		Vector2D pos = getPosition();
		Vector2D unit = movement.unitVector();

		// repeatedly add the unit vector onto the position until you either
		// move down the entire length of the movement vector or you collide
		// wit something
		while (

			distTravelled < distBetween // check you haven't travelled too far
			&&
			!(Utilities.colliding(new Rectangle( (int)pos.add(unit).x(),(int)pos.add(unit).y(),Constants.PLAYER_WIDTH,Constants.PLAYER_HEIGHT), nearby))) //check you haven't hit anything
		{
			pos=pos.add(unit);
			distTravelled++;
		}
		position = pos;

		// if you didn't move vertically, then you must have either
		// hit the ground or you're at the maximum of the jumping parabola
		// if you hit the ground, set velocity_y <-- 0
		if ((int)position.y() == (int)start.y()){
			if (grounded){
				movement.setY(0);
			}
		}

	}

	public void applyGravity(List<Tile> nearby){

		grounded = checkBelow(nearby,Direction.BELOW);

		if (!grounded && !movement.atTerminalVelocity()){
			movement = movement.add(Constants.GRAVITY_VECTOR);
		}

	}

	/**
	 * Check a list of tiles and return true if something is below, left, right, or above this entity.
	 * @param tilesToCheck: those tiles that should be checked. Get these by calling nearby method.
	 * @param dir: direction to check
	 * @return: list of tiles below, above, left, or right.
	 */
	private boolean checkBelow(List<Tile> tilesToCheck, Direction dir){

		Rectangle r = null;
		switch(dir){

		case ABOVE:
			r = new Rectangle(getX(),getY()-1,Constants.PLAYER_WIDTH,1);
			break;
		case LEFT:
			r = new Rectangle(getX()-1,getY(),1,Constants.PLAYER_HEIGHT);
			break;
		case RIGHT:
			r = new Rectangle(getX()+Constants.PLAYER_WIDTH+1,getY(),1,Constants.PLAYER_HEIGHT);
			break;
		case BELOW:
			r = new Rectangle(getX(),getY()+Constants.PLAYER_HEIGHT+1,Constants.PLAYER_WIDTH,1);

		}

		for (Tile tile : tilesToCheck){
			Rectangle bounding = tile.boundingBox();

			if (r.intersects(bounding)){
				//Fall through water?
				if (tile instanceof River){
					return false;
				}
				return true;
			}
		}
		return false;

	}

	private enum Direction{
		ABOVE,LEFT,RIGHT,BELOW;
	}

	/**
	 * Return true if the point (x,y) is a non-transparent pixel on this entity's image.
	 * @return boolean
	 */
	public boolean on(int x, int y){
		return Utilities.isPixelTransparent(x, y, animation.getImage());
	}

}
