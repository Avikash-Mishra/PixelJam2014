package main;

import java.util.List;
import java.io.IOException;
import java.util.Set;

import gui.GameFrame;

public class Main {

	public static void main(String[] args){

		try{
			List[] data = Parser.parse(Constants.LEVEL_FILENAME);

			System.out.println(" entities: " + data[0].size());
			//Create Game
			new GameFrame(data);
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("ERROR LOADING FILE, ABORTING");
			System.exit(1);
		}

	}
}
