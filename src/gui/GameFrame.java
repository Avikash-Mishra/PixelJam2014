package gui;



import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;

import main.Main;

/**
 * Main class for game, starts the game and contains the main GUI for displaying
 * the game
 *
 * @author Avikash Mishra
 *
 */
public class GameFrame extends JFrame {

	//screen dimensions
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	public static final int screenWidth = (int) tk.getScreenSize().getWidth();
	public static final int screenHeight = (int) tk.getScreenSize().getHeight();

	public GameCanvas gameCanvas;

	public GameFrame() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Set JFrame size to screen width and height
		this.setTitle("Sugoi Tran");
		this.setSize(tk.getScreenSize());
		this.setResizable(true);

		gameCanvas = new GameCanvas(this.getWidth(), this.getHeight(),this);

		// Setup canvas defaults
		gameCanvas.setBackground(Color.WHITE);

		// Add Canvas objects to JFrame
		this.add(gameCanvas);

		gameCanvas.setFocusable(true);

		this.setVisible(true);
	}

}
