package objects;

import gui.Camera;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import tools.Animation;
import main.Constants;

public abstract class Tile extends GameObject{

	protected Tile(int x, int y){
		super(x,y);
	}

	@Override
	public void draw(Graphics g, Camera cam) {
		BufferedImage image = animation.getImage();
		g.drawImage(image , getX()-cam.getX(), getY()-cam.getY(), Constants.TILE_WIDTH, Constants.TILE_WIDTH, null);
	}

}
