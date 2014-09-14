package objects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ObjectInputStream.GetField;

import tools.Animation;
import tools.ImageLibrary;

public class CatEnemy extends Enemy {
	//Cat
	private static Animation catAnimLeftWalking;
	private static Animation catAnimLeftStatic;
	private static Animation catAnimRightStatic;
	private static Animation catAnimRightWalking;

	public CatEnemy(int x, int y) {
		super(x, y);
		this.animation = catAnimRightStatic;
		//this.animation.start();
		this.ANIMATION_DELAY = 100;
		this.STEP_SIZE = 10;

	}

	static {
		//Cat
		catAnimLeftWalking = new Animation();
		catAnimLeftWalking.addFrame(ImageLibrary.get("LcatWalk1Sprite.png"), ANIMATION_DELAY );
		catAnimLeftWalking.addFrame(ImageLibrary.get("LcatWalk2Sprite.png"), ANIMATION_DELAY);
		catAnimLeftWalking.addFrame(ImageLibrary.get("LcatStaticSprite.png"), ANIMATION_DELAY);
		catAnimLeftWalking.start();

		catAnimRightWalking = new Animation();
		catAnimRightWalking.addFrame(ImageLibrary.get("RcatWalk1Sprite.png"), ANIMATION_DELAY);
		catAnimRightWalking.addFrame(ImageLibrary.get("RcatWalk2Sprite.png"), ANIMATION_DELAY);
		catAnimRightWalking.addFrame(ImageLibrary.get("RcatStaticSprite.png"), ANIMATION_DELAY);
		catAnimRightWalking.start();

		catAnimLeftStatic = new Animation();
		catAnimLeftStatic.addFrame(ImageLibrary.get("LcatStaticSprite.png"), ANIMATION_DELAY);

		catAnimRightStatic = new Animation();
		catAnimRightStatic.addFrame(ImageLibrary.get("RcatStaticSprite.png"),ANIMATION_DELAY);
	}
}
