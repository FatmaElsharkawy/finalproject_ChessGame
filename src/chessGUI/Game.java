package chessGUI;

import java.util.ArrayList;


public class Game {
	static ArrayList<Piece> checkmatepieces= new ArrayList<Piece>();
	static ArrayList<Piece> team= new ArrayList<Piece>();
	static ArrayList<Piece> teamcheckmate= new ArrayList<Piece>();

	
	static String kingColor; 
	static boolean ischeck=false;

	private static Player player1;
	private static Player player2;
	
	  public Game(Player player1, Player player2) {

		this.player1=player1;
		this.player2=player2; 	 
	
	}
	 //a function to get king of interest to test for check and check mate based on player turn 
	  public static String getKingColor() {
		  if(player1.isTurn()) {kingColor=player1.getColor();}
		  else {kingColor=player2.getColor();}
		  return kingColor;
		}	
	  //A function to get opponent 
	  public static ArrayList<Piece> getOpponent() {
			ArrayList<Piece> opponent= new ArrayList<Piece>();
			for(Piece piece: Move.piecesBox) {
				if(!(piece.getColor().equals(getKingColor()))) opponent.add(piece); //to collect all pieces of opponent
			}
			return opponent;
		}
	  //to get the location of the king 
	    public static Piece getKingLocation(String playerColor) {
	    	for(Piece piece: Move.piecesBox) {
	    		if(piece.getName().equals("king")&&piece.getColor().equals(getKingColor())) {
	    			return piece;}
	    	}
			return null;  }
	
	// a method that make castling 
	public static boolean isCastling(int row1,int col1 ,int row2,int col2) {
		 boolean r1 = (Move.isSquareOccupied(0, 0) == null);
		 boolean r2 = (Move.isSquareOccupied(0, 7) == null);
		 boolean s1 = (Move.isSquareOccupied(0, 1) == null) && (Move.isSquareOccupied(0, 2) == null) && (Move.isSquareOccupied(0, 3) == null);
		 boolean s2 = (Move.isSquareOccupied(0, 5) == null) && (Move.isSquareOccupied(0, 6) == null);
		 boolean r4 = (Move.isSquareOccupied(7, 0) == null);
		 boolean r5 = (Move.isSquareOccupied(7, 7) == null);
		 boolean s4 = (Move.isSquareOccupied(7, 1) == null) && (Move.isSquareOccupied(7, 2) == null) && (Move.isSquareOccupied(7, 3) == null);
		 boolean s5 = (Move.isSquareOccupied(7, 5) == null) && (Move.isSquareOccupied(7, 6) == null);
		 
		 if(Chessboard.getInitialRow()==0){
		 if (!Move.getBlackKing().KBFM()) {
			 return false;
		 }

		 if(Move.getBlackRookLeft().RBLeft()){
		 if (s1) {
				 if (!(r1)) {
					 if (col1==0||col2==0){return true; }}}}
		 if(Move.getBlackRookRight().RBRight()){
		 if (s2) {
			 if(!(r2)){if(col1==7||col2==7){return true; }}}}}
		 else if (Chessboard.getInitialRow()==7) { if (!Move.getWhiteKing().KWFM()) {
			 return false;}
		 if(Move.getWhiteRookLeft().RWLeft()){
				 if (s4) {
					 if (!(r4)) {
						 if (col1==0||col2==0){return true; }}}}
			 if(Move.getWhiteRookRight().RWRight()){
				 if (s5) { if(!(r5)){if(col1==7||col2==7){return true;}}}} }
		 return false;}
	
	 // a check method: to see if any of the opponent pieces can take a legal Move to the king current location
		public static boolean isCheck() {
				for(Piece piece: getOpponent()) {
				if(Move.isLegalMove(piece.getX(), piece.getY(),getKingLocation(getKingColor()).getX(), getKingLocation(getKingColor()).getY(), piece.getName(), piece.getColor(), getKingColor()))
					return true; // a check will happen
			}
			return false;
		}
		
