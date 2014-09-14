package objects;

import java.awt.Image;
import java.awt.image.BufferedImage;

import tools.Animation;
import tools.ImageLibrary;

public class DogEnemy extends Enemy {
	//Dog
	private static Animation dogAnimLeftWalking;
	private static Animation dogAnimLeftStatic;
	private static Animation dogAnimRightStatic;
	private static Animation dogAnimRightWalking;


	public DogEnemy(int x, int y) {
		super(x, y);
		this.animation = dogAnimRightStatic;
		//this.animation.start();
		this.ANIMATION_DELAY = 100;
		this.STEP_SIZE = 10;
	}
	static {
	//Dog
	dogAnimLeftWalking = new Animation();
	dogAnimLeftWalking.addFrame(ImageLibrary.get("LdogWalk1Sprite.png"), ANIMATION_DELAY);
	dogAnimLeftWalking.addFrame(ImageLibrary.get("LdogWalk2Sprite.png"), ANIMATION_DELAY);
	dogAnimLeftWalking.addFrame(ImageLibrary.get("LdogStaticSprite.png"), ANIMATION_DELAY);
	dogAnimLeftWalking.start();

	dogAnimRightWalking = new Animation();
	dogAnimRightWalking.addFrame(ImageLibrary.get("RdogWalk1Sprite.png"), ANIMATION_DELAY);
	dogAnimRightWalking.addFrame(ImageLibrary.get("RdogWalk2Sprite.png"), ANIMATION_DELAY);
	dogAnimRightWalking.addFrame(ImageLibrary.get("RdogStaticSprite.png"), ANIMATION_DELAY);
	dogAnimRightWalking.start();

	dogAnimLeftStatic = new Animation();
	dogAnimLeftStatic.addFrame(ImageLibrary.get("LdogStaticSprite.png"), ANIMATION_DELAY);

	dogAnimRightStatic = new Animation();
	dogAnimRightStatic.addFrame(ImageLibrary.get("RdogStaticSprite.png"),ANIMATION_DELAY);
	}


}
