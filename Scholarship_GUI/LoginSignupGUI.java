import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSignupGUI {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login / Signup");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // padding

        ImageIcon logoIcon = new ImageIcon("UAlog.png");  // image logo
        JLabel logoLabel = new JLabel(logoIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(logoLabel, gbc);

        JLabel titleLabel = new JLabel("Scholarship Application");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JCheckBox showPasswordCheckbox = new JCheckBox("Show Password");

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(showPasswordCheckbox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        mainPanel.add(loginButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        mainPanel.add(signupButton, gbc);

        // action listener to the showPasswordCheckbox
        showPasswordCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle the password field's echo char based on checkbox state
                char echoChar = showPasswordCheckbox.isSelected() ? '\0' : '*';
                passwordField.setEchoChar(echoChar);
            }
        });
        // action listener to the signup button
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a new JFrame for registration
                RegistrationGUI.openRegistrationGUI();

                frame.dispose(); // this command/method close the login/signup GUI before openeing Registration GUI but, 
                                 // we need to make sure to adjust the variable names and methods based on your actual code structure.
            }
        });

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        
}
}
