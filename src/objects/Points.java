package objects;

import main.Constants;
import tools.Animation;
import tools.Animation;
import tools.ImageLibrary;


public class Points extends PickUpObject {

	public Points(Animation image, int x, int y, int amount) {
		super(image, x, y, amount);
	}

	@Override
	public void onCollision(Player player) {
		if(canPickUp()){
			pickup();
			player.points += amount;
			player.points = Math.min(player.points, Constants.MAX_ENERGY);
		}
	}

	public static Points newPoints(int x, int y, int amount){
		Animation anim = new Animation();
		anim.addFrame(ImageLibrary.get("pointBubble1Sprite.png"), 0);
		return new Points(anim,x,y, amount);
	}

}
