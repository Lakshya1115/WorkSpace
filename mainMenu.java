import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                // Switch to addAnEventPage
                //switchToPage(new AddAnEventPage(frame)); // You need to create AddAnEventPage class
            }
        });
        bridgeUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to bridgeUPage
                //switchToPage(new BridgeUPage(frame)); // You need to create BridgeUPage class
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
