package chessGUI;


public class Bishop extends Piece {
	int xbishop; int ybishop; String name; String color;
	
public Bishop(String name, String color, int xbishop, int ybishop) {
super("bishop", color, xbishop, ybishop);
}
 public Bishop(Piece bishop) {
	super(bishop);
}



@Override
public String takePathPhoto(String color) {
	return color.equals("White") ? "white_bishop.png" : "black_bishop.png";
}

@Override
public String getName() {
	return "bishop";
}

}