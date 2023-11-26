import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ITGUI extends JFrame {
    private JScrollPane scrollPane;

    public ITGUI() {
        // frame properties
        setTitle("UASAMS Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // panel for the navigation bar
        JPanel navBar = new JPanel(new BorderLayout());
        navBar.setBackground(Color.BLACK);
        navBar.setPreferredSize(new Dimension(getWidth(), 40)); // Adjust the height as needed

        //UASAMS logo on the left
        ImageIcon logoIcon = new ImageIcon("logo.png");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        navBar.add(logoLabel, BorderLayout.WEST);

        // add an action listener to the logo
        logoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollToTop();
            }
        });

        //a panel for the name and hamburger button
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel.setOpaque(false); // Make the panel transparent
        navBar.add(namePanel, BorderLayout.CENTER);

        // label on the left side of the hamburger button
        JLabel nameLabel = new JLabel("IT Name");
        nameLabel.setForeground(Color.WHITE); // Optional: Set the text color
        navBar.add(nameLabel, BorderLayout.CENTER);

        // Hamburger button on the right
        ImageIcon hamburgerIcon = new ImageIcon("images.png");
        Image scaledHamburger = hamburgerIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JButton hamburgerButton = new JButton(new ImageIcon(scaledHamburger));
        hamburgerButton.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 10));// Add right margin
        hamburgerButton.setBackground(Color.BLACK);
        hamburgerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPopupMenu(hamburgerButton);
            }
        });
        navBar.add(hamburgerButton, BorderLayout.EAST);

        // main content panel
        JPanel mainContent = new JPanel();
        // Add your components to the main content panel here...

        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));

        // wrap the main content panel in a JScrollPane
        scrollPane = new JScrollPane(mainContent);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // add the navigation bar to the NORTH position
        add(navBar, BorderLayout.NORTH);
        // add the scroll pane to the CENTER position
        add(scrollPane, BorderLayout.CENTER);

        addScholarshipITPanel();
    }

    private void addScholarshipITPanel() {
        JButton AccountAddButton = new JButton("Create Account");
        JButton AccountModifyButton = new JButton("Modify Account");
        JButton AccountDeactivateButton = new JButton("Deactivate Account");
        
        AccountAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAccountAdd();
            }
         });

         AccountModifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAccountModify();
            }
        });

         AccountDeactivateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAccountDeactivate();
            }
        });

        // Use GridBagLayout for centering
        JPanel scholarshipPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding

        // Set preferred size for the buttons to make them bigger
         AccountAddButton.setPreferredSize(new Dimension(200, 50));
        AccountModifyButton.setPreferredSize(new Dimension(200, 50));
        AccountDeactivateButton.setPreferredSize(new Dimension(200, 50));
       
        scholarshipPanel.add(AccountAddButton, gbc);
        gbc.gridy++;
        scholarshipPanel.add(AccountModifyButton, gbc);
        gbc.gridy++;
        scholarshipPanel.add(AccountDeactivateButton, gbc);
       
        add(scholarshipPanel, BorderLayout.CENTER);

    }
    
    private void showAccountAdd(){
        JFrame registrationFrame = createRegistrationFrame();
        JPanel registrationPanel = createRegistrationPanel();

        JButton registerButton = createRegisterButton(registrationFrame);
        registrationPanel.add(registerButton);

        registrationFrame.add(registrationPanel);
        registrationFrame.setVisible(true);

    }

    private JFrame createRegistrationFrame() {
        JFrame registrationFrame = new JFrame("Registration");
        registrationFrame.setSize(600, 500);
        registrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return registrationFrame;
    }

    private JPanel createRegistrationPanel() {
        JPanel registrationPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
    
        // components to the registration panel
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
        registrationPanel.add(new JLabel("Is this an Admin Account?"), gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 5;
        registrationPanel.add(new JCheckBox("Yes"), gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
    
        return registrationPanel;
    }

    private JButton createRegisterButton(JFrame registrationFrame) {
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> handleRegistration(registrationFrame));
        return registerButton;
    }

    private void handleRegistration(JFrame registrationFrame) {
        // add logic for registration when the button is clicked
        // You can retrieve user input from the text fields and check the checkbox
        // then perform the necessary actions like creating a new account
        // we may want to validate the input before proceeding with registration
        System.out.println("Registration logic here");
        registrationFrame.dispose(); // Close the registration frame after registration
    }

    private void showAccountModify(){
        JFrame modifyFrame = createModifyFrame();
        JPanel modifyPanel = createModifyPanel();
    
        JButton modifyButton = createModifyButton(modifyFrame);
        modifyPanel.add(modifyButton);
    
        modifyFrame.add(modifyPanel);
        modifyFrame.setVisible(true);
    }

    private JPanel createModifyPanel() {
        JPanel modifyPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
    
        // components for the modify panel (similar to the add panel)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        modifyPanel.add(new JLabel("Name:"), gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 1;
        modifyPanel.add(new JTextField(20), gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 2;
        modifyPanel.add(new JLabel("Email:"), gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 2;
        modifyPanel.add(new JTextField(20), gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 3;
        modifyPanel.add(new JLabel("Password:"), gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 3;
        modifyPanel.add(new JTextField(20), gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 4;
        modifyPanel.add(new JLabel("Contact Information(phone):"), gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 4;
        modifyPanel.add(new JTextField(20), gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 5;
        modifyPanel.add(new JLabel("Is this an Admin Account?"), gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 5;
        modifyPanel.add(new JCheckBox("Yes"), gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        return modifyPanel;
    }

    private JButton createModifyButton(JFrame modifyFrame) {
        JButton modifyButton = new JButton("Modify");
        modifyButton.addActionListener(e -> handleModification(modifyFrame));
        return modifyButton;
    }

    private void handleModification(JFrame modifyFrame) {
        /*  add logic for modification when the button is clicked
         You can retrieve user input from the text fields and check the checkbox
         then perform the necessary actions like updating the account
         we may want to validate the input before proceeding with modification*/
        System.out.println("Modification logic here");
        modifyFrame.dispose(); // close the modify frame after modification
    }
    
    private JFrame createModifyFrame() {
        JFrame modifyFrame = new JFrame("Modify Account");
        modifyFrame.setSize(600, 500);
        modifyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return modifyFrame;
    }

    private void showAccountDeactivate(){
        JFrame deactivateFrame = createDeactivateFrame();
        JPanel deactivatePanel = createDeactivatePanel();

        JButton deactivateButton = createDeactivateButton(deactivateFrame);
        deactivatePanel.add(deactivateButton);

        deactivateFrame.add(deactivatePanel);
        deactivateFrame.setVisible(true);
    }

    private JFrame createDeactivateFrame() {
        JFrame deactivateFrame = new JFrame("Deactivate Account");
        deactivateFrame.setSize(600, 500);
        deactivateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return deactivateFrame;
    }

    private JPanel createDeactivatePanel() {
        JPanel deactivatePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
    
        // components for the deactivate panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        deactivatePanel.add(new JLabel("Enter Email to Deactivate:"), gbc);
    
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Spanning two columns for the input field
        JTextField searchField = new JTextField(20);
        deactivatePanel.add(searchField, gbc);
    
        // Add spacing
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0.5; // Adjusted weight for spacing
        deactivatePanel.add(Box.createVerticalGlue(), gbc);
    
        // Add deactivate button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        //JButton deactivateButton = new JButton("Deactivate");
        //deactivateButton.addActionListener(e -> handleSearch(searchField.getText()));
        //deactivatePanel.add(deactivateButton, gbc);
    
        return deactivatePanel;
    }

    private JButton createDeactivateButton(JFrame deactivateFrame) {
        JButton deactivateButton = new JButton("Deactivate");
        deactivateButton.addActionListener(e -> handleDeactivation(deactivateFrame));
        return deactivateButton;
    }

    private void handleDeactivation(JFrame deactivateFrame) {
        /* add logic for deactivation when the button is clicked
        // we can perform the necessary actions like deactivating the account
        // we may want to ask for confirmation before deactivating*/
        System.out.println("Deactivation logic here"); 
        deactivateFrame.dispose(); // close the deactivate frame/GUI after deactivation
    }
/* 
    private void handleSearch (String email) {
         // replace this with our actual search and deactivation logic
        System.out.println("Searching for account with email: " + email);

        // placeholder for deactivation logic
        // You can replace this with your actual deactivation logic
        deactivateAccount(email);
        }

        // placeholder method for deactivating an account
        private void deactivateAccount(String email) {
        // replace this with your actual deactivation logic
        System.out.println("Deactivating account with email: " + email);
        }
*/
    private void showPopupMenu(Component invoker) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem supportItem = new JMenuItem("Support");
        JMenuItem logoutItem = new JMenuItem("Log Out");

        supportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle support action
                JOptionPane.showMessageDialog(ITGUI.this, "Support option clicked");
            }
        });

        logoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle logout action
                JOptionPane.showMessageDialog(ITGUI.this, "Log out option clicked");
            }
        });

        popupMenu.add(supportItem);
        popupMenu.add(logoutItem);

        popupMenu.show(invoker, 0, invoker.getHeight());
    }

    private void scrollToTop() {
        JViewport viewport = scrollPane.getViewport();
        viewport.setViewPosition(new Point(0, 0));
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ITGUI().setVisible(true);
            }
        });
    }
}
