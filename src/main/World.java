package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.Set;

import entity.Entity;
import entity.Player;
import gui.GameCanvas;
import objects.PickUpObject;
import objects.Tile;

public class World extends Thread{
	private List<Tile> map;
	private List<Entity> entities;
	private List<PickUpObject> pickups;
	private Player player;

	private static final long SECOND = 1000;
	private static final long UPDATE_INTERVAL = SECOND/(long)(10);


	public World(List<Entity> entities, List<Tile> map, List<PickUpObject> pickUps, Player player){
		this.map = map;
		this.entities = entities;
		this.pickups = pickUps;
		this.player = player;
	}

	public void draw(Graphics g, Dimension d){
		//Draw background
		drawBackground(g, d);
		//Draw the world
		for (Tile items: map){
			items.draw(g);
		}
		//Draw the characters
		for (Entity entity: entities){
			entity.draw(g);
		}
		//Draw Pick Ups
		for (PickUpObject items: pickups){
			items.draw(g);
		}

		//Draw Player
		if (player != null){
			player.draw(g);
		}
	}

	private void drawBackground(Graphics g, Dimension d){
		g.setColor(Color.blue);
		System.out.println(d);
		g.fillRect(0,0,d.width,d.height);
	}

	public void run(){
		long previousUpdate = 0;
		while (true){

			long timeElapsed = System.currentTimeMillis() - previousUpdate;
			if (timeElapsed > UPDATE_INTERVAL){
				player.update();
				previousUpdate = System.currentTimeMillis();
			}
			else{
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}


	}

}
