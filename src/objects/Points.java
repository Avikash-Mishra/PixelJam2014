package objects;

import java.awt.Image;

import tools.Animation;
import tools.ImageLibrary;


public class Points extends PickUpObject {

	protected Points(Animation animation, int x, int y, int amount) {
		super(animation, x, y, amount);
		// TODO Auto-generated constructor stub
	}

	public static Points newPoints(int x, int y, int amount){
		Animation anim = new Animation();
		anim.addFrame(ImageLibrary.get("pointBubble1Spirte.png"), 0);
		return new Points(anim,x,y, amount);
	}

}
