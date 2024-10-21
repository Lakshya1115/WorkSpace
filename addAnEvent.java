import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addAnEvent {
    private JPanel addAnEventCont;
    private JTextField eventName;
    private JTextField eventDate;
    private JButton submitButton;
    private JButton backButton;
    private JFrame frame; // Reference to the frame

    public addAnEvent(JFrame frame) {
        this.frame = frame;

        // Initialize components
        addAnEventCont = new JPanel(new GridLayout(3, 2, 10, 10));
        eventName = new JTextField();
        eventDate = new JTextField();
        submitButton = new JButton("Submit");
        backButton = new JButton("Back");

        // Add components to panel
        addAnEventCont.add(new JLabel("Event Name:"));
        addAnEventCont.add(eventName);
        addAnEventCont.add(new JLabel("Event Date:"));
        addAnEventCont.add(eventDate);
        addAnEventCont.add(submitButton);
        addAnEventCont.add(backButton);

        // Add action listeners
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = eventName.getText();
                String date = eventDate.getText();
                JOptionPane.showMessageDialog(null, "Event Submitted:\nName: " + name + "\nDate: " + date);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch back to the main menu
                frame.setContentPane(new mainMenu(frame).mainMenuPanel);
                frame.revalidate();
                frame.pack();
            }
        });
    }

    public JPanel getPanel() {
        return addAnEventCont;
    }
}
