package objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import main.Constants;

public abstract class PickUpObject{
	private int amount;
	private Image image;
	private int x;
	private int y;


	protected PickUpObject(Image image, int x, int y, int amount){
		this.image = image;
		this.x = x;
		this.y = y;
		this.amount = amount;
	}

	public void draw(Graphics g) {
		g.drawImage(image , x, y, Constants.TILE_WIDTH, Constants.TILE_WIDTH, null);
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}


	/**
	 * The amount of points if character picks it up
	 * @return
	 */
	public int getAmount(){
		return amount;
	}

}
