package objects;

import java.awt.Image;
import java.awt.image.BufferedImage;

import tools.Animation;
import tools.ImageLibrary;


public class River extends Tile{

	protected River(Animation anim, int x, int y) {
		super(anim, x, y);
	}

	public static River newRiver(int x, int y){
		Animation anim = new Animation();
		anim.addFrame(ImageLibrary.get("test_tile.jpg"), 0);
		return new River(anim,x,y);
	}

}
