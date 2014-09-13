package objects;

import java.awt.event.KeyEvent;

import main.Constants;
import tools.Animation;
import tools.ImageLibrary;
import tools.Vector2D;

public class Player extends Entity {


	private static final int STEP_SIZE = 10;
	private static final long ANIMATION_DELAY = 100;

	private Vector2D movement;
	public int points = Constants.STARTING_POINTS;
	public int energy = Constants.STARTING_ENERGY;

	private static Animation animLeftWalking;
	private static Animation animLeftStatic;
	private static Animation animRightStatic;
	private static Animation animRightWalking;

	static {
		animLeftWalking = new Animation();
		animLeftWalking.addFrame(ImageLibrary.get("LcatWalk1Sprite.png"), ANIMATION_DELAY);
		animLeftWalking.addFrame(ImageLibrary.get("LcatWalk2Sprite.png"), ANIMATION_DELAY);
		animLeftWalking.addFrame(ImageLibrary.get("LcatStaticSprite.png"), ANIMATION_DELAY);
		animLeftWalking.start();

		animRightWalking = new Animation();
		animRightWalking.addFrame(ImageLibrary.get("RcatWalk1Sprite.png"), ANIMATION_DELAY);
		animRightWalking.addFrame(ImageLibrary.get("RcatWalk2Sprite.png"), ANIMATION_DELAY);
		animRightWalking.addFrame(ImageLibrary.get("RcatStaticSprite.png"), ANIMATION_DELAY);
		animRightWalking.start();

		animLeftStatic = new Animation();
		animLeftStatic.addFrame(ImageLibrary.get("LcatStaticSprite.png"), ANIMATION_DELAY);

		animRightStatic = new Animation();
		animRightStatic.addFrame(ImageLibrary.get("RcatStaticSprite.png"),ANIMATION_DELAY);
	}

	public Player(int x, int y) {
		super(x, y);
		this.animation = animRightStatic;
		movement = new Vector2D(0,0);
	}

	public void move(int keycode){
		if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A){
			movement.setX(-STEP_SIZE);
			this.animation = animLeftWalking;
		}
		else if (keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D){
			movement.setX(STEP_SIZE);
			this.animation = animRightWalking;
		}
	}

	public void stop(int keycode){
		if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D){
			movement.setX(0);
			this.animation = (animation == animRightWalking) ? animRightStatic : animLeftStatic;
		}
	}

	public void jump(){
		System.out.println("jumped");
	}

	public void transform(){
		System.out.println("transform");
	}

	public void updatePosition(){
		this.position = position.add(movement);
	}

	public void revertPosition(){
		this.position = position.sub(movement);
	}

}
