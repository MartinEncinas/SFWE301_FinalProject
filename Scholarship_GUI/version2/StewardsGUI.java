import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StewardsGUI extends JFrame {
    private JScrollPane scrollPane;
    public StewardsGUI() {
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
        JLabel nameLabel = new JLabel("Stewards Name");
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

        // Wrap the main content panel in a JScrollPane
        scrollPane = new JScrollPane(mainContent);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the navigation bar to the NORTH position
        add(navBar, BorderLayout.NORTH);
        // Add the scroll pane to the CENTER position
        add(scrollPane, BorderLayout.CENTER);
        
        addScholarshipStewardsPanel();
    }

    private void addScholarshipStewardsPanel() {
        JButton ScholarshipReportButton = new JButton("Generate reports");

        ScholarshipReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showScholarshipReport();
            }
         });
          // Use GridBagLayout for centering
        JPanel scholarshipPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding

        // Set preferred size for the buttons to make them bigger
        ScholarshipReportButton.setPreferredSize(new Dimension(200, 50));

        scholarshipPanel.add(ScholarshipReportButton, gbc);
       
        add(scholarshipPanel, BorderLayout.CENTER);
    

    }
    private void showScholarshipReport() {

    }
        
    private void showPopupMenu(Component invoker) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem supportItem = new JMenuItem("Support");
        JMenuItem logoutItem = new JMenuItem("Log Out");

        supportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle support action
                JOptionPane.showMessageDialog(StewardsGUI.this, "Support option clicked");
            }
        });

        logoutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle logout action
                JOptionPane.showMessageDialog(StewardsGUI.this, "Log out option clicked");
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
                new StewardsGUI().setVisible(true);
            }
        });
    }
}
