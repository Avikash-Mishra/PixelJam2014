package main;

import java.awt.Graphics;
import java.util.HashSet;

import objects.Tile;

public class World {
	private HashSet<Tile> map = new HashSet<Tile>();


	public World(){


	}


	public void draw(Graphics g){

		//Draw the world
		for (Tile items: map){
			items.draw(g);
		}

	}
}
