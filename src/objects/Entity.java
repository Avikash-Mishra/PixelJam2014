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
		Vector2D goal = position.add(movement);
		float distBetween = Utilities.distance(position,goal);
		float distTravelled = 0;
		float distTravelledY = 0;
		Vector2D pos = getPosition();
		Vector2D unit = movement.unitVector();

		while (
			distTravelled < distBetween // check you haven't travelled too far
			&&
			!(Utilities.colliding(new Rectangle( (int)pos.add(unit).x(),(int)pos.add(unit).y(),Constants.PLAYER_WIDTH,Constants.PLAYER_HEIGHT), nearby))) //check you haven't hit anything
		{
			pos=pos.add(unit);
			distTravelled++;
			distTravelledY+=unit.y();
		}
		position = pos;

		if (distTravelledY == 0){
			movement.setY(0);
		}

		System.out.println(movement);
		
	}

	public void applyGravity(List<Tile> nearby){

		// check the rectangle below your position that is PLAYER_WIDTH wide and 1 pixel high
		Rectangle r = new Rectangle(getX(),getY()+Constants.PLAYER_HEIGHT+1,Constants.PLAYER_WIDTH,1);
		boolean onGround = false;
		for (Tile tile : nearby){
			Rectangle bounding = tile.boundingBox();
			if (r.intersects(bounding)){
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
