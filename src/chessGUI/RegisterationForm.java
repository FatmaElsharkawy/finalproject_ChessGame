package chessGUI;

import java.awt.*;
import java.awt.event.*;

import java.util.List;
import javax.swing.*;

import static chessGUI.DataHistory.saveDataHistory;

public class RegisterationForm implements ActionListener{

    JFrame frame = new JFrame();
    JButton registerButton = new JButton("register");
    JButton cancelButton = new JButton("cancel");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("user name:");
    JLabel userPasswordLabel = new JLabel("password:");
    JPasswordField confirmedUserPasswordField = new JPasswordField();
    JLabel confirmedUserPasswordLabel = new JLabel("confirm password:");
   // JTextField emailField = new JTextField();

    //JLabel emailLabel = new JLabel("email:");
    JLabel messageLabel = new JLabel();
    List<String> loginInformation;
    //HashMap<String,String> logininfo = new HashMap<String,String>();

   public RegisterationForm(List<String> hist ) {

       // logininfo = loginInfoOriginal;
       loginInformation = hist;
       userIDLabel.setBounds(200,100,350,40);
       userIDLabel.setFont(new Font("Arial", Font.BOLD, 22));

       userPasswordLabel.setBounds(200,200,350,40);
       userPasswordLabel.setFont(new Font("Arial", Font.BOLD, 22));

       confirmedUserPasswordLabel.setBounds(200,300,350,40);
       confirmedUserPasswordLabel.setFont(new Font("Arial", Font.BOLD, 22));

       userIDField.setBounds(200,150,350,40);
       userPasswordField.setBounds(200,250,350,40);
       confirmedUserPasswordField.setBounds(200,350,350,40);
       messageLabel.setBounds(250,550,500,40);
       messageLabel.setFont(new Font(null,Font.ITALIC,25));

       registerButton.setBounds(200,450,150,40);
       registerButton.setFont(new Font("Arial", Font.BOLD, 15));
       registerButton.setFocusable(false);
       registerButton.addActionListener(this);

       cancelButton.setBounds(350,450,150,40);
       cancelButton.setFont(new Font("Arial", Font.BOLD, 15));
       cancelButton.setFocusable(false);
       cancelButton.addActionListener(this);

       frame.add(userIDLabel);
       frame.add(userPasswordLabel);
       frame.add(messageLabel);
       frame.add(userIDField);
       frame.add(userPasswordField);
       frame.add(registerButton);
       frame.add(cancelButton);
       frame.add(confirmedUserPasswordField);
       frame.add(confirmedUserPasswordLabel);
      // frame.add(emailField);
      // frame.add(emailLabel);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(700, 800);
       frame.setLayout(null);
       frame.setVisible(true);
       frame.setLocationRelativeTo(null);
       frame.getContentPane().setBackground(new Color(0xFFAFDFF1, true));

   }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==cancelButton) {
    frame.dispose();
        }

        if(e.getSource()==registerButton) {
            String name = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            String confirm = String.valueOf(confirmedUserPasswordField.getPassword());
            boolean correct=true;
            if(name.isEmpty()||password.isEmpty()||confirm.isEmpty()){
           // String email = emailField.getText();
                messageLabel.setForeground(Color.red);
                messageLabel.setText("please complete the form");}
               // saveDataHistory(email);
else{
            if(password.equals(confirm)) {
                for (int n = 1; n < loginInformation.size(); n+=3) {
                    if (name.equals(loginInformation.get(n))) {
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText(" user name already exists");
                        correct=false;
                        break;
                    } else if (password.equals(loginInformation.get(n + 1))) {
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText("password already exists");
                        correct=false;
                        break;
                    }
                }

                    if(correct==true){
                saveDataHistory("new account");
                saveDataHistory(name);
                saveDataHistory(password);
                   // messageLabel.setForeground(Color.green);
                  //  messageLabel.setText("register successful");

                        frame.dispose();
                        //WelcomePage welcomePage = new WelcomePage(userID);
                }}
                else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("please enter the same password");
            }

            }

        }
    }
}