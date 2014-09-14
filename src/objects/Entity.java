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

		// check the rectangle below your position that is PLAYER_WIDTH wide and 1 pixel high
		Rectangle r = new Rectangle(getX(),getY()+Constants.PLAYER_HEIGHT+1,Constants.PLAYER_WIDTH,1);
		boolean onGround = false;
		for (Tile tile : nearby){
			Rectangle bounding = tile.boundingBox();
			
			if (r.intersects(bounding)){
				//Fall through water?
				if (tile instanceof River){
					onGround = false;
					break;
				}
				onGround = true;
				
				break;
			}
		}

		grounded = onGround;

		if (!grounded && !movement.atTerminalVelocity()){
			movement = movement.add(Constants.GRAVITY_VECTOR);
		}

	}

	public boolean on(int x, int y){
		return Utilities.isPixelTransparent(x, y, animation.getImage());
	}

}
