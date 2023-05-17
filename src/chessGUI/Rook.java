package chessGUI;

import java.util.Set;

public class Rook extends Piece {
	
	
	
	int x_rook, y_rook; String name; String color;
	boolean moveOccurkb1=false, moveOccurkb2=false, moveOccurkb3=false, moveOccurkb4=false;
	
  public Rook(String name, String color, int x_rook, int y_rook) { 
	    super("rook", color, x_rook, y_rook );
	    }

@Override
public String takePathPhoto(String color) {	
	return color.equals("White") ? "white_rook.png" : "black_rook.png";
}

@Override
 public String getName() {
		return "rook"; }

//Rook Black Left first Move Check
	public boolean RBLeft(){
		if(moveOccurkb1) { return false;}
		if(Move.isSquareOccupied(0,0)==null){
			moveOccurkb1=true; return false;}
		return true;
	}
	// Rook Black Right first Move Check
	public boolean RBRight(){
		if(moveOccurkb2) { return false;}
		if(Move.isSquareOccupied(0,7)==null){
			moveOccurkb2=true; return false;}
		return true;
	}
			
	//White Left Rook First Move Check
			public boolean RWLeft(){
				if(moveOccurkb3) { return false;}
				if(Move.isSquareOccupied(7,0)==null){
					moveOccurkb3=true; return false;}
				return true;}
			
	//White Right Rook First Move Check
			public boolean RWRight(){
				if(moveOccurkb4) { return false;}
				if(Move.isSquareOccupied(7,7)==null){
					moveOccurkb4=true; return false;}
				return true;
			}
}
