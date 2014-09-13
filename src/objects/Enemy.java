package objects;


import java.awt.Rectangle;
import java.util.List;

import main.Constants;
import tools.Utilities;
import tools.Vector2D;



public class Enemy extends Entity implements Danger{
	protected  int STEP_SIZE;
	protected  static long ANIMATION_DELAY;
	protected int initX;
	protected int moveLength;
	public Enemy(int x, int y) {
		super(x, y);
		this.movement = new Vector2D(5,0);
		this.initX = x;
		this.moveLength = 50;
		// TODO Auto-generated constructor stub
	}

	@Override
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

}
