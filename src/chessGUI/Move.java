package chessGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Move {
	
	 public static Set<Piece> piecesBox = new HashSet<Piece>();
	 
   
   static King whiteKing; static King blackKing; static Rook whiteRookLeft; static Rook whiteRookRight;static Rook blackRookLeft; static Rook blackRookRight;
    private static Player player1;
	private static Player player2;

	
	public Move(Chessboard Chessboard, Player player1, Player player2) {
	     this.player1=player1;
	     this.player2=player2;
	          
	  // set of updated piece.
	            whiteKing = new King("king", "White", 7, 4); piecesBox.add(whiteKing);
	            blackKing = new King("king", "Black", 0, 4);  piecesBox.add(blackKing);
	            whiteRookLeft= new Rook("rook", "White", 7, 0);piecesBox.add(whiteRookLeft);
	            whiteRookRight= new Rook("rook", "White", 7, 7); piecesBox.add(whiteRookRight);
	            blackRookLeft= new Rook("rook", "Black", 0, 0); piecesBox.add(blackRookLeft);
	            blackRookRight= new Rook("rook", "Black", 0, 7);  piecesBox.add(blackRookRight);
	  		    piecesBox.add(new Queen("queen", "White", 7, 3));
	  		    piecesBox.add(new Queen("queen", "Black", 0, 3));
	  			piecesBox.add(new Knight("knight", "White", 7, 1));
	  			piecesBox.add(new Knight("knight", "White", 7, 6));
	  			piecesBox.add(new Knight("knight", "Black", 0, 1));
	  			piecesBox.add(new Knight("knight", "Black", 0, 6));
	  			piecesBox.add(new Bishop("bishop", "White", 7, 2));
	  			piecesBox.add(new Bishop("bishop", "White", 7, 5));
	  			piecesBox.add(new Bishop("bishop", "Black", 0, 2));
	  			piecesBox.add(new Bishop("bishop", "Black", 0, 5));
	  			for(int i=0; i<=7;i++) {
	  			piecesBox.add(new Pawn("pawn", "White", 6, i));
	  			piecesBox.add(new Pawn("pawn", "Black", 1, i));}
	    }
	
	public static King getBlackKing() {
		return blackKing;
	}
	public static King getWhiteKing() {
		return whiteKing;
	}
	public static Rook getWhiteRookLeft() {
		return whiteRookLeft;
	}
	public static Rook getWhiteRookRight() {
		return whiteRookRight;
	}
	public static Rook getBlackRookLeft() {
		return blackRookLeft;
	}
	public static Rook getBlackRookRight() {
		return blackRookRight;
	}
	
    public static Piece isSquareOccupied(int rowfinal, int colfinal) {
    	for (Piece pieceOccupy : piecesBox) {
    		if((pieceOccupy.getX()==rowfinal)&& (pieceOccupy.getY()==colfinal)) {
    			return pieceOccupy;
    		}
    	}
    	return null;
    }

  //A method to get selectedPiece
    static Piece pieceAt(int row, int col) {
        for (Piece loopSelect : piecesBox) {
            if( loopSelect.getX() == row && loopSelect.getY() == col) {
                return loopSelect; } }
        return null; }
		
		// A method to get the color of the piece at the destination square.
		public static String colorOccupied(int rowfinal, int colfinal) {
			for (Piece pieceOccupy : piecesBox) {
				if((pieceOccupy.getX()==rowfinal)&& (pieceOccupy.getY()==colfinal)) {
					return (pieceOccupy.getColor());    }
			}
			return null;
		}
		// A method that make the piece move.
		public static void movePiece( int fromRow,int fromCol, int toRow, int toCol) {
			Piece movingPiece = pieceAt(fromRow,fromCol);
			movingPiece.setName(pieceAt(fromRow,fromCol).getName());
			movingPiece.setColor(pieceAt(fromRow,fromCol).getColor());
			movingPiece.setLocation(fromRow,fromCol);
			
			


			switch (movingPiece.getName()) {
				case "pawn" -> {
					if(isLegalMove(fromRow, fromCol, toRow,toCol,"pawn", movingPiece.getColor(), colorOccupied( toRow, toCol))) {
						
						// if((movingPiece.getColor().equals("Black"))&&(count%2==0)){ Chessboard.array[fromRow+1][fromCol].setBackground(Color.green);}

						if((toRow==7)||(toRow==0)){

							//IN THIS Method we need to add it to the Chessboard class to make replacement

							JFrame frameP =new JFrame();
							frameP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//good for temporary window
							frameP.setSize(200,200);
							frameP.setResizable(false);
							//  ImageIcon icon=new ImageIcon("360_F_346775711_wgofOdl8Z4DKi0FR9mBFRo1FK3kmMtC9.jpg");
							// frameP.setIconImage(icon.getImage());
							JLabel label=new JLabel();
							label.setText("Choose the piece to pe promoted to:");
							JPanel panel = new JPanel();
							panel.setLayout(new BorderLayout());
							JPanel buttonPanel = new JPanel();
							panel.add(label, BorderLayout.NORTH);
							buttonPanel.setLayout(new GridLayout(1, 4));
							JButton queenButton = new JButton("Queen");
							JButton rookButton = new JButton("Rook");
							JButton bishopButton = new JButton("Bishop");
							JButton knightButton = new JButton("Knight");
							queenButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									toPromotePawn(fromRow, fromCol, toRow, toCol, movingPiece);
									Chessboard.array[toRow][toCol].setPiece(new Queen("queen", movingPiece.getColor(), toRow, toCol));
									piecesBox.add(new Queen("queen", movingPiece.getColor(), toRow, toCol));
									frameP.dispose();
								}
							});
							rookButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									toPromotePawn(fromRow, fromCol, toRow, toCol, movingPiece);
									Chessboard.array[toRow][toCol].setPiece(new Rook("rook", movingPiece.getColor(), toRow, toCol));
									piecesBox.add(new Rook("rook", movingPiece.getColor(), toRow, toCol));
									frameP.dispose();
								}
							});
							bishopButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									toPromotePawn(fromRow, fromCol, toRow, toCol, movingPiece);
									Chessboard.array[toRow][toCol].setPiece(new Bishop("bishop", movingPiece.getColor(), toRow, toCol));
									piecesBox.add(new Bishop("bishop", movingPiece.getColor(), toRow, toCol));
									frameP.dispose();
								}
							});
							knightButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									toPromotePawn(fromRow, fromCol, toRow, toCol, movingPiece);
									Chessboard.array[toRow][toCol].setPiece(new Knight("knight", movingPiece.getColor(), toRow, toCol));
									piecesBox.add(new Knight("knight", movingPiece.getColor(), toRow, toCol));
									frameP.dispose();
								}
							});

							buttonPanel.add(queenButton);
							buttonPanel.add(rookButton);
							buttonPanel.add(bishopButton);
							buttonPanel.add(knightButton);
							panel.add(buttonPanel,BorderLayout.CENTER);
							frameP.add(panel);
							frameP.pack();
							frameP.setVisible(true);
						}
						else{
							if(isSquareOccupied(toRow,toCol )==null) {
								Chessboard.array[toRow][toCol].setPiece(new Pawn("pawn", movingPiece.getColor(), toRow, toCol));
								Chessboard.array[fromRow][fromCol].setIcon(null);
								piecesBox.add(new Pawn("pawn", movingPiece.getColor(), toRow, toCol));
								piecesBox.remove(movingPiece);}
							else {
								if(colorOccupied(toRow, toCol).equals("White")) GUI.panelBlack.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
								    else GUI.panelWhite.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
								piecesBox.remove(isSquareOccupied(toRow, toCol));
								Chessboard.array[toRow][toCol].setIcon(null); Chessboard.array[fromRow][fromCol].setIcon(null);
								Chessboard.array[toRow][toCol].setPiece(new Pawn("pawn", movingPiece.getColor(), toRow, toCol));
								piecesBox.add(new Pawn("pawn", movingPiece.getColor(), toRow, toCol));
								piecesBox.remove(movingPiece);}
						}
					}}




				case "queen" -> {
					if(isLegalMove(fromRow, fromCol, toRow,toCol,"queen", movingPiece.getColor(), colorOccupied( toRow, toCol))) {
						if(isSquareOccupied(toRow,toCol )==null) {
							Chessboard.array[toRow][toCol].setPiece(new Queen("queen", movingPiece.getColor(), toRow, toCol));
							Chessboard.array[fromRow][fromCol].setIcon(null);
							piecesBox.add(new Queen("queen", movingPiece.getColor(), toRow, toCol));
							piecesBox.remove(movingPiece);}
						else {
							if(colorOccupied(toRow, toCol).equals("White")) GUI.panelBlack.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
							    else GUI.panelWhite.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
							piecesBox.remove(isSquareOccupied(toRow, toCol));
							Chessboard.array[toRow][toCol].setIcon(null); Chessboard.array[fromRow][fromCol].setIcon(null);
							Chessboard.array[toRow][toCol].setPiece(new Queen("queen", movingPiece.getColor(), toRow, toCol));
							piecesBox.add(new Queen("queen", movingPiece.getColor(), toRow, toCol));
							piecesBox.remove(movingPiece);
							

							
						}
					}
				}
				case "knight" -> {

					if(isLegalMove(fromRow, fromCol, toRow,toCol,"knight", movingPiece.getColor(), colorOccupied( toRow, toCol))) {
						if(isSquareOccupied(toRow,toCol )==null) {
							Chessboard.array[toRow][toCol].setPiece(new Knight("knight", movingPiece.getColor(), toRow, toCol));
							Chessboard.array[fromRow][fromCol].setIcon(null);
							piecesBox.add(new Knight("knight", movingPiece.getColor(), toRow, toCol));
							piecesBox.remove(movingPiece);
						}
						else {
							if(colorOccupied(toRow, toCol).equals("White")) GUI.panelBlack.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
							    else GUI.panelWhite.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
							piecesBox.remove(isSquareOccupied(toRow, toCol));
							Chessboard.array[toRow][toCol].setIcon(null); Chessboard.array[fromRow][fromCol].setIcon(null);
							Chessboard.array[toRow][toCol].setPiece(new Knight("knight", movingPiece.getColor(), toRow, toCol));
							piecesBox.add(new Knight("knight", movingPiece.getColor(), toRow, toCol));
							piecesBox.remove(movingPiece);
						}
					}
				}
				case "king" -> {if((!Game.isCheck1(toRow,toCol))) {
					if(isLegalMove(fromRow, fromCol, toRow,toCol,"king", movingPiece.getColor(), colorOccupied( toRow, toCol))) {
						if(isSquareOccupied(toRow,toCol )==null) {
							Chessboard.array[toRow][toCol].setPiece(new King("king", movingPiece.getColor(), toRow, toCol));
							Chessboard.array[fromRow][fromCol].setIcon(null);
							piecesBox.add(new King("king", movingPiece.getColor(), toRow, toCol));
							piecesBox.remove(movingPiece);}
						else if(Game.isCastling(Chessboard.getInitialRow(),Chessboard.getInitialCol(),Chessboard.getFinalRow(),Chessboard.getFinalCol())){
							    piecesBox.remove(isSquareOccupied(toRow, toCol));
								Chessboard.array[toRow][toCol].setIcon(null); Chessboard.array[fromRow][fromCol].setIcon(null);
								Chessboard.array[toRow][colcastleking()].setPiece(new King("king", movingPiece.getColor(), toRow, colcastleking()));
								piecesBox.add(new King("king", movingPiece.getColor(), toRow, colcastleking()));
								Chessboard.array[fromRow][colcastlerook()].setPiece(new Rook("rook", movingPiece.getColor(), fromRow, colcastlerook()));
								piecesBox.add(new Rook("rook", movingPiece.getColor(), fromRow, colcastlerook()));
								piecesBox.remove(movingPiece);


							}
							else {
							if(colorOccupied(toRow, toCol).equals("White")) GUI.panelBlack.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
								else GUI.panelWhite.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
							piecesBox.remove(isSquareOccupied(toRow, toCol));
							Chessboard.array[toRow][toCol].setIcon(null); Chessboard.array[fromRow][fromCol].setIcon(null);
							Chessboard.array[toRow][toCol].setPiece(new King("king", movingPiece.getColor(), toRow, toCol));
							piecesBox.add(new King("king", movingPiece.getColor(), toRow, toCol));
							piecesBox.remove(movingPiece);}}}
					}
				case "bishop" -> {
					if(isLegalMove(fromRow, fromCol, toRow,toCol,"bishop", movingPiece.getColor(), colorOccupied( toRow, toCol))) {
						if(isSquareOccupied(toRow,toCol )==null) {
							Chessboard.array[toRow][toCol].setPiece(new Bishop("bishop", movingPiece.getColor(), toRow, toCol));
							Chessboard.array[fromRow][fromCol].setIcon(null);
							piecesBox.add(new Bishop("bishop", movingPiece.getColor(), toRow, toCol));
							piecesBox.remove(movingPiece); }
						else {
							if(colorOccupied(toRow, toCol).equals("White")) GUI.panelBlack.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
						     	else GUI.panelWhite.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
							piecesBox.remove(isSquareOccupied(toRow, toCol));
							Chessboard.array[toRow][toCol].setIcon(null); Chessboard.array[fromRow][fromCol].setIcon(null);
							Chessboard.array[toRow][toCol].setPiece(new Bishop("bishop", movingPiece.getColor(), toRow, toCol));
							piecesBox.add(new Bishop("bishop", movingPiece.getColor(), toRow, toCol));
							piecesBox.remove(movingPiece);}
					} }
				case "rook" -> {
					if(isLegalMove(fromRow, fromCol, toRow,toCol,"rook", movingPiece.getColor(), colorOccupied( toRow, toCol) )) {
						if(isSquareOccupied(toRow,toCol )==null) {
							Chessboard.array[toRow][toCol].setPiece(new Rook("rook", movingPiece.getColor(), toRow, toCol));
							Chessboard.array[fromRow][fromCol].setIcon(null);
							piecesBox.add(new Rook("rook", movingPiece.getColor(), toRow, toCol));
							piecesBox.remove(movingPiece);}
						else if(Game.isCastling(Chessboard.getInitialRow(),Chessboard.getInitialCol(),Chessboard.getFinalRow(),Chessboard.getFinalCol())){
							piecesBox.remove(isSquareOccupied(toRow, toCol));
							Chessboard.array[toRow][toCol].setIcon(null); Chessboard.array[fromRow][fromCol].setIcon(null);
							Chessboard.array[toRow][colcastleking()].setPiece(new King("king", movingPiece.getColor(), toRow, colcastleking()));
							piecesBox.add(new King("king", movingPiece.getColor(), toRow, colcastleking()));
							Chessboard.array[fromRow][colcastlerook()].setPiece(new Rook("rook", movingPiece.getColor(), fromRow, colcastlerook()));
							piecesBox.add(new Rook("rook", movingPiece.getColor(), fromRow, colcastlerook()));
							piecesBox.remove(movingPiece);}
						else {
							if(colorOccupied(toRow, toCol).equals("White")) GUI.panelBlack.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
							  else GUI.panelWhite.add(imgEatPiece(isSquareOccupied(toRow, toCol)));
							piecesBox.remove(isSquareOccupied(toRow, toCol));
							Chessboard.array[toRow][toCol].setIcon(null); Chessboard.array[fromRow][fromCol].setIcon(null);
							Chessboard.array[toRow][toCol].setPiece(new Rook("rook", movingPiece.getColor(), toRow, toCol));
							piecesBox.add(new Rook("rook", movingPiece.getColor(), toRow, toCol));
							piecesBox.remove(movingPiece);}
					}
				}
			}
		}


	
