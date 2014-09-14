package objects;

import java.awt.event.KeyEvent;

import main.Constants;
import tools.Animation;
import tools.DeathAnimation;
import tools.ImageLibrary;
import tools.Vector2D;

public class Player extends Entity {
	private static final int STEP_SIZE = 10;
	private static final long ANIMATION_DELAY = 100;


	public static Type type = Type.CAT;
	public int points = Constants.STARTING_POINTS;
	public int energy = Constants.STARTING_ENERGY;
	private static Animation prevAnimation;
	//transform
	private static Animation transform ;

	public static Animation death = new DeathAnimation();
	public static boolean dead = false;

	public Player(int x, int y) {
		super(x, y);
		//Transform
		transform = new Animation();
		transform.addFrame(ImageLibrary.get("transformSprite.png"), 1000);
		transform.start();
		death.addFrame(ImageLibrary.get("death1Sprite.png"), 100);
		death.addFrame(ImageLibrary.get("death2Sprite.png"), 100);
		death.addFrame(ImageLibrary.get("death3Sprite.png"), 100);
		death.addFrame(ImageLibrary.get("death4Sprite.png"), 100);
		death.addFrame(ImageLibrary.get("death5Sprite.png"), 100);
		this.animation = type.getAnimationStill(animation);
		this.prevAnimation = animation;
		animation.start();
		movement = new Vector2D(0,0);
	}

	public void move(int keycode){
		if(dead){
			movement.setX(0);
			this.animation = death;
			return;
		}
		if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A){
			movement.setX(-STEP_SIZE);
			this.animation = type.getAnimationLeft();
			this.prevAnimation = animation;
		}
		else if (keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D){
			movement.setX(STEP_SIZE);
			this.animation = type.getAnimationRight();
			this.prevAnimation = animation;
		}
	}

	public void stop(int keycode){
		if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D){
			movement.setX(0);
			this.animation = type.getAnimationStill(prevAnimation);
			this.prevAnimation = animation;
		}
	}


	public boolean atTerminalVelocity(){
		return movement.y() >= Constants.TERMINAL_VELOCITY.y();
	}

	public void transform(){
		if(dead){
			movement.setX(0);
			this.animation = death;
			return;
		}
		if (type == Type.CAT) type = Type.DOG;
		else type = Type.CAT;

		//Transform and then face correct direction
		this.prevAnimation = animation;
		this.animation = transform;
		((Thread) new Transform()).start();

	}


	public boolean isCat(){
		return type == Type.CAT;
	}

	private class Transform extends Thread{

		@Override
		public void run() {
			long time = System.currentTimeMillis();
			while(System.currentTimeMillis()-time<80){}
			animation = type.checkAnimationState(prevAnimation);
			prevAnimation = animation;
		}

	}

	public enum Type{
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
			if(dead){
				return death;
			}

			if (type == Type.CAT){
				return catAnimLeftWalking;
			} else {
				return dogAnimLeftWalking;
			}
		}

		public Animation getAnimationRight(){
			if(dead){
				return death;
			}
			if (type == Type.CAT){
				return catAnimRightWalking;
			} else {
				return dogAnimRightWalking;
			}
		}

		public Animation getAnimationStill(Animation animation){
			if(dead){
				return death;
			}
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

		public Animation checkAnimationState(Animation animation){
			if(dead){
				return death;
			}
			if (type == Type.CAT){
				if (animation == dogAnimLeftWalking){
					return catAnimLeftWalking;
				} else if (animation == dogAnimRightWalking){
					return catAnimRightWalking;
				} else if (animation == dogAnimLeftStatic){
					return catAnimLeftStatic;
				} else {
					return catAnimRightStatic;
				}
			} else {
				if (animation == catAnimLeftWalking){
					return dogAnimLeftWalking;
				} else if (animation == catAnimRightWalking){
					return dogAnimRightWalking;
				} else if (animation == catAnimLeftStatic){
					return dogAnimLeftStatic;
				} else {
					return dogAnimRightStatic;
				}
			}
		}

	}

	public void die() {
		this.animation = death;
		if(!dead){
			death.start();
		}
		dead = true;
	}

}
