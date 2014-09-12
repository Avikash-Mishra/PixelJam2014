package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import objects.Energy;
import objects.PickUpObject;
import objects.River;
import objects.Spikes;
import objects.Tile;
import objects.Wall;
import entity.Entity;

/**
 * Parses game levels and returns Lists of the things in it. Should not be instantiated. Use its public static methods.
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

	public static class ParserList<E> extends ArrayList<E>{

		public boolean insert(E item) throws IOException{
			if (item == null) throw new IOException("Error loading - added null at " + getPosition());
			return super.add(item);
		}

	}

	/**
	 * Takes a file name, reads the level described in that file, and then returns a
	 * 2-element array where:
	 *  - array[0] is a List of entities
	 *  - array[1] is a List of tiles.
	 * @param filename: name of file containing the level.
	 * @return a 2-element array with a List of entities and a List of tiles.
	 * @throws IOException: if there is an error in parsing
	 */
	public static List[] parse(String filename) throws IOException{

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
		ParserList<Entity> entities = new ParserList<>();
		ParserList<Tile> tiles = new ParserList<>();
		ParserList<PickUpObject> pickups = new ParserList<>();
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
					//System.out.println("CLOUD LOADING NOT YET IMPLEMENTED");
					break;
				case BACKGROUND:
					break;
				case TILE:
					Wall floor = Wall.newFloor(col,row);
					tiles.insert(floor);
					break;
				case WALL:
					Wall wall = Wall.newWall(col,row);
					tiles.insert(wall);
					break;
				case SPIKE_UP:
					Spikes upSpikes = Spikes.newUpSpikes(col, row);
					tiles.insert(upSpikes);
					break;
				case SPIKE_DOWN:
					Spikes downSpikes = Spikes.newDownSpikes();
					tiles.insert(downSpikes);
					break;
				case SPIKE_RIGHT:
					Spikes rightSpikes = Spikes.newRightSpikes();
					tiles.insert(rightSpikes);
					break;
				case SPIKE_LEFT:
					Spikes leftSpikes = Spikes.newLeftSpikes();
					tiles.insert(leftSpikes);
					break;
				case RIVER:
					River river = River.newRiver();
					tiles.insert(river);
					break;
				case ENERGY:
					Energy energy = Energy.newEnergy();
					pickups.insert(energy);
					break;
				default:
					throw new IOException("Invalid character " + c + " found when parsing " + getPosition());
				}
			}
			row++;
		}
		System.out.println("done");
		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new ArrayIndexOutOfBoundsException("Out of bounds while parsing at " + getPosition());
		}

		//finished
		return new List[]{ (List<Entity>)entities, (List<Tile>)tiles, (List<PickUpObject>)pickups };

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
