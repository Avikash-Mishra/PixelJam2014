package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Constants;
import tools.Animation;
import entity.Player;

public abstract class PickUpObject{
	protected int amount;

	private Animation animation;
	private int x;
	private int y;
	private boolean canPickUp = true;



	protected PickUpObject(Animation animation, int x, int y, int amount){
		this.animation = animation;
		this.x = x;
		this.y = y;
		this.amount = amount;
	}

	public void draw(Graphics g) {
		BufferedImage image = animation.getImage();
		if(canPickUp){
			g.drawImage(image , x, y, Constants.TILE_WIDTH, Constants.TILE_WIDTH, null);
		}
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
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
