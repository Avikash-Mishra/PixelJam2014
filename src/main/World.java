package main;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import entity.Entity;
import objects.Tile;

public class World {
	private HashSet<Tile> map;
	private HashSet<Entity> entities;

	public World(Set[] world){
		map = (HashSet<Tile>) world[1];
		entities = (HashSet<Entity>) world[0];
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
