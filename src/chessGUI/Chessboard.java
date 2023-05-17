package chessGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static chessGUI.Data.saveData;

public class Chessboard implements ActionListener{
	

	
	static int intialrow;
	static int intialcol;
	static int finalrow;
	static int finalcol;   
	
	int n=1; int count =0;

	static boolean kbfm=true; static boolean kwfm=true;
	static boolean rbleft=true; static boolean rbright=true;
	static boolean rwleft=true;
	static boolean rwright= true;
	
	
	boolean isstalemate=false;
	boolean ischeckmate=false;
	
  Player player1; Player player2;
   private Game game; 
   private Move move;
  

	static Square[][] array = new Square[8][8];
	static JPanel panelBlack=new JPanel();
	static JPanel panelWhite=new JPanel();
	JPanel panel2 = new JPanel(); //THIS PANEL HOLDS THE DIFFERENT PARTS OF THE MIDDLE PANEL
	static JPanel panel2_5 = new JPanel(); //this is the MIDDLE part of the middle panel


	
   public static boolean getkbfm() {
	return kbfm;
	}
   
   public static boolean getkwfm() {
		return kwfm;
		}
   
   public static boolean getrbleft() {
		return rbleft;
	 }
   
   public static boolean getrbright() {
		return rbright;
	 }
   public static boolean getrwleft() {
		return rwleft;
	 }
   public static boolean getrwright() {
		return rwright;
	 }
   
   public static int getInitialRow() {
	   return intialrow;
   }
   public static int getInitialCol() {
	   return intialcol;
   }
   public static int getFinalRow() {
	   return finalrow;
   }
   public static int getFinalCol() {
	   return finalcol;
   }
  
	public Chessboard(String player1Name, String player2Name, String time) {
		
	 // create a new Move object and pass the Chessboard object to its constructor
		player1 = new Player(player1Name, "White", time);
		player2 = new Player(player2Name, "Black", time);
	    this.game=new Game(player1, player2);
	    this.move = new Move(this, player1, player2);
	     player1.setTurn(true);
	     new GUI(player1,player2);
	    
		//THE MIDDLE PANEL

		panel2.setBackground(Color.black); //sets background color of panel to be white
		panel2.setBounds(318, 0, 744, 744); //we set the bounds for panel 2 "the one in the middle"
		panel2.setLayout(new BorderLayout()); // we write this to make the border out of panels we made, from panel2_1 to panel2_5
        panel2_5.setPreferredSize(new Dimension(700, 700));
	     
        
       for (int row=0; row<=7;row++){
			for (int col=0; col<=7; col++) {
				array[row][col] = new Square(row,col);
				int finalR = row;
				int finalC = col; 
				array[row][col].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						count++; 
						if(count%2 !=0){
							intialrow= array[finalR][finalC].getRow();
							intialcol=array[finalR][finalC].getCol();
							
							if((player1.isTurn()&&(count==4*n-3))){ n++; move.highlightLegalMove(intialrow,intialcol);  System.out.print(count+ "1 and n ="+n);} 
						    else if(player2.isTurn()&&(count==4*(n-1)-1)) { move.highlightLegalMove(intialrow,intialcol);  System.out.print(count+ "2 and n ="+n);}
							else {System.out.print(count+ "3 and n ="+n); count--; n--; } 
					
							
						}
						
					  else  {
							finalrow= array[finalR][finalC].getRow();
							finalcol=array[finalR][finalC].getCol();
							
							kbfm=Move.getBlackKing().KBFM();
							kwfm=Move.getWhiteKing().KWFM();
							rbleft=Move.getBlackRookLeft().RBLeft();
							rbright=Move.getBlackRookRight().RBRight();
							rwleft=Move.getWhiteRookLeft().RWLeft();
							rwright=Move.getWhiteRookRight().RWRight();  
							
							
							if(Game.CheckMate()) {ischeckmate= true;}
							if(Game.StaleMate()) {isstalemate=true;}
						
						  if(!isstalemate&&!ischeckmate&&!player1.isTimeEnded()&&!player2.isTimeEnded()) {
							player1.startTimer();
							if(player1.isTurn()) {
						        Move.movePiece(intialrow,intialcol,finalrow,finalcol);
								player1.stopTimer();
								player1.setTurn(false);
								player2.setTurn(true);
								player2.startTimer();  
								}
							         
							    else if(player2.isTurn()) {
								System.out.println("eneter player two turrn");
								Move.movePiece(intialrow,intialcol,finalrow,finalcol);
								player2.stopTimer();
								player1.setTurn(true);
								player2.setTurn(false);
								player1.startTimer();
							    }
						resetBoardColors();
							  }
						  
						  else if(ischeckmate){ GUI.showWindowCheckmate(); 
					      if(player1.isTurn()) {saveData(player1Name);
						  saveData("Loser");  saveData(player2Name);  saveData("Winner");  }
					      else {saveData(player1Name); saveData("Winner");  saveData(player2Name); saveData("Loser"); }
						  }
						  
						  else if(isstalemate){
							  GUI.showWindowStalemate();
							  saveData(player1Name);
							  saveData("stalmate");
							  saveData(player2Name);
							  saveData("stalmate");
							  }
						  else if (player1.isTimeEnded()||player2.isTimeEnded()) GUI.showWindowTimeEnd(); 
					  
						    Game.ischeck=Game.isCheck();
						    if(Game.isCheck()) System.out.println(Game.getKingColor()); 
					  }}});

