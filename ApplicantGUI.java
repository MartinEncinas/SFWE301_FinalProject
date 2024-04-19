import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicantGUI extends JFrame {
    private JScrollPane scrollPane;
    private JPanel mainContent;
    static JFrame applicantFrame = new JFrame();
    public ApplicantGUI() {
        // frame properties
        applicantFrame.setTitle("UASAMS Dashboard");
        applicantFrame.setSize(800, 600);
        applicantFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicantFrame.setLocationRelativeTo(null);

        // panel for the navigation bar
        JPanel navBar = new JPanel(new BorderLayout());
        navBar.setBackground(Color.BLACK);
        navBar.setPreferredSize(new Dimension(applicantFrame.getWidth(), 40)); // Adjust the height as needed

        //UASAMS logo on the left
        ImageIcon logoIcon = new ImageIcon("logo.png");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        navBar.add(logoLabel, BorderLayout.WEST);
        
        // Add an action listener to the logo
        logoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollToTop();
            }
        });

        //a panel for the name and hamburger button
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel.setOpaque(false); // Make the panel transparent
        navBar.add(namePanel, BorderLayout.CENTER);

        // label on the left side of the hamburger button
        JLabel nameLabel = new JLabel("Applicant Name");
        nameLabel.setForeground(Color.WHITE); // Optional: Set the text color
        navBar.add(nameLabel, BorderLayout.CENTER);

        // Hamburger button on the right
        ImageIcon hamburgerIcon = new ImageIcon("images.png");
        Image scaledHamburger = hamburgerIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        JButton hamburgerButton = new JButton(new ImageIcon(scaledHamburger));
        hamburgerButton.setBorder(BorderFactory.createEmptyBorder(10,10, 10, 10));// Add right margin
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
        applicantFrame.add(navBar, BorderLayout.NORTH);
        // Add the scroll pane to the CENTER position
        applicantFrame.add(scrollPane, BorderLayout.CENTER);

        JButton scholarshipSearchButton = new JButton("Scholarship Search");
        JButton currentApplicationsButton = new JButton("Current Applications");
        JButton availableScholarshipsButton = new JButton("Available Scholarships");

        scholarshipSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showScholarshipSearch();
            }
         });

        currentApplicationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCurrentApplications();
            }
        });

        availableScholarshipsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAvailableScholarships();
            }
        });

        /* 
        JPanel scholarshipPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        scholarshipPanel.add(currentApplicationsButton);
        scholarshipPanel.add(availableScholarshipsButton);
        scholarshipPanel.add(scholarshipSearchButton);
         */

         // Use GridBagLayout for centering
        JPanel scholarshipPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding

        // Set preferred size for the buttons to make them bigger
        scholarshipSearchButton.setPreferredSize(new Dimension(200, 50));
        currentApplicationsButton.setPreferredSize(new Dimension(200, 50));
        availableScholarshipsButton.setPreferredSize(new Dimension(200, 50));
       
        scholarshipPanel.add(scholarshipSearchButton, gbc);
        gbc.gridy++;
        scholarshipPanel.add(currentApplicationsButton, gbc);
        gbc.gridy++;
        scholarshipPanel.add(availableScholarshipsButton, gbc);
        applicantFrame.getContentPane().add(scholarshipPanel);
        applicantFrame.setVisible(true);
        applicantFrame.add(scholarshipPanel, BorderLayout.CENTER);
         
    }

    public void addScholarshipPanel() {
        
        
    }

    private void showCurrentApplications() {
        JOptionPane.showMessageDialog(this, "List of Current Applications\nApplication 1: Accepted\nApplication 2: Pending");
    }

    private void showAvailableScholarships() {
        JOptionPane.showMessageDialog(this, "List of Available Scholarships\nScholarship 1\nScholarship 2");
    }

    private void showScholarshipSearch() {
        String searchQuery = JOptionPane.showInputDialog(this, "Enter search query:");
        String searchResults = "";
        for(int i = 0; i < 100; i++) {
            if(LoginSignupGUI.scholarships[i].getDescription().contains(searchQuery))
            {
                searchResults = searchResults + " " + LoginSignupGUI.scholarships[i].getName();
                break;
            }
        }
        if (searchQuery != null) {
            JOptionPane.showMessageDialog(this, " Search Results for: " + searchQuery + "\n" + searchResults);
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
                JOptionPane.showMessageDialog(ApplicantGUI.this, "Support option clicked");
            }
        });

        logoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle logout action
                //JOptionPane.showMessageDialog(ApplicantGUI.this, "Log out option clicked");
                LoginSignupGUI log1 = new LoginSignupGUI();
                log1.openLoginSignupGUI();
                applicantFrame.dispose();
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
                new ApplicantGUI().setVisible(true);
            }
        });
    }
    */
}

