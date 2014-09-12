package entity;

import java.awt.Graphics;

<<<<<<< HEAD
=======
import objects.Tile;
import tools.Vector2D;
>>>>>>> 8d9b7357f882573c72aa303b0efaedf374df95f4
import main.Constants;
import tools.Animation;

/**
 * Will contain things like collision detection, drawing etc.
 * @author Mary
 */
public abstract class Entity{

<<<<<<< HEAD
	private Animation image;
	private int x;
	private int y;

=======
	private Image image;
	protected Vector2D position;
>>>>>>> 8d9b7357f882573c72aa303b0efaedf374df95f4

	public Entity(Animation image, int x, int y){
		this.image = image;
		position = new Vector2D(x*Constants.TILE_WIDTH,y*Constants.TILE_WIDTH);
	}


	public void draw(Graphics g) {
<<<<<<< HEAD
		g.drawImage(image.getImage() , x, y, Constants.TILE_WIDTH, Constants.TILE_HEIGHT, null);
=======
		g.drawImage(image , position.x(), position.y(), image.getWidth(null), image.getHeight(null), null);
>>>>>>> 8d9b7357f882573c72aa303b0efaedf374df95f4
	}

	public int getX(){
		return position.x();
	}

	public int getY(){
		return position.y();
	}

	public int getWidth(){
		return Constants.TILE_WIDTH;
	}

	public int getHeight(){
		return Constants.TILE_HEIGHT;
	}

}