// Method to check if the move is legal or not
	public static boolean isLegalMove(int rowinitial, int colinitial, int rowfinal, int colfinal, String name,String colorpiece,String coloroccupied) {
		int row= Math.abs(rowinitial-rowfinal);
		int col=  Math.abs(colinitial-colfinal);
		int rowp=rowfinal-rowinitial;
		if(row==0&&col==0) return false;
		
		if(Isblack(colorpiece)){
		if(blackKing.KBFM()&&(blackRookLeft.RBLeft()||blackRookRight.RBRight())){
        if(rowinitial==0&&rowfinal==0&&(((colinitial==0&&colfinal==4)||(colinitial==7&&colfinal==4))||((colfinal==0&&colinitial==4)||(colfinal==7&&colinitial==4)))){
			return Game.isCastling(rowinitial,colinitial,rowfinal,colfinal);
			}}}
		else {
			if(whiteKing.KWFM()&&(whiteRookLeft.RWLeft()||whiteRookRight.RWRight())){
				if(rowinitial==7&&rowfinal==7&&(((colinitial==0&&colfinal==4)||(colinitial==7&&colfinal==4))||((colfinal==0&&colinitial==4)||(colfinal==7&&colinitial==4)))){
					return Game.isCastling(rowinitial,colinitial,rowfinal,colfinal);
		}}}
		
	        	//player 1 is white player 
				if(player1.isTurn()) { 
				   if (colorpiece.equals(player2.getColor())) { return false;}}
				//player 2 is black player
				else if(player2.isTurn()) {if (colorpiece.equals(player1.getColor())) {
					 return false;}}
				
		
		if (colorpiece.equals(coloroccupied)) return false;
		
		else {

			switch(name) {
			case "pawn": {
				if (Isblack(colorpiece)){
					if (rowinitial==1) {if(colorOccupied(rowinitial+1,colinitial)==null)
						if(!(colorOccupied(rowfinal,colfinal)==null)){return(rowp==1 && col==1)||(rowp==2 && col==0)||(rowp==1 && col==0);}
						else if(!(colorOccupied(rowfinal,colfinal)==null)){return(rowp==1 && col==1)||(rowp==1 && col==0);}
						else{ return(rowp==2 && col==0)||(rowp==1 && col==0);}
					}
					if(!(colorOccupied(rowfinal,colfinal)==null)){return(rowp==1 && col==1)||(rowp==1 && col==0);}
					return(rowp==1 && col==0);}
				else if(!Isblack(colorpiece)){
					if (rowinitial==6) {if(colorOccupied(rowinitial-1,colinitial)==null)
						if(!(colorOccupied(rowfinal,colfinal)==null)){return(rowp==-1 && col==1)||(rowp==-2 && col==0)||(rowp==-1 && col==0);}
						else if(!(colorOccupied(rowfinal,colfinal)==null)){return(rowp==-1 && col==1)||(rowp==-1 && col==0);}
						else{ return(rowp==-2 && col==0)||(rowp==-1 && col==0);}
					}
					if(!(colorOccupied(rowfinal,colfinal)==null)){return(rowp==-1 && col==1)||(rowp==-1 && col==0);}
					return(rowp==-1 && col==0);}
    
			}
				case "knight": {

					return (row==2 && col==3)||(row==3 && col==2);
						

				}

				case "bishop": {
					// All conditions are met, the move is valid
					return ((row<=3&&col<=3)&&(row==col))||(row==0&col==1);}



				case "queen": {
					boolean found = false;
					//check horizontal moves to right
					if ((rowinitial == rowfinal) && (colfinal > colinitial)) {
						for (int i = colinitial + 1; i < colfinal; i++) {
							if (isSquareOccupied(rowfinal, i) != null) found = true;
							if (found) return false;
						}
						return true;
					}
					//check horizontal moves to left
					else if ((rowinitial == rowfinal) && (colfinal < colinitial)) {
						for (int i = colinitial - 1; i > colfinal; i--) {
							if (isSquareOccupied(rowfinal, i) != null) found = true;
							if (found) return false;
						}
						return true;
					}

					//check vertical moves to down
					else if ((colinitial == colfinal) && (rowfinal > rowinitial)) {
						for (int i = rowinitial + 1; i < rowfinal; i++) {
							if (isSquareOccupied(i, colfinal) != null) found = true;
							if (found) return false;
						}
						return true;
					}
					//check vertical moves to up
					else if (colinitial == colfinal && rowfinal < rowinitial) {
						for (int i = rowinitial - 1; i > rowfinal; i--) {
							if (isSquareOccupied(i, colfinal) != null) found = true;
							if (found) return false;
						}
						return true;

					} else return ((row <= 7 && col <= 7) && (row == col));
				}




				case "king": {
					return ((row == 0 & col == 1) || (row == 1 & col == 0) || (row == 1 & col == 1));
				}



				case "rook": {
					boolean found= false;
					//check horizontal moves to right
					if((rowinitial==rowfinal)&& (colfinal>colinitial)) {
						for(int i= colinitial+1;i<colfinal;i++) {
							if(isSquareOccupied(rowfinal,i)!=null) found=true;
							if(found)  return false;
						}
						return true;}
					//check horizontal moves to left
					else if((rowinitial==rowfinal)&& (colfinal<colinitial)) {
						for(int i= colinitial-1;i>colfinal;i--) {
							if(isSquareOccupied(rowfinal,i)!=null) found=true;
							if(found)  return false;
						}
						return true;}

					//check vertical moves to down
					else if((colinitial==colfinal)&& (rowfinal>rowinitial)) {
						for(int i= rowinitial+1;i<rowfinal;i++) {
							if(isSquareOccupied(i, colfinal)!=null) found=true;
							if(found)  return false;
						}
						return true;}
					//check vertical moves to up
					else if(colinitial==colfinal && rowfinal<rowinitial) {
						for(int i= rowinitial-1;i>rowfinal;i--) {
							if(isSquareOccupied(i, colfinal)!=null) found=true;
							if(found)  return false;
						}
						return true;}	}
			}
			return false;
		}}
		
		
	
	// a function to highlight the legal moves 
	public void highlightLegalMove(int rowinitial, int colinitial) {
		String colorpiece=colorOccupied(rowinitial,colinitial);
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				String colordest=colorOccupied(i,j);
				
			switch (pieceAt(rowinitial,colinitial).getName()) {
			
			case "bishop":{
				if(isLegalMove(rowinitial,colinitial,i,j,"bishop",colorpiece, colordest))
					Chessboard.array[i][j].setBackground(Color.green);	
				break;
			}
			
			case "pawn":{
				if(isLegalMove(rowinitial,colinitial,i,j,"pawn",colorpiece, colordest))
					Chessboard.array[i][j].setBackground(Color.green);	
				break;
				
			}
			case "rook": {
				if(isLegalMove(rowinitial,colinitial,i,j,"rook",colorpiece, colordest))
					Chessboard.array[i][j].setBackground(Color.green);	
				break;
			}
			case "knight": {
			   if(isLegalMove(rowinitial,colinitial,i,j,"knight",colorpiece, colordest))
						Chessboard.array[i][j].setBackground(Color.green);	
					break;	
			}
			case "queen": {
				   if(isLegalMove(rowinitial,colinitial,i,j,"queen",colorpiece, colordest))
							Chessboard.array[i][j].setBackground(Color.green);	
						break;}
			
		    case "king": {
				   if(isLegalMove(rowinitial,colinitial,i,j,"king",colorpiece, colordest)) {
							Chessboard.array[i][j].setBackground(Color.green);
				 if(Game.isCheckKing(i,j)) {Chessboard.array[i][j].setBackground(Color.red);}}
						break;
			}}}}}
	
	  //to get new column of Rook position during castling
			public static int colcastlerook (){
				if (Chessboard.getInitialCol()==7||Chessboard.getFinalCol()==7){
					return 5;
				}
				if(Chessboard.getInitialCol()==0||Chessboard.getFinalCol()==0){return 3;

			}
			return 0;}
			
			 // to get new column of King position during castling
			public static int colcastleking(){
				if (Chessboard.getInitialCol()==7||Chessboard.getFinalCol()==7){	return 6;
				}
				if(Chessboard.getInitialCol()==0||Chessboard.getFinalCol()==0){
					return 2;
					}
				return 0;}
			
			// to get image of eaten piece
			 public static JLabel imgEatPiece(Piece piece) {
			    	ImageIcon icon= new ImageIcon(piece.takePathPhoto(piece.getColor()));
			    	JLabel label= new JLabel();
			    	Image image=(icon).getImage().getScaledInstance(50, 50,java.awt.Image.SCALE_SMOOTH);
			    	icon = new ImageIcon(image);
			    	label.setIcon(icon);
					return label;  	
			    }
			 
			 
			   public static boolean Isblack(String color){
			         if (color.equals("Black")) {return true;}
			             return false;
				}

			private static void toPromotePawn(int fromRow, int fromCol, int toRow, int toCol, Piece movingPiece) {
				piecesBox.remove(isSquareOccupied(toRow, toCol));
				Chessboard.array[toRow][toCol].setIcon(null);
				Chessboard.array[fromRow][fromCol].setIcon(null);
				piecesBox.remove(movingPiece);
			}
			   


}
