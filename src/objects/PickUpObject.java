package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Constants;
import tools.Animation;
import gui.Camera;

public abstract class PickUpObject extends GameObject{
	protected int amount;

	private Animation animation;
	private boolean canPickUp = true;


	public PickUpObject(Animation animation, int x, int y, int amount){
		super(x,y);
		this.animation = animation;
		this.amount = amount;
	}

	@Override
	public void draw(Graphics g, Camera cam) {
		BufferedImage image = animation.getImage();
		if(canPickUp){
			g.drawImage(image , getX()-cam.getX(), getY()-cam.getY(), Constants.TILE_WIDTH, Constants.TILE_WIDTH, null);
		}
	}

	public abstract void onCollision(Player player);

	public boolean canPickUp(){
		return canPickUp;
	}

	public void pickup(){
		canPickUp = false;
	}


	/**
	 * The amount of points if character picks it up
	 * @return
	 */
	public int getAmount(){
		return amount;
	}

}
