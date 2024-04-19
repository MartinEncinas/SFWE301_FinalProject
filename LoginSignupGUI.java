

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSignupGUI {
    public static NewAccount[] accounts = new NewAccount[100];
    public static Scholarship[] scholarships = new Scholarship[100];
    static LoginSignupGUI loginSignupGUI;
    public static int counter = 1;
    public static int scholcounter = 0;
    JFrame frame = new JFrame("Login / Signup");
   // private JFrame frame; // Instance variable to store the JFrame
    public static void main(String[] args) {
        NewAccount acc1 = new NewAccount("John Martin", "University of Arizona", "999-999-9999", "John12@gmail.com", "P@ssword", "1");
        NewAccount acc2 = new NewAccount("Caleb Chang", "University of Arizona", "999-999-9999", "CChang@gmail.com", "P@ssword", "2");
        NewAccount acc3 = new NewAccount("Miguel Rocha", "University of Arizona", "999-999-9999", "Miguel@gmail.com", "P@ssword", "3");
        NewAccount acc4 = new NewAccount("Daniela", "University of Arizona", "999-999-9999", "Daniela@gmail.com", "P@ssword", "4");
        NewAccount acc5 = new NewAccount("Katie", "University of Arizona", "999-999-9999", "Katie@gmail.com", "P@ssword", "5");
        accounts[0] = acc1;
        accounts[1] = acc2;
        accounts[2] = acc3;
        accounts[3] = acc4;
        accounts[4] = acc5;
        NewAccount acc6 = new NewAccount();
        for(int i = 5; i < 100; i++) {
            accounts[i] = acc6;
        }
        Scholarship schol = new Scholarship();
        for(int i = 0; i < 100; i++) {
            scholarships[i] = schol;
        }
        scholarships[0].setName("Success");
        scholarships[0].setDescription("Filler");
        /*
        accounts[0].setContactEmails("John12@gmail.com");
        accounts[0].setContactPassword("P@ssword");
        accounts[0].setPermissions("3"); // 1 being applicant 2 is IT 3 is Admin/Staff 4 is Steward 5 Donor 
        accounts[0].setName("John Martin");
        accounts[0].setAcademicHistory("Software Engineering");
        accounts[0].setContactDetails("999-999-9999");
        */
        // Create an instance of LoginSignupGUI
        loginSignupGUI = new LoginSignupGUI();
          
        // Call the instance method to set up and display the GUI
        loginSignupGUI.setupAndDisplayGUI();
    }
    public void openLoginSignupGUI() {
        loginSignupGUI.setupAndDisplayGUI();
    }
    public void setupAndDisplayGUI() {
        
        
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
                RegistrationGUI reg1 = new RegistrationGUI();
                reg1.openRegistrationGUI();
                
                frame.dispose(); // this command/method close the login/signup GUI before openeing Registration GUI but, 
                                 // we need to make sure to adjust the variable names and methods based on your actual code structure.
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = emailField.getText();
                String pass = passwordField.getText();
                boolean login = false;
                
                for(int i = 0; i < accounts.length; i++)
                {
                    if(username.equals(accounts[i].getContactEmails()))
                    {
                        if(pass.equals(accounts[i].getContactPassword()))
                        {
                            login = true;
                            switch(accounts[i].getPermissions()) {
                                case "1":
                                    
                                    new ApplicantGUI().addScholarshipPanel();
                                    //System.out.println("1");
                                    frame.dispose();
                                    break;
                                case "2":
                                    new ITGUI().addScholarshipITPanel();
                                    frame.dispose();
                                    break;
                                case "3":
                                    new AdminGUI().addScholarshipAdminPanel();
                                    frame.dispose();
                                    break;
                                case "4":
                                    new StewardsGUI().addScholarshipStewardsPanel();
                                    frame.dispose();
                                    break;
                                case "5":
                                    new DonorGUI().addScholarshipDonorPanel();
                                    frame.dispose();
                                    break;
                            }
                        }
                    }
                }                
            }
        });

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        
    }
}
