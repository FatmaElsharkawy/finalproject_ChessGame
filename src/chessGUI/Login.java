package chessGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import static chessGUI.DataHistory.readDataHistory;

public class Login extends JFrame implements ActionListener {
 JFrame frame = new JFrame();
  JLabel label=new JLabel();

    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton createButton = new JButton("create an account");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("UserID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    //HashMap<String,String> logininfo = new HashMap<String,String>();
    List<String> logininfo ;
   public Login(List<String> hist){

      logininfo = hist;

       userIDField.setFont(new Font("Arial", Font.BOLD, 14));

       userPasswordField .setFont(new Font("Arial", Font.BOLD, 14));

       userIDLabel.setBounds(100,300,400,40);
       userIDLabel.setFont(new Font("Arial", Font.BOLD, 22));

       userPasswordLabel.setBounds(100,350,400,40);
       userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 22));

        messageLabel.setBounds(250,550,500,40);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDField.setBounds(250,300,350,40);
        userPasswordField.setBounds(250,350,350,40);

        loginButton.setBounds(250,450,150,40);
      // loginButton.setForeground(Color.blue);
       //loginButton.setBackground(Color.lightGray);
       loginButton.setFont(new Font("Arial", Font.BOLD, 15));
      // loginButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
       loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(400,450,150,40);
       resetButton.setFont(new Font("Arial", Font.BOLD, 15));
       resetButton.setFocusable(false);
        resetButton.addActionListener(this);

       createButton.setBounds(250,500,300,40);
       createButton.setFont(new Font("Arial", Font.BOLD, 15));
       createButton.setFocusable(false);
       createButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(createButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(null);
        label.setText("Chess Game");
        label.setForeground(new Color(0x2A1685));
        frame.setVisible(true);
        frame.setTitle("Chess Game");
        label.setBounds(50,100,1000,100);

        label.setFont(new Font("eman",Font.BOLD,100));
        frame.setSize(700,800);
       frame.setLocationRelativeTo(null);

       frame.add(label);

       frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0xFFAFDFF1, true));
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            RegisterationForm form = new RegisterationForm(logininfo);
            frame.dispose();
        }

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource() == loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            for (int n = 1; n < logininfo.size(); n+=3) {
                if (userID.equals(logininfo.get(n))) {
                    if (password.equals(logininfo.get(n + 1))) {
                       // messageLabel.setForeground(Color.green);
                        //messageLabel.setText("Login successful");
                        Page page =new Page();

                        frame.dispose();
                     
                        break;
                    } else {
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText("Wrong password");
                        break;
                    }
                }
            }

            messageLabel.setForeground(Color.red);
            messageLabel.setText("invalid account");
        }
    }

        public void showmsg (String msg ){
        JOptionPane.showMessageDialog(this,msg);
        }
}