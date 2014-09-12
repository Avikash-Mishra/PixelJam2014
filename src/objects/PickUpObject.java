package objects;

import java.awt.Graphics;

import tools.Animation;
import main.Constants;
import tools.Animation;
import entity.Player;

public abstract class PickUpObject{
	private int amount;
<<<<<<< HEAD
	private Animation image;
=======
	private Animation animation;
>>>>>>> 8d9b7357f882573c72aa303b0efaedf374df95f4
	private int x;
	private int y;


<<<<<<< HEAD
	protected PickUpObject(Animation image, int x, int y, int amount){
		this.image = image;
=======
	protected PickUpObject(Animation animation, int x, int y, int amount){
		this.animation = animation;
>>>>>>> 8d9b7357f882573c72aa303b0efaedf374df95f4
		this.x = x;
		this.y = y;
		this.amount = amount;
	}

	public void draw(Graphics g) {
<<<<<<< HEAD
		g.drawImage(image.getImage() , x, y, Constants.TILE_WIDTH, Constants.TILE_WIDTH, null);
=======
		BufferedImage image = animation.getImage();
		g.drawImage(image , x, y, Constants.TILE_WIDTH, Constants.TILE_WIDTH, null);
>>>>>>> 8d9b7357f882573c72aa303b0efaedf374df95f4
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
