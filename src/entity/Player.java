package entity;

import java.awt.event.KeyEvent;

import tools.Animation;
import tools.ImageLibrary;
import tools.Vector2D;

public class Player extends Entity {


	private static final int STEP_SIZE = 10;

	private Vector2D movement;
	public int points = 0;
	public int energy = 0;

	public Player(int x, int y) {
		super(x, y);
		//Set up animation for player
		this.image = new Animation();
		image.addFrame(ImageLibrary.get("RcatWalk1Sprite.png"), 100);
		image.addFrame(ImageLibrary.get("RcatWalk2Sprite.png"), 100);
		image.addFrame(ImageLibrary.get("RcatStaticSprite.png"), 100);
		image.addFrame(ImageLibrary.get("LcatWalk1Sprite.png"), 100);
		image.addFrame(ImageLibrary.get("LcatWalk2Sprite.png"), 100);
		image.addFrame(ImageLibrary.get("LcatStaticSprite.png"), 100);
		movement = new Vector2D(0,0);
	}

	public void move(int keycode){
		if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A){
			System.out.println("left");
			movement.setX(-STEP_SIZE);
		}
		else if (keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D){
			System.out.println("right");
			movement.setX(STEP_SIZE);
		}
	}

	public void stop(int keycode){
		if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D){
			movement.setX(0);
		}
	}

	public void jump(){
		System.out.println("jumped");
	}

	public void transform(){
		System.out.println("transform");
	}

	public void update(){
		this.position = position.add(movement);
	}

}
