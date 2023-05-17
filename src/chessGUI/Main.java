package chessGUI;

import java.util.List;
import static chessGUI.DataHistory.readDataHistory;

public class Main {

	public static void main(String[] args) {
		
		List<String> history = readDataHistory();
		Login login= new Login(history);
	   // Chessboard board= new Chessboard("Madonna", "Fatma", "1");

	}

}
