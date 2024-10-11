import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class eventsPage {
    private JButton event1;
    private JButton event2;
    private JButton event3;
    private JButton event4;
    private JLabel event1_image;
    private JLabel event2_image;
    private JLabel event3_image;
    private JLabel event4_image;
    private JLabel event1_name;
    private JLabel event2_name;
    private JLabel event3_name;
    private JLabel event4_name;
    private JPanel eventPagePanel;

    public eventsPage(JFrame frame) {

        event1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://www.google.com");
            }
        });
        event2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://www.google.com");
            }
        });
        event3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://www.google.com");
            }
        });
        event4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://www.google.com");
            }
        });
    }

    private void openWebPage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

    public JPanel getEventsPanel() {
        return eventPagePanel;
    }

    public static void main(String[] args) {
        // Create a JFrame to hold the eventsPage panel
        JFrame frame = new JFrame("Events Page");
        frame.setTitle("Events Page");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of eventsPage and set it as the content pane
        eventsPage panel = new eventsPage(frame);  // Fixed instantiation of the correct class
        frame.setContentPane(panel.getEventsPanel());

        // Display the frame
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}