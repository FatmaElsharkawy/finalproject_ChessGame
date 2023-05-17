package chessGUI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	 static Player player1;
	static Player player2;
	static Square[][] array = new Square[8][8];
	static JPanel panelBlack=new JPanel();
	static JPanel panelWhite=new JPanel();
	static JPanel panelBlack2=new JPanel();
	static JPanel panelWhite2=new JPanel();
	static JPanel panel2 = new JPanel(); //THIS PANEL HOLDS THE DIFFERENT PARTS OF THE MIDDLE PANEL
	static JPanel panel2_1 = new JPanel(); //this is the TOP part of the middle panel
	static JPanel panel2_2 = new JPanel(); //this is the LEFT part of the middle panel
	static JPanel panel2_3 = new JPanel(); //this is the RIGHT part of the middle panel
	static JPanel panel2_4 = new JPanel(); //this is the BOTTOM part of the middle panel
    static JFrame frame = new JFrame();
    
    public GUI(Player player1, Player player2){
    	this.player1=player1;
    	this.player2=player2;
    	
    }
	
	public static void chessboardGUI(String player1Name, String player2Name, String time) {

		frame.setSize(1390,780); //sets the x-dimension and the y-dimension of our frame
		frame.setLayout(null); //this is very important to be able to put the panels through the frame at the left,center,right
		frame.setResizable(false); //if we don't need the user to be able to change size of the window.
		

		// Get the screen dimensions
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		Rectangle screenBounds = gd.getDefaultConfiguration().getBounds();

		// Calculate the position of the frame
		int frameWidth = 1390;  // Adjust the frame width as needed
		int frameHeight = 780; // Adjust the frame height as needed

		//set the frame location on any PC window to be constant according to the size of its screen
		int x = (screenBounds.width - frameWidth) / 2;
		int y = (screenBounds.height - frameHeight) / 2;
		frame.setLocation(x, y);
		frame.setSize(frameWidth, frameHeight);


		//THE MIDDLE PANEL

		panel2.setBackground(Color.black); //sets background color of panel to be white
		panel2.setBounds(318, 0, 744, 744); //we set the bounds for panel 2 "the one in the middle"
		panel2.setLayout(new BorderLayout()); // we write this to make the border out of panels we made, from panel2_1 to panel2_5


		panel2_1.setBackground(Color.DARK_GRAY);
		panel2_2.setBackground(Color.DARK_GRAY);
		panel2_3.setBackground(Color.DARK_GRAY);
		panel2_4.setBackground(Color.DARK_GRAY);
		
		panel2.add(panel2_1, BorderLayout.NORTH);
		panel2.add(panel2_2, BorderLayout.WEST);
		panel2.add(panel2_3, BorderLayout.EAST);
		panel2.add(panel2_4, BorderLayout.SOUTH);

		panel2_1.setPreferredSize(new Dimension(744, 22));
		panel2_2.setPreferredSize(new Dimension(22, 744));
		panel2_3.setPreferredSize(new Dimension(22, 744));
		panel2_4.setPreferredSize(new Dimension(744, 22));
		panel2.add(Chessboard.panel2_5, BorderLayout.CENTER);
		panelBlack.setBounds(744+318,372,318,372);
		panelBlack.setLayout(new GridLayout(2,8));
		panelWhite.setBounds(0,372,318,372);
		panelWhite.setLayout(new GridLayout(2,8));
		panelBlack2.setLayout(null);
		panelBlack2.setBounds(0,0,318,372);
		panelWhite2.setLayout(null);
		panelWhite2.setBounds(744+318,0,318,372);
	    frame.add(panelBlack); frame.add(panelWhite);
	    frame.add(panelBlack2); frame.add(panelWhite2);
	    
		JLabel player1Label = new JLabel(player1.getName());
		JLabel player2Label = new JLabel(player2.getName());
		
		JLabel player1def = new JLabel("Player 1");
		JLabel player2def = new JLabel("Player 2");
		
		JLabel captured1 = new JLabel("Captured Pieces:");
		JLabel captured2 = new JLabel("Captured Pieces:");
		
		
		JLabel player1TimerLabel;
		JLabel player2TimerLabel;
		
		if (Integer.parseInt(time) < 10) {
			player1TimerLabel = new JLabel("0" + time + ":00");
			player2TimerLabel = new JLabel("0" + time + ":00");
		} else {
			player1TimerLabel = new JLabel(time + ":00");
			player2TimerLabel = new JLabel(time + ":00");
		}
		
		player1.createTimer(player1TimerLabel);
		player2.createTimer(player2TimerLabel);
		player1.startTimer();
		
		Border border1 = BorderFactory.createLineBorder(new Color(5,5,5), 2);
		Border border2 = BorderFactory.createLineBorder(new Color(200,200,200), 2);
		Font labelFont = new Font("Arial", Font.BOLD, 26);
		
		player1def.setFont(new Font("Arial", Font.PLAIN, 20));
		player2def.setFont(new Font("Arial", Font.PLAIN, 20));
		
		captured1.setFont(new Font("Arial", Font.ITALIC, 20));
		captured2.setFont(new Font("Arial", Font.ITALIC, 20));
		
		player1Label.setFont(labelFont);
		player2Label.setFont(labelFont);
		
//		player1Label.setBorder(border);
//		player2Label.setBorder(border);
		
		player1def.setHorizontalAlignment(SwingConstants.CENTER);
		player2def.setHorizontalAlignment(SwingConstants.CENTER);
		player1Label.setHorizontalAlignment(SwingConstants.CENTER);
		player2Label.setHorizontalAlignment(SwingConstants.CENTER);
		
		player1Label.setForeground(new Color(20, 20, 20));
		player2Label.setForeground(new Color(230, 230, 240));
		captured1.setForeground(new Color(20, 20, 20));
		captured2.setForeground(new Color(230, 230, 240));
		player1def.setForeground(new Color(20, 20, 20));
		player2def.setForeground(new Color(230, 230, 240));
		

		Font timerFont = new Font("Arial", Font.BOLD, 26);
		player1TimerLabel.setFont(timerFont);
		player2TimerLabel.setFont(timerFont);
		player1TimerLabel.setBorder(border1);
		player2TimerLabel.setBorder(border2);
		player1TimerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		player2TimerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		player1TimerLabel.setForeground(new Color(3, 173, 29));
		player2TimerLabel.setForeground(new Color(3, 173, 29));
		
		
		player1Label.setBounds(-5, 75, 325, 100);
		player1TimerLabel.setBounds(-5, 200, 325, 60);

		player2Label.setBounds(-5, 75, 325, 100);
		player2TimerLabel.setBounds(-5, 200, 325, 60);
		
		player1def.setBounds(-5, -20, 325, 100);
		player2def.setBounds(-5, -20, 325, 100);
		
		captured1.setBounds(5, 0, 325, 700);
		captured2.setBounds(5, 0, 325, 700);

		//JPanel player1TimerPanel = new JPanel();
		//JPanel player2TimerPanel = new JPanel();
		panelBlack.setBackground(new Color(40, 40, 40));
		panelWhite.setBackground(new Color(230, 230, 230));
		panelBlack2.setBackground(new Color(210, 210, 220));
		panelWhite2.setBackground(new Color(20, 20, 20));
		panelBlack2.add(player1Label);
		panelBlack2.add(player1TimerLabel);
		panelBlack2.add(player1def);
		panelBlack2.add(captured1);
		panelWhite2.add(player2Label);
		panelWhite2.add(player2TimerLabel);
		panelWhite2.add(player2def);
		panelWhite2.add(captured2);

		frame.add(panel2); // add panel 2 to the center of the frame
		frame.setVisible(true);
	}
	
	 public static void showWindowStalemate() {
	        JFrame frame = new JFrame("Stalemate");
	        JLabel label = new JLabel("Stalemate: Player 1 and Player 2 draw");
	        frame.add(label);
	        frame.setSize(300, 100);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }
	 
	 public static void showWindowTimeEnd() {
		    JFrame frame = new JFrame("Time Ended");
		    JLabel label = new JLabel("Player's time has ended.");
		    frame.add(label);
		    frame.setSize(300, 100);
		    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		}
	 
	 public static void showWindowCheckmate() {
	        JFrame frame = new JFrame("CheckMate");
	        JLabel label = new JLabel("Game Over: CheckMate");
	        frame.add(label);
	        frame.setSize(300, 100);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }

}