package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import objects.Energy;
import objects.PickUpObject;
import objects.River;
import objects.Spikes;
import objects.Tile;
import objects.Wall;
import entity.Entity;

/**
 * Parses game levels and returns sets of the things in it. Should not be instantiated. Use its public static methods.
 * @author craigaaro
 */
public class Parser {

	private Parser(){}


	private static final char CLOUDS = 'C';
	private static final char BACKGROUND = '*';
	private static final char TILE = 'I';
	private static final char WALL = 'W';
	private static final char RIVER = 'V';
	private static final char ENERGY = 'E';
	private static final char SPIKE_UP = 'U';
	private static final char SPIKE_LEFT = 'L';
	private static final char SPIKE_DOWN = 'D';
	private static final char SPIKE_RIGHT = 'R';


	private static int col = 0;
	private static int row = 0;

	private class ParserList extends ArrayList{



	}

	/**
	 * Takes a file name, reads the level described in that file, and then returns a
	 * 2-element array where:
	 *  - array[0] is a set of entities
	 *  - array[1] is a set of tiles.
	 * @param filename: name of file containing the level.
	 * @return a 2-element array with a set of entities and a set of tiles.
	 * @throws IOException: if there is an error in parsing
	 */
	public static Set[] parse(String filename) throws IOException{

		// File loading
		File file = new File(filename);
		Scanner scan = null;
		try{
			scan = new Scanner(file);
		}
		catch(IOException e){
			throw new IOException("Failed reading file: " + filename);
		}

		// Initialise variables
		Set<Entity> entities = new HashSet<>();
		Set<Tile> tiles = new HashSet<>();
		Set<PickUpObject> pickups = new HashSet<>();
		row = 0;
		col = 0;

		try{
		// Parsing
		while (scan.hasNextLine()){

			char[] line = scan.nextLine().toCharArray();
			for (col = 0; col < line.length; col++){
				char c = line[col];
				switch(c){
				case CLOUDS:
					System.out.println("CLOUD LOADING NOT YET IMPLEMENTED");
					break;
				case BACKGROUND:
					System.out.println("BACKGROUND LOADING NOT YET IMPLEMENTED");
					break;
				case TILE:
					Wall floor = Wall.newFloor();
					tiles.add(floor);
					break;
				case WALL:
					Wall wall = Wall.newWall();
					tiles.add(wall);
					break;
				case SPIKE_UP:
					Spikes upSpikes = Spikes.newUpSpikes();
					tiles.add(upSpikes);
					break;
				case SPIKE_DOWN:
					Spikes downSpikes = Spikes.newDownSpikes();
					tiles.add(downSpikes);
					break;
				case SPIKE_RIGHT:
					Spikes rightSpikes = Spikes.newRightSpikes();
					tiles.add(rightSpikes);
					break;
				case SPIKE_LEFT:
					Spikes leftSpikes = Spikes.newLeftSpikes();
					tiles.add(leftSpikes);
					break;
				case RIVER:
					River river = River.newRiver();
					tiles.add(river);
					break;
				case ENERGY:
					Energy energy = Energy.newEnergy();
					pickups.add(energy);
					break;
				default:
					throw new IOException("Invalid character " + c + " found when parsing " + getPosition());
				}
			}
			row++;
		}
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new ArrayIndexOutOfBoundsException("Out of bounds while parsing at " + getPosition());
		}

		//finished
		return new Set[]{ entities, tiles, pickups };

	}

	/**
	 * Return a formatted string describing the point given.
	 * @param col
	 * @param row
	 * @return
	 */
	private static String getPosition(){
		return "("+col+","+row+")";
	}

}
