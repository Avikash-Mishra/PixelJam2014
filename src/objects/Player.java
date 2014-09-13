package objects;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;

import main.Constants;
import main.Utilities;
import tools.Animation;
import tools.ImageLibrary;
import tools.Vector2D;

public class Player extends Entity {
	private static final int STEP_SIZE = 10;
	private static final long ANIMATION_DELAY = 100;
	private static final Vector2D JUMP_VECTOR = new Vector2D(0,-10);

	private boolean onGround = true;
	private static Type type = Type.CAT;
	public int points = Constants.STARTING_POINTS;
	public int energy = Constants.STARTING_ENERGY;


	public Player(int x, int y) {
		super(x, y);
		this.animation = type.getAnimationStill(animation);
		movement = new Vector2D(0,0);
	}

	public void move(int keycode){
		if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A){
			movement.setX(-STEP_SIZE);
			System.out.println("facing left");
			this.animation = type.getAnimationLeft();
		}
		else if (keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D){
			movement.setX(STEP_SIZE);
			System.out.println("facing right");
			this.animation = type.getAnimationRight();
		}
	}


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


	public void stop(int keycode){
		if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D){
			movement.setX(0);
			this.animation = type.getAnimationStill(animation);
		}
	}

	public void jump(){
		if (!onGround) return;
		movement = movement.add(JUMP_VECTOR);
	}

	private boolean atTerminalVelocity(){
		return movement.y() >= Constants.TERMINAL_VELOCITY.y();
	}

	/**
	 * Set true/false whether the player is touching a solid ground on which they may stand.
	 * @param bool
	 * @return
	 */
	public void setIsOnGround(boolean bool){
		if (bool != onGround) System.out.println( ( bool ? "on ground" : "in air" ) );
		onGround = bool;
	}

	public void applyGravity(){


		if (!onGround){

			if (!atTerminalVelocity()){
				movement = movement.add(Constants.GRAVITY_VECTOR);
			}

		}

	}




	public void transform(){
		//Need enough energy
		//if (energy >= 0){
			if (type == Type.CAT){
				type = Type.DOG;
				//facing left
				if (animation == Type.catAnimLeftWalking){
					this.animation = type.getAnimationLeft();
					System.out.println("WORKING");
				}


			} else {
				type = Type.CAT;
				if (animation == Type.dogAnimLeftWalking){
					this.animation = type.getAnimationRight();
				}

			}
			this.animation = type.getAnimationMoving(animation);
		//}
		System.out.println("transform");
	}

	private enum Type{
		DOG, CAT;
		//Cat
		private static Animation catAnimLeftWalking;
		private static Animation catAnimLeftStatic;
		private static Animation catAnimRightStatic;
		private static Animation catAnimRightWalking;
		//Dog
		private static Animation dogAnimLeftWalking;
		private static Animation dogAnimLeftStatic;
		private static Animation dogAnimRightStatic;
		private static Animation dogAnimRightWalking;

		static {
			//Cat
			catAnimLeftWalking = new Animation();
			catAnimLeftWalking.addFrame(ImageLibrary.get("LcatWalk1Sprite.png"), ANIMATION_DELAY);
			catAnimLeftWalking.addFrame(ImageLibrary.get("LcatWalk2Sprite.png"), ANIMATION_DELAY);
			catAnimLeftWalking.addFrame(ImageLibrary.get("LcatStaticSprite.png"), ANIMATION_DELAY);
			catAnimLeftWalking.start();

			catAnimRightWalking = new Animation();
			catAnimRightWalking.addFrame(ImageLibrary.get("RcatWalk1Sprite.png"), ANIMATION_DELAY);
			catAnimRightWalking.addFrame(ImageLibrary.get("RcatWalk2Sprite.png"), ANIMATION_DELAY);
			catAnimRightWalking.addFrame(ImageLibrary.get("RcatStaticSprite.png"), ANIMATION_DELAY);
			catAnimRightWalking.start();

			catAnimLeftStatic = new Animation();
			catAnimLeftStatic.addFrame(ImageLibrary.get("LcatStaticSprite.png"), ANIMATION_DELAY);

			catAnimRightStatic = new Animation();
			catAnimRightStatic.addFrame(ImageLibrary.get("RcatStaticSprite.png"),ANIMATION_DELAY);
			//Dog
			dogAnimLeftWalking = new Animation();
			dogAnimLeftWalking.addFrame(ImageLibrary.get("LdogWalk1Sprite.png"), ANIMATION_DELAY);
			dogAnimLeftWalking.addFrame(ImageLibrary.get("LdogWalk2Sprite.png"), ANIMATION_DELAY);
			dogAnimLeftWalking.addFrame(ImageLibrary.get("LdogStaticSprite.png"), ANIMATION_DELAY);
			dogAnimLeftWalking.start();

			dogAnimRightWalking = new Animation();
			dogAnimRightWalking.addFrame(ImageLibrary.get("RdogWalk1Sprite.png"), ANIMATION_DELAY);
			dogAnimRightWalking.addFrame(ImageLibrary.get("RdogWalk2Sprite.png"), ANIMATION_DELAY);
			dogAnimRightWalking.addFrame(ImageLibrary.get("RdogStaticSprite.png"), ANIMATION_DELAY);
			dogAnimRightWalking.start();

			dogAnimLeftStatic = new Animation();
			dogAnimLeftStatic.addFrame(ImageLibrary.get("LdogStaticSprite.png"), ANIMATION_DELAY);

			dogAnimRightStatic = new Animation();
			dogAnimRightStatic.addFrame(ImageLibrary.get("RdogStaticSprite.png"),ANIMATION_DELAY);
		}

		public Animation getAnimationLeft(){
			if (type == Type.CAT){
				return catAnimLeftWalking;
			} else {
				return dogAnimLeftWalking;
			}
		}

		public Animation getAnimationRight(){
			if (type == Type.CAT){
				return catAnimRightWalking;
			} else {
				return dogAnimRightWalking;
			}
		}

		public Animation getAnimationStill(Animation animation){
			if (type == Type.CAT){
				if (animation == catAnimLeftWalking){
					return catAnimLeftStatic;
				} else {
					return catAnimRightStatic;
				}
			}
			else {
				if (animation == dogAnimLeftWalking){
					return dogAnimLeftStatic;
				} else {
					return dogAnimRightStatic;
				}
			}
		}

		public Animation getAnimationMoving(Animation animation){
			if (type == Type.CAT){
				if (animation == catAnimLeftWalking){
					return catAnimLeftWalking;
				} else {
					return catAnimRightWalking;
				}
			} else {
				if (animation == dogAnimLeftWalking){
					return dogAnimLeftWalking;
				} else {
					return dogAnimRightWalking;
				}
			}
		}


	}

}
