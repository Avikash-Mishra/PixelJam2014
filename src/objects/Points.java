package objects;

import tools.Animation;
import entity.Player;

import tools.Animation;
import tools.ImageLibrary;


public class Points extends PickUpObject {

	public Points(Animation image, int x, int y, int amount) {
		super(image, x, y, amount);
	}

	@Override
	public void onCollision(Player player) {
		// TODO Auto-generated method stub

	}

	public static Points newPoints(int x, int y, int amount){
		Animation anim = new Animation();
		anim.addFrame(ImageLibrary.get("pointBubble1Spirte.png"), 0);
		return new Points(anim,x,y, amount);
	}

}
