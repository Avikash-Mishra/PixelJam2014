package main;

import java.io.IOException;
import java.util.Set;

import gui.GameFrame;

public class Main {

	public static void main(String[] args){

		try{
			Set[] data = Parser.parse(Constants.LEVEL_FILENAME);
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("ERROR LOADING FILE, ABORTING");
			System.exit(1);
		}

		System.out.println("Hello World");
		new GameFrame();

	}
}
