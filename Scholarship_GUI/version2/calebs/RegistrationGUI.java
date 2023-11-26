import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationGUI {
    static JFrame registrationFrame = new JFrame("Registration");
    public void openRegistrationGUI() {
        
        registrationFrame.setSize(600, 500);
        registrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel registrationPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        registrationPanel.add(new JLabel("Registration Form"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        registrationPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        registrationPanel.add(new JTextField(20), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        registrationPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        registrationPanel.add(new JTextField(20), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        registrationPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        registrationPanel.add(new JTextField(20), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        registrationPanel.add(new JLabel("Contact Information(phone):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        registrationPanel.add(new JTextField(20), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        registrationPanel.add(new JLabel("Are you an applicant?"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        registrationPanel.add(new JCheckBox("Yes"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        registrationPanel.add(new JLabel("School Name (if applicant):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        registrationPanel.add(new JTextField(20), gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        registrationPanel.add(new JLabel("Organization Name (if donor):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        registrationPanel.add(new JTextField(20), gbc);
        JButton registerButton = new JButton("Register");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        registrationPanel.add(registerButton, gbc);

        
        ActionListener actionListener;
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // registration logic here... good luck guys. You can delete/edit below if u want.
                
                // use the retrieved values for further processing or validation back end part here
                LoginSignupGUI log1 = new LoginSignupGUI();
                log1.openLoginSignupGUI();
                registrationFrame.dispose(); // Close the registration GUI
            }
        };
        registerButton.addActionListener(actionListener);
        
        registrationFrame.getContentPane().add(registrationPanel);
        registrationFrame.setVisible(true);
    }
}
