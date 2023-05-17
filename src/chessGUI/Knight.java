package chessGUI;


public class Knight extends Piece {
	
	int x_knight; int y_knight; String name; String color;
	public Knight(String name, String color, int x_knight, int y_knight  ) {
		super("knight", color, x_knight, y_knight );	
		}
	public Knight(Piece knight) {
		super(knight);
	}
 

	@Override
	public String takePathPhoto(String color) {
		return color.equals("White") ? "white_knight.png" : "black_knight.png";
	}


	@Override
	public String getName() {
		return "knight";
	}
	
	
}