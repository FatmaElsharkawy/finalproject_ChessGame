package chessGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import static chessGUI.DataHistory.readDataHistory;

public class User extends JFrame implements ActionListener {
    int i=0;
    String m;
    String n;
    int j=0;
    String player2;
    String player1;
    int timerValue;
    JFrame frame=new JFrame();
    JButton playButton = new JButton("start");
    JButton backButton = new JButton("back");
    JTextField playerField1 = new JTextField();
    JTextField playerField2 = new JTextField();
    JTextField timerField = new JTextField();
    JLabel playerLabel1 = new JLabel("Player 1:");
    JLabel playerLabel2 = new JLabel("Player 2:");
    JLabel timerLabel = new JLabel("Timer: ");
    JLabel messageLabel = new JLabel();
    JSlider timerSlider = new JSlider(JSlider.HORIZONTAL, 1, 15, 1); // Added JSlider
    // boolean correct1;
    // boolean  correct2;
    public User(){
        // correct1=corr1;
        // correct2=corr2;
        timerSlider.setBounds(200, 350, 350, 40);
        timerSlider.setPaintTicks(true);
        timerSlider.setMajorTickSpacing(1);
        timerSlider.setPaintLabels(true);
        playerLabel1.setBounds(100,250,350,40);
        playerLabel1.setFont(new Font("Arial", Font.BOLD, 22));
        playerLabel2.setBounds(100,300,350,40);
        playerLabel2.setFont(new Font("Arial", Font.BOLD, 22));
        timerLabel.setBounds(100,350,350,40);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 22));
        playerField1.setBounds(200,250,350,40);
        playerField2.setBounds(200,300,350,40);
        messageLabel.setBounds(250,550,500,40);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));
        playButton.setBounds(200,400,150,40);
        playButton.setFont(new Font("Arial", Font.BOLD, 15));
        playButton.setFocusable(false);
        playButton.addActionListener(this);
        backButton.setBounds(350,400,150,40);
        backButton.setFont(new Font("Arial", Font.BOLD, 15));
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(timerSlider);
        frame.add(playButton);
        frame.add(backButton);
        frame.add(playerField1);
        frame.add(playerField2);
        frame.add(playerLabel1);
        frame.add(playerLabel2);
        frame.add(timerLabel);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        ImageIcon backImage =new ImageIcon("ff.png");
        Image img =backImage.getImage();
        Image tempImage = img.getScaledInstance(700,800,Image.SCALE_SMOOTH);
        backImage =new ImageIcon(tempImage);
        JLabel backGround =new JLabel("",backImage,JLabel.CENTER);
        backGround.setBounds(0,0,700,800);
        frame.add(backGround);
        frame.repaint();
        // frame.setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==playButton){
            player1=playerField1.getText();
            player2=playerField2.getText();
            timerValue=timerSlider.getValue();
            if (player2.isEmpty()||player1.isEmpty()){
                messageLabel.setForeground(Color.red);
                messageLabel.setText("please complete the form");
            }
            else{

                Chessboard chessboard=new Chessboard(player1, player2, String.valueOf(timerValue));
                frame.dispose();}
        }
        else if(e.getSource()==backButton){
            List<String> history = readDataHistory();
            Login login=new Login(history);
            frame.dispose();
        }
    }
}