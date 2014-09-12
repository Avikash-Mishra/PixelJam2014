package main;

import java.awt.Graphics;
import java.util.List;
import java.util.Set;

import entity.Entity;
import objects.Tile;

public class World {
	private List<Tile> map;
	private List<Entity> entities;

	public World(List[] world){
		map = (List<Tile>) world[1];
		entities = (List<Entity>) world[0];
	}


	public void draw(Graphics g){

		//Draw the world
		for (Tile items: map){
			items.draw(g);
		}
		//Draw the characters
		for (Entity animals: entities){
			animals.draw(g);
		}

	}
}
