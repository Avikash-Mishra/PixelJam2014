package Objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Constants;

public abstract class PickUpObject {
	private BufferedImage image;
	private int x;
	private int y;
	private int amount;


	public PickUpObject(BufferedImage image, int x, int y, int amount){
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

	public int getAmount(){
		return amount;
	}

}
