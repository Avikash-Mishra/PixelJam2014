package entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import objects.Tile;
import main.Constants;

/**
 * Will contain things like collision detection, drawing etc.
 * @author Mary
 */
public abstract class Entity extends Tile{

	public Entity(Image image, int x, int y) {
		super(image, x, y);
		// TODO Auto-generated constructor stub
	}

}
