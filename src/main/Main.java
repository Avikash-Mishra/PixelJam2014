package main;

import entity.Entity;
import entity.Player;
import gui.GameFrame;

import java.io.IOException;
import java.util.List;

import objects.PickUpObject;
import objects.Tile;

public class Main {

	public static void main(String[] args){

		try{
			Object[] data = Parser.parse(Constants.LEVEL_FILENAME);
			new GameFrame( (List<Entity>)data[0], (List<Tile>)data[1], (List<PickUpObject>)data[2], (Player)data[3]);

		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("ERROR LOADING FILE, ABORTING");
			System.exit(1);
		}

	}
}
