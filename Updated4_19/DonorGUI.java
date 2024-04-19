import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonorGUI extends JFrame {
    private JScrollPane scrollPane;
    private JPanel mainContent;
    static JFrame donorFrame = new JFrame();
    public DonorGUI() {
        // frame properties
        donorFrame.setTitle("UASAMS Dashboard");
        donorFrame.setSize(800, 600);
        donorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        donorFrame.setLocationRelativeTo(null);

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

        // Add an action listener to the logo
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
        JLabel nameLabel = new JLabel("Donor Name");
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
        mainContent = new JPanel();
        // Add your components to the main content panel here...

        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));

        // Wrap the main content panel in a JScrollPane
        scrollPane = new JScrollPane(mainContent);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the navigation bar to the NORTH position
        donorFrame.add(navBar, BorderLayout.NORTH);
        // Add the scroll pane to the CENTER position
        donorFrame.add(scrollPane, BorderLayout.CENTER);

        addScholarshipDonorPanel();

    }

    public void addScholarshipDonorPanel() {
        JButton scholarshipCreateButton = new JButton("Create Scholarship");
        JButton ModifyButton = new JButton("Modify Scholarship");
        JButton DeleteScholarshipsButton = new JButton("Delete Scholarchip");

         scholarshipCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showScholarshipCreate();
            }
         });

        ModifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showModify();
            }
        });

        DeleteScholarshipsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDeleteScholarships();
            }
        });

         // Use GridBagLayout for centering
        JPanel scholarshipPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding

        // Set preferred size for the buttons to make them bigger
        scholarshipCreateButton.setPreferredSize(new Dimension(800, 600));
        ModifyButton.setPreferredSize(new Dimension(800, 600));
        DeleteScholarshipsButton.setPreferredSize(new Dimension(800, 600));
       
        scholarshipPanel.add(scholarshipCreateButton, gbc);
        gbc.gridy++;
        scholarshipPanel.add(ModifyButton, gbc);
        gbc.gridy++;
        scholarshipPanel.add(DeleteScholarshipsButton, gbc);
       
        donorFrame.add(scholarshipPanel, BorderLayout.CENTER);
        donorFrame.getContentPane().add(scholarshipPanel);
        donorFrame.setVisible(true);
    }

    private void showScholarshipCreate() {
        JTextField nameField = new JTextField();
        JTextArea descriptionArea = new JTextArea();
        JTextArea eligibilityArea = new JTextArea();
        JTextArea applicationRequirementsArea = new JTextArea();
        JTextField awardAmountField = new JTextField();
        JTextField deadlinesField = new JTextField();
    
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5); // Set the initial number of rows
    
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(new Dimension(800, 600));  // Set preferred size
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
    
        panel.add(new JLabel("Scholarship name:"), gbc);
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(nameField, gbc);
        gbc.gridy++;
        panel.add(new JLabel("Description:"), gbc);
        gbc.gridy++;
        gbc.gridwidth = 2;  // Make the descriptionArea span 2 columns
        gbc.weightx = 1.0;  // Allow descriptionArea to expand horizontally
        gbc.fill = GridBagConstraints.BOTH;
        
        // Set a fixed size for the JScrollPane containing the descriptionArea
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        descriptionScrollPane.setPreferredSize(new Dimension(400, 100));
        
        panel.add(descriptionScrollPane, gbc);
        gbc.gridy++;
        gbc.gridwidth = 1;  // Reset gridwidth
        gbc.weightx = 0.0;  // Reset weight
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JLabel("Eligibility Requirements:"), gbc);
        gbc.gridy++;
        panel.add(new JScrollPane(eligibilityArea), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Application Requirements:"), gbc);
        gbc.gridy++;
        panel.add(new JScrollPane(applicationRequirementsArea), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Award amount:"), gbc);
        gbc.gridy++;
        panel.add(awardAmountField, gbc);
        gbc.gridy++;
        panel.add(new JLabel("Application deadlines:"), gbc);
        gbc.gridy++;
        panel.add(deadlinesField, gbc);
    
        int result = JOptionPane.showConfirmDialog(null, panel, "Create Scholarship",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            // Process the entered data as before
            String name = nameField.getText();
            String description = descriptionArea.getText();
            String eligibility = eligibilityArea.getText();
            String applicationRequirements = applicationRequirementsArea.getText();
            String awardAmount = awardAmountField.getText();
            String deadlines = deadlinesField.getText();
            
            LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setName(name);
            LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setDescription(description);
            LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setEligibility(eligibility);
            LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setRequirements(applicationRequirements);
            LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setAmount(awardAmount);
            LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setDeadlines(deadlines);
            LoginSignupGUI.scholcounter++;
            // Perform actions with the entered data as needed
            //System.out.println("Title: " + name);
            //System.out.println("Description: " + description);
            //System.out.println("Eligibility: " + eligibility);
            //System.out.println("Application Requirements: " + applicationRequirements);
            //System.out.println("Award amount: " + awardAmount);
            //System.out.println("Application deadlines: " + deadlines);
        }
    }
    
    private void showModify() {
        JTextField nameField = new JTextField();
        JTextArea descriptionArea = new JTextArea();
        JTextArea eligibilityArea = new JTextArea();
        JTextArea applicationRequirementsArea = new JTextArea();
        JTextField awardAmountField = new JTextField();
        JTextField deadlinesField = new JTextField();
    
        // Set default values for modification (replace with actual values)
        nameField.setText("Existing Name");
        descriptionArea.setText("Existing Description");
        eligibilityArea.setText("Existing Eligibility");
        applicationRequirementsArea.setText("Existing Application Requirements");
        awardAmountField.setText("Existing Award Amount");
        deadlinesField.setText("Existing Deadlines");
    
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5); // Set the initial number of rows
    
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setPreferredSize(new Dimension(800, 600));  // Set preferred size
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
    
        panel.add(new JLabel("Scholarship name:"), gbc);
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(nameField, gbc);
        gbc.gridy++;
        panel.add(new JLabel("Description:"), gbc);
        gbc.gridy++;
        gbc.gridwidth = 2;  // Make the descriptionArea span 2 columns
        gbc.weightx = 1.0;  // Allow descriptionArea to expand horizontally
        gbc.fill = GridBagConstraints.BOTH;
    
        // Set a fixed size for the JScrollPane containing the descriptionArea
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        descriptionScrollPane.setPreferredSize(new Dimension(400, 100));
    
        panel.add(descriptionScrollPane, gbc);
        gbc.gridy++;
        gbc.gridwidth = 1;  // Reset gridwidth
        gbc.weightx = 0.0;  // Reset weight
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JLabel("Eligibility Requirements:"), gbc);
        gbc.gridy++;
        panel.add(new JScrollPane(eligibilityArea), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Application Requirements:"), gbc);
        gbc.gridy++;
        panel.add(new JScrollPane(applicationRequirementsArea), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Award amount:"), gbc);
        gbc.gridy++;
        panel.add(awardAmountField, gbc);
        gbc.gridy++;
        panel.add(new JLabel("Application deadlines:"), gbc);
        gbc.gridy++;
        panel.add(deadlinesField, gbc);
    
        int result = JOptionPane.showConfirmDialog(null, panel, "Modify Scholarship",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        if (result == JOptionPane.OK_OPTION) {
            // Process the entered data as before
            String name = nameField.getText();
            String description = descriptionArea.getText();
            String eligibility = eligibilityArea.getText();
            String applicationRequirements = applicationRequirementsArea.getText();
            String awardAmount = awardAmountField.getText();
            String deadlines = deadlinesField.getText();
            
            for(int i = 0; i < 100; i++)
            {
                if(name.equals(LoginSignupGUI.scholarships[i].getName()))
                {
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setName(name);
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setDescription(description);
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setEligibility(eligibility);
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setRequirements(applicationRequirements);
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setAmount(awardAmount);
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setDeadlines(deadlines);
                   break;
                }
            }
            // Perform actions with the entered data as needed
            //System.out.println("Modified Title: " + name);
            //System.out.println("Modified Description: " + description);
            //System.out.println("Modified Eligibility: " + eligibility);
            //System.out.println("Modified Application Requirements: " + applicationRequirements);
            //System.out.println("Modified Award amount: " + awardAmount);
            //System.out.println("Modified Application deadlines: " + deadlines);
        }
    }

    private void showDeleteScholarships() {
       // Custom dialog for deleting a scholarship
    JTextField scholarshipToDeleteField = new JTextField();

    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Scholarship Title to Delete:"));
    panel.add(scholarshipToDeleteField);

    int result = JOptionPane.showConfirmDialog(null, panel, "Delete Scholarship",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result == JOptionPane.OK_OPTION) {
        // Process the entered data, e.g., delete the scholarship with the specified title
        String scholarshipToDelete = scholarshipToDeleteField.getText();
        
        for(int i = 0; i < 100; i++)
            {
                if(getName().equals(LoginSignupGUI.scholarships[i].getName()))
                {
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setName("null");
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setDescription("null");
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setEligibility("null");
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setRequirements("null");
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setAmount("null");
                   LoginSignupGUI.scholarships[LoginSignupGUI.scholcounter].setDeadlines("null");
                   break;
                }
            }
        // Perform actions with the entered data as needed
        // You may want to delete the scholarship or perform other operations
        //System.out.println("Deleted Scholarship Title: " + scholarshipToDelete);
    }
    }
        
    private void showPopupMenu(Component invoker) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem supportItem = new JMenuItem("Support");
        JMenuItem logoutItem = new JMenuItem("Log Out");

        supportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle support action
                JOptionPane.showMessageDialog(DonorGUI.this, "Support option clicked");
            }
        });

        logoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle logout action
                //JOptionPane.showMessageDialog(DonorGUI.this, "Log out option clicked");
                LoginSignupGUI log1 = new LoginSignupGUI();
                log1.openLoginSignupGUI();
                donorFrame.dispose();
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
    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DonorGUI().setVisible(true);
            }
        });
    }
*/
}

