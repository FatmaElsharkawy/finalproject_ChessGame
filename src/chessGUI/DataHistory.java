package chessGUI;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataHistory {

    private static final String FILE_NAME = "history.txt";

    public static void saveDataHistory(String data) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(data+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readDataHistory() {
        try {
            return Files.readAllLines(Paths.get(FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}