				panel2_5.add (array[row][col]);
			}
		}

		panel2_5.setLayout(new GridLayout(8, 8)); // We made this middle part to be the chess board consisting of 64 squares
		panel2.add(panel2_5, BorderLayout.CENTER);

		array[0][0].setPiece(new Rook("rook", "Black", 0, 0));
		array[0][1].setPiece(new Knight("knight", "Black", 0, 1));
		array[0][2].setPiece(new Bishop("bishop", "Black", 0, 2));
		array[0][3].setPiece(new Queen("queen", "Black", 0, 3));
		array[0][4].setPiece(new King("king", "Black", 0, 4));
		array[0][5].setPiece(new Bishop("bishop", "Black", 0, 5));
		array[0][6].setPiece(new Knight("knight", "Black", 0, 6));
		array[0][7].setPiece(new Rook("rook", "Black", 0, 7));
		for (int col = 0; col < 8; col++) {
			array[1][col].setPiece(new Pawn("pawn", "Black", 1, col));
			array[6][col].setPiece(new Pawn("pawn", "White", 6, col));
		}
		array[7][0].setPiece(new Rook("rook", "White", 7, 0));
		array[7][1].setPiece(new Knight("knight", "White", 7, 1));
		array[7][2].setPiece(new Bishop("bishop", "White", 7, 2));
		array[7][3].setPiece(new Queen("queen", "White", 7, 3));
		array[7][4].setPiece(new King("king", "White", 7, 4));
		array[7][5].setPiece(new Bishop("bishop", "White", 7, 5));
		array[7][6].setPiece(new Knight("knight", "White", 7, 6));
		array[7][7].setPiece(new Rook("rook", "White", 7, 7));
		
	    GUI.chessboardGUI( player1Name, player2Name,  time);

		GUI.frame.add(panel2); // add panel 2 to the center of the frame
		GUI.frame.setVisible(true);
	}
	
	public void resetBoardColors() {
    	for(int i=0; i<8; i++) {
    		for(int j=0; j<8; j++) {
    			if ((i + j) % 2 == 0) {
    	            array[i][j].setBackground(Color.white);
    	        } else {
    	        	array[i][j].setBackground(new Color(0x937342));
    	        }}}}

   
    @Override
	public void actionPerformed(ActionEvent e) {
	}
}