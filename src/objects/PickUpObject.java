package objects;

import java.awt.Graphics;

import main.Constants;
import tools.Animation;
import entity.Player;

public abstract class PickUpObject{
	private int amount;
	private Animation image;
	private int x;
	private int y;


	protected PickUpObject(Animation image, int x, int y, int amount){
		this.image = image;
		this.x = x;
		this.y = y;
		this.amount = amount;
	}

	public void draw(Graphics g) {
		g.drawImage(image.getImage() , x, y, Constants.TILE_WIDTH, Constants.TILE_WIDTH, null);
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public abstract void onCollision(Player player);


	/**
	 * The amount of points if character picks it up
	 * @return
	 */
	public int getAmount(){
		return amount;
	}

}
