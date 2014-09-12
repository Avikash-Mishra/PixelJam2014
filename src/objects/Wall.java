package objects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import tools.Animation;
import main.Constants;

public class Wall extends Tile {

	protected Wall(Animation anim, int x, int y) {
		super(anim, x, y);
	}

	public static Wall newWall(int x, int y){
		BufferedImage img;
		try {
			img = ImageIO.read(new File(Constants.ASSETS + "test_tile.jpg"));
			Animation anim = new Animation();
			anim.addFrame(img, 0);
			return new Wall(anim,x,y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static Wall newFloor(int x, int y){
		BufferedImage img;
		try {
			img = ImageIO.read(new File(Constants.ASSETS + "test_tile2.jpg"));
			Animation anim = new Animation();
			anim.addFrame(img, 0);
			return new Wall(anim,x,y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
