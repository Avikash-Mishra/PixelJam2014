package Objects;

import java.awt.Graphics;
import java.awt.Image;

import Main.Constants;

public abstract class Tile {
	private Image image;
	private int x;
	private int y;


	public Tile(Image image, int x, int y){
		this.image = image;
		this.x = x;
		this.y = y;
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
}
