import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userLoginPage {
    private JPanel mainPanel;
    private JTextField username;
    private JTextField password;
    private JButton confirmButton;

    public userLoginPage(JFrame frame) {
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = username.getText();
                String enteredPassword = password.getText();

                // Checking credentials
                if ( (enteredUsername.equals("lr4911") && enteredPassword.equals("lakshya000")) || (enteredUsername.equals("hz0003") && enteredPassword.equals("himansh000")) || (enteredUsername.equals("tv5561") && enteredPassword.equals("tejasvi000"))|| (enteredUsername.equals("ng9575") && enteredPassword.equals("nandini000")) ) {
                    JOptionPane.showMessageDialog(mainPanel, "Login Successful! Redirecting to the workspace...");

                    // Redirect to mainMenu and close the login page
                    frame.setContentPane(new mainMenu(frame).mainMenuPanel); // Switch to mainMenu
                    frame.revalidate(); // Refresh the frame
                    frame.pack(); // Adjust the frame size to fit the new content
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Incorrect Username or Password. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    username.setText(""); // Clearing the fields for re-entry
                    password.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("User Login Page");
        frame.setTitle("Login to Workspace");
        frame.setSize(450, 800);
        frame.setBounds(600, 200, 450, 800);
        frame.setContentPane(new userLoginPage(frame).mainPanel); // Pass the frame reference
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
