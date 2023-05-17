package chessGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import static chessGUI.Data.readData;

public class Page extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    JButton playGameButton = new JButton("play");
    JButton scoreButton = new JButton("score");

    JLabel messageLabel = new JLabel();

    public Page() {

        messageLabel.setBounds(650, 550, 500, 40);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        playGameButton.setBounds(100, 300, 200, 50);
        playGameButton.setFont(new Font("Arial", Font.BOLD, 15));
        playGameButton.setFocusable(false);
        playGameButton.addActionListener(this);

        scoreButton.setBounds(100, 400, 200, 50);
        scoreButton.setFont(new Font("Arial", Font.BOLD, 15));
        scoreButton.setFocusable(false);
        scoreButton.addActionListener(this);

        frame.add(messageLabel);
        frame.add(playGameButton);
        frame.add(scoreButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);
        frame.setVisible(true);

      //  frame.setLocationRelativeTo(null);
        frame.setSize(700, 800);
        frame.setLocationRelativeTo(null);
      //  frame.setResizable(false); // if we don't need the user to be able to change size of the window.

ImageIcon backImage =new ImageIcon("chess.jpg");
Image img =backImage.getImage();
Image tempImage = img.getScaledInstance(700,800,Image.SCALE_SMOOTH);
backImage =new ImageIcon(tempImage);
JLabel backGround =new JLabel("",backImage,JLabel.CENTER);
backGround.setBounds(0,0,700,800);
frame.add(backGround);
        frame.repaint();
        frame.setResizable(false);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playGameButton) {
            User user = new User();
            frame.dispose();
        }

        if (e.getSource() == scoreButton) {
            List<String> history = readData();
Score score=new Score(history);
frame.dispose();
        }

    }}