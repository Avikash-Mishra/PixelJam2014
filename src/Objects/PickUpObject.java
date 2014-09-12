package Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Main.Constants;

public abstract class PickUpObject extends Tile{
	private int amount;

	public PickUpObject(Image image, int x, int y, int amount) {
		super(image, x, y);
		this.amount = amount;
		// TODO Auto-generated constructor stub
	}

	/**
	 * The amount of points if character picks it up
	 * @return
	 */
	public int getAmount(){
		return amount;
	}

}
