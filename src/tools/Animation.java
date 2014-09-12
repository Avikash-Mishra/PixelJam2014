package tools;

import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {

	private List<BufferedImage> images = new ArrayList<BufferedImage>();
	private List<Long> times = new ArrayList<Long>();
	private boolean running = false;

	public Animation(){}

	public void addFrame(BufferedImage img, long stepTime){
		if(img!=null && !running){
			images.add(img);
			times.add(stepTime);
		}else if(running){
			System.err.println("Animations cannot be edited once started");
		}
	}


	private long startTime = 0;

	public void start(){
		running = true;
		startTime = System.currentTimeMillis();
	}

	public void stop(){
		running = false;
	}


	/**
	 * If this animation has been started, return the next image in the animation.
	 * Otherwise, return the first image.
	 * @return: a bufferedimage
	 */
	public BufferedImage getImage(){
		if(!running){
			return images.get(0);
		}else{
			long curTime = System.currentTimeMillis() - startTime;
			for(int i=0; i<times.size(); i++){
				if(curTime - times.get(i) <= 0){
					return images.get(i);
				}else{
					curTime -= times.get(i);
				}
			}
		}
		return images.get(images.size()-1);
	}

}
