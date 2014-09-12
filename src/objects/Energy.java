package objects;

import tools.Animation;
import entity.Player;


public class Energy extends PickUpObject {

	private Energy(Animation image, int x, int y, int amount) {
		super(image, x, y, amount);
		// TODO Auto-generated constructor stub
	}

	public static Energy newEnergy(){
		return null;
	}

	@Override
	public void onCollision(Player player) {
		// TODO Auto-generated method stub

	}



}
