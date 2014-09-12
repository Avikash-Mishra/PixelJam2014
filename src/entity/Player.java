package entity;

import java.awt.Image;
import java.awt.event.KeyEvent;

import tools.Vector2D;

public class Player extends Entity {

	private Vector2D movement;
	private static final int STEP_SIZE = 1;

	public Player(Image image, int x, int y) {
		super(image, x, y);
		movement = new Vector2D(0,0);
	}

	public void move(int keycode){
		if (keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_A){
			System.out.println("left");
			movement.setX(STEP_SIZE);
		}
		else if (keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_D){
			System.out.println("right");
			movement.setX(-STEP_SIZE);
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
