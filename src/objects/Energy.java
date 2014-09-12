package objects;

import tools.Animation;
import entity.Player;

import tools.Animation;
import tools.ImageLibrary;


public class Energy extends PickUpObject {

<<<<<<< HEAD
	private Energy(Animation image, int x, int y, int amount) {
		super(image, x, y, amount);
=======


	protected Energy(Animation animation, int x, int y, int amount) {
		super(animation, x, y, amount);
>>>>>>> 8d9b7357f882573c72aa303b0efaedf374df95f4
		// TODO Auto-generated constructor stub
	}

	public static Energy newEnergy(int x, int y, int amount){
		Animation anim = new Animation();
		anim.addFrame(ImageLibrary.get("energy1Sprite.png"), 0);
		return new Energy(anim,x,y, amount);
	}

	@Override
	public void onCollision(Player player) {
		// TODO Auto-generated method stub

	}



}
