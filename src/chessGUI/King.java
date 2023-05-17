package chessGUI;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {
	
	Chessboard board;
	Game game;
	Move move;
	boolean moveOccurkb =false; boolean moveOccurkw =false;
	
 int x_king; int y_king; String name; String color;
	
	public King(String name, String color, int x_king, int y_king) {
		super("king", color, x_king, y_king );
	}
	

	@Override
	public String takePathPhoto(String color) {
		return color.equals("White") ? "white_king.png" : "black_king.png";
	}
	
	@Override
	public String getName() {
		return "king";
	}
	
	//King Black first Move Check
		public boolean KBFM(){
			if(moveOccurkb) {return false;}
		    if(Move.isSquareOccupied(0,4)==null){ moveOccurkb=true; return false;}
			return true;
		}
		
		//King White First Move Check
		public boolean KWFM(){
			if(moveOccurkw) {return false;}
			if(Move.isSquareOccupied(7,4)==null){ moveOccurkw=true; return false;}
			return true;
		}

	
}
