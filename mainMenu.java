import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class mainMenu {
    public JPanel mainMenuPanel;
    private JButton eventsPage;
    private JButton bunkoMeterButton;
    private JButton addAnEventButton;
    private JButton bridgeUButton;
    private JButton collectDeliveryButton;

    private JFrame frame; // Reference to the frame

    public mainMenu(JFrame frame) {
        this.frame = frame;

        // Initialize buttons with ActionListeners
        eventsPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to eventsPage
                switchToPage(new eventsPage(frame).getEventsPane()); // You need to create EventsPage class
            }
        });
        bunkoMeterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                 Switch to bunkoMeterPage
                switchToPage(new BunkoMeterPage(frame).getBunkoMeterPanel()); // You need to create BunkoMeterPage class
            }
        });
        addAnEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new addAnEvent(frame).getAddAnEventPanel());  // Switch to Add Event page
                frame.revalidate();
                frame.pack();
            }
        });

        bridgeUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirect to the AlmaConnect website
                try {
                    Desktop.getDesktop().browse(new URI("https://www.almaconnect.com/")); // Open the website
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace(); // Handle exceptions appropriately
                }
            }
        });
        collectDeliveryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to orderDeliveryPage
                switchToPage(new orderDelivery(frame).getOrderDeliveryPane()); // Pass the frame reference
            }
        });
    }

    private void switchToPage(JPanel newPage) {
        frame.setContentPane(newPage); // Set the new page as content pane
        frame.revalidate(); // Refresh the frame
        frame.pack(); // Adjust the frame size to fit the new content
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Menu");
        frame.setTitle("WorkSpace");
        frame.setSize(450, 800);
        frame.setBounds(600, 200, 450, 800);
        frame.setContentPane(new mainMenu(frame).mainMenuPanel); // Pass the frame reference
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
