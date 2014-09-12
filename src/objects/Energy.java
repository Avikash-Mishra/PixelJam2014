package objects;

import java.awt.Image;
import java.awt.image.BufferedImage;

import tools.Animation;
import tools.ImageLibrary;


public class Energy extends PickUpObject {



	protected Energy(Animation animation, int x, int y, int amount) {
		super(animation, x, y, amount);
		// TODO Auto-generated constructor stub
	}

	public static Energy newEnergy(int x, int y, int amount){
		Animation anim = new Animation();
		anim.addFrame(ImageLibrary.get("energy1Sprite.png"), 0);
		return new Energy(anim,x,y, amount);
	}



}
