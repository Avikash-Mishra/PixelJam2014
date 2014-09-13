package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.ImageLibrary;


/**
 * Game menu
 * @author Jason
 *
 */
public class Menu extends JPanel{

	private JLabel title;
	private JButton playButton;
	//private BufferedImage img;
	
	//screen dimensions
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	public static final int screenWidth = (int) tk.getScreenSize().getWidth();
	public static final int screenHeight = (int) tk.getScreenSize().getHeight();

	
	public Menu() {
		title = new JLabel();
		playButton = new JButton();		
		
		setLayout(null);
		
		/*File file = new File("sugoi_tran.png");
		String path = file.getAbsolutePath();
		System.out.println(path);
		
		try{
			img = ImageIO.read(new File("/c/User/Jason/Desktop/PXLJM2014/PixelJam2014/sugoi_tran.png"));
			
		}catch(IOException e) {
		    e.printStackTrace();
		}
		
		BufferedImage resize = (BufferedImage) img.getScaledInstance(title.getWidth(), title.getHeight(), Image.SCALE_SMOOTH);
		
		title.setIcon((Icon) resize);*/
		
		
		title.setIcon(new ImageIcon(ImageLibrary.get("sugoi_tran.png")));
		playButton.setIcon(new ImageIcon(ImageLibrary.get("play button.png")));
		
		
		title.setPreferredSize(new Dimension(500,100));
		Dimension size = title.getPreferredSize();	
		//System.out.println(size.width+" "+size.height);
		
		title.setBounds(screenWidth/2-(size.width/2), 100, size.width, size.height);
		size  = playButton.getPreferredSize();
		//System.out.println(size.width+" "+size.height);
		playButton.setBounds(screenWidth/2-(size.width/2), screenHeight/2, 300, 60);
		
		this.add(title);
		this.add(playButton);
		this.repaint();
	}
	

	public static void main(String[] args){
		//Menu m = new Menu();
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Menu());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenWidth,screenHeight);
		frame.setVisible(true);
	}
	
}
