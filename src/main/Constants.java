package main;

import java.io.File;

import tools.Vector2D;

public class Constants {

	private Constants(){}

	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;
	public static final String ASSETS = "assets"+ File.separatorChar;
	public static final String LEVEL_FILENAME = ASSETS + "simple_file.txt";

	public static final Vector2D GRAVITY_VECTOR = new Vector2D(0,-2);

}
