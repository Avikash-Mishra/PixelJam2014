package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import tools.ImageLibrary;


/**
 * Game menu
 * @author Jason
 *
 */
public class Menu extends Canvas{

	private JLabel title;
	private JButton play;
	
	private GameFrame parent;
	
	public Menu(int width, int height) {
		super(width, height);
		// Initialises labels and buttons
		title = new JLabel();
		play = new JButton();
		
		title.setIcon(new ImageIcon(ImageLibrary.get("assets/sugoi_tran.png")));
		

	}

	
	
	
	
	
}
