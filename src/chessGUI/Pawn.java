package chessGUI;


public class Pawn extends Piece {
	int x_pawn,y_pawn; String name; String color;
	
public Pawn(String name, String color, int x_pawn, int y_pawn ) {
super("pawn", color, x_pawn, y_pawn );
}
public Pawn(Piece pawn) {
	super(pawn);
	}

@Override
public String takePathPhoto(String color) {
	return color.equals("White") ? "white_pawn.png" : "black_pawn.png";
}


@Override
public String getName() {
	return "pawn";
}

}