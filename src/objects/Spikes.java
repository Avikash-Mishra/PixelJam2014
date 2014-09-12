package objects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Constants;
import tools.Animation;

public class Spikes extends Tile{

	protected Spikes(Animation anim, int x, int y) {
		super(anim, x, y);
	}

	public static Spikes newUpSpikes(int x, int y){
		BufferedImage img;
		try {
			img = ImageIO.read(new File(Constants.ASSETS + "test_tile.jpg"));
			Animation anim = new Animation();
			anim.addFrame(img, 0);
			return new Spikes(anim,x,y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Spikes newDownSpikes(){
		return null;
	}

	public static Spikes newRightSpikes(){
		return null;
	}

	public static Spikes newLeftSpikes(){
		return null;
	}

}
