package chessGUI;


public class Queen extends Piece {
int x_queen; int y_queen; String name; String color;
	
	public Queen(String name, String color, int x_queen, int y_queen  ) {
		super("queen", color, x_queen, y_queen );
	}
	public Queen(Piece queen) {
		super(queen);
		}
	

	@Override
	public String takePathPhoto(String color) {
		return color.equals("White") ? "white_queen.png" : "black_queen.png";
	}
	
	
	@Override
	public String getName() {
		return "queen";
	}
	
}
