import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingExample {
    public static void main(String[] args) {
        // Create a JFrame (window)
        JFrame frame = new JFrame("Simple Swing Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel (container for components)
        JPanel panel = new JPanel();

        // Create a JButton
        JButton button = new JButton("Click Me!");

        // Create a JLabel
        JLabel label = new JLabel("Hello, Swing!");

        // Add the button and label to the panel
        panel.add(button);
        panel.add(label);

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });

        // Set the layout manager for the panel (optional)
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}