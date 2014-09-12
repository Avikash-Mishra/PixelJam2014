package objects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Constants;
import tools.Animation;
import tools.ImageLibrary;

public class Spikes extends Tile{

	protected Spikes(Animation anim, int x, int y) {
		super(anim, x, y);
	}

	public static Spikes newUpSpikes(int x, int y){
		Animation anim = new Animation();
		anim.addFrame(ImageLibrary.get("spikeTopSprite.png"), 0);
		return new Spikes(anim,x,y);
	}

	public static Spikes newDownSpikes(int x, int y){
		Animation anim = new Animation();
		anim.addFrame(ImageLibrary.get("spikeBottomSprite.png"), 0);
		return new Spikes(anim,x,y);
	}

	public static Spikes newRightSpikes(int x, int y){
		Animation anim = new Animation();
		anim.addFrame(ImageLibrary.get("spikeRightSprite.png"), 0);
		return new Spikes(anim,x,y);
	}

	public static Spikes newLeftSpikes(int x, int y){
		Animation anim = new Animation();
		anim.addFrame(ImageLibrary.get("spikeLeftSprite.png"), 0);
		return new Spikes(anim,x,y);
	}

}
