package chessGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Score implements ActionListener {
    int m=0;
    Object[][] data ;
        private JFrame frame;
        private JTable table;
        JButton button =new JButton("back");
        List<String> scoreInformation;
        public Score(List<String> hist) {
            scoreInformation =hist;
                frame = new JFrame("Score Table");

                // Create a new ScoreData object to get the data for the table

                // Get the data and column names from the ScoreData object
            data =new Object[scoreInformation.size()/2][2];

            for (int i = 0; i < scoreInformation.size()/2; i++) {
                for (int j = 0; j < 2; j++) {
                   data [i][j]=scoreInformation.get(i+j+m);
                   // String nn =scoreInformation.get(i);

                }
                m++;
            }
               // Object[][] data = scoreData.getData();

                String[] columnNames = {"name", "score"};

                // Create a new JTable with the data and column names
                table = new JTable(data, columnNames);

                // Create a scroll pane and add the table to it
                JScrollPane scrollPane = new JScrollPane(table);

            button.setBounds(250,500,300,40);
            button.setFont(new Font("Arial", Font.BOLD, 15));
            button.setFocusable(false);
            button.addActionListener(this);

                // Add the scroll pane to a panel
                JPanel panel = new JPanel();
                panel.add(scrollPane);
                panel.add(button);

                // Add the panel to the frame
                frame.add(panel);

                // Set the size and visibility of the frame
                frame.setSize(700, 500);

                frame.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            Page page =new Page();
            frame.dispose();
        }
    }
}