		public static boolean isCheck1(int rowfinal,int colfinal) {
			for(Piece piece: getOpponent()) {
				if(Move.isLegalMove(piece.getX(), piece.getY(),rowfinal, colfinal, piece.getName(), piece.getColor(), getKingColor())) {
					return true;} // a check will happen
			}
			return false;
		}
		  /* a method that take the possible "legal" Moves of the king (final row and column) and check if any of opponent can reach this square 
	        if a piece can make this Move, the king is prevented from going there indicated by red highlight.*/
		public static boolean isCheckKing(int finalkingrow, int finalkingcol) {
			for(Piece piece: getOpponent()) {
				if(Move.isLegalMove(piece.getX(), piece.getY(),finalkingrow,finalkingcol, piece.getName(), piece.getColor(), getKingColor()))
					return true; // a check will happen
			}
			return false; }
		
		public static boolean CheckMate(){
			checkmatepieces.clear();
			for(Piece piece: getOpponent()) {
				if(Move.isLegalMove(piece.getX(), piece.getY(),getKingLocation(getKingColor()).getX(), getKingLocation(getKingColor()).getY(), piece.getName(), piece.getColor(), getKingColor())){
					checkmatepieces.add(piece);}}
			teamcheckmate.clear();
			for(Piece piece: Move.piecesBox) {
				if((piece.getColor().equals(getKingColor()))){if(piece.getName().equals("king")){System.out.println("d");}
				else teamcheckmate.add(piece); }}
			
			if(ischeck){for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++){
					if(Move.isLegalMove(getKingLocation(getKingColor()).getX(),getKingLocation(getKingColor()).getY(),i,j,"king",getKingColor(), Move.colorOccupied(i,j))) {if(!isCheckKing(i,j)){
						 {return false;}}}}}
				if(checkmatepieces.size()>1){
					return true;}
				else if (checkmatepieces.size()==1) {for (Piece piecex:checkmatepieces){
					int x= piecex.getX(); int y= piecex.getY();
					for (Piece pieceteam:teamcheckmate) {
						if(Move.isLegalMove(pieceteam.getX(), pieceteam.getY(), x, y, pieceteam.getName(), getKingColor(), Move.colorOccupied(x,y))) {
							return false;
						}}
						 if(!((piecex.getName().equals("rook"))||(piecex.getName().equals("queen")))) {	return true;}
					    	else {
								 if(getKingLocation(getKingColor()).getX()==piecex.getX()) {
									 int row=piecex.getX(); for(Piece pieceteam:teamcheckmate){for (int col=0; col<8; col++) {
										 if(Move.isLegalMove(pieceteam.getX(), pieceteam.getY(), row, col, pieceteam.getName(),getKingColor(),Move.colorOccupied(row,col))) {
											 return false;
										 }}
								 }return true;}
							 if(getKingLocation(getKingColor()).getY()==piecex.getY()) {
								 int col=piecex.getY(); for(Piece pieceteam:teamcheckmate){
									 for (int row=0; row<8; row++) {
									 if(Move.isLegalMove(pieceteam.getX(), pieceteam.getY(), row, col, pieceteam.getName(),getKingColor(),Move.colorOccupied(row,col))) {
										return false;}}}
								 return true;}
							return true;}}}}
			return false;}
		
		public static boolean StaleMate() {
	         //to check that king has no legal moves
				for(int i=0; i<8; i++) {
					for(int j=0; j<8; j++){
						if(Move.isLegalMove(getKingLocation(getKingColor()).getX(),getKingLocation(getKingColor()).getY(),i,j,"king",getKingColor(), Move.colorOccupied(i,j))) {
							if((!(isCheckKing(i,j)))) {//king has legal moves
								 return false; }}}}
				
				//to check that king is not in check and no one of its piece has legal move
				if(!(isCheck())) {ArrayList<Piece> team= new ArrayList<Piece>();
					for(Piece piece: Move.piecesBox) {if(piece.getName().equals("king")){System.out.println("0");}
						else if((piece.getColor().equals(getKingColor()))) team.add(piece);}

					for(Piece piece: team) {
						for(int i=0; i<8; i++) {
							for(int j=0; j<8; j++){
								if(((Move.isLegalMove(piece.getX(), piece.getY(),i, j, piece.getName(), getKingColor(), Move.colorOccupied(i,j))))) {
								return false;}}}}
					return true;}   return false; //conditions not satisfied
			     }
	
}
