package objects;

import gui.Camera;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import tools.Animation;
import main.Constants;

public abstract class Tile extends GameObject{
	private Animation animation;
	private int x;
	private int y;


	protected Tile(Animation anim, int x, int y){
		this.animation = anim;
		this.x = x * Constants.TILE_WIDTH;
		this.y = y * Constants.TILE_HEIGHT;
	}


	public void draw(Graphics g, Camera cam) {
		BufferedImage image = animation.getImage();
		g.drawImage(image , x-cam.getX(), y-cam.getY(), Constants.TILE_WIDTH, Constants.TILE_WIDTH, null);
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
}
