import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addAnEvent {
    private JPanel addAnEventCont;
    private JTextField eventName;
    private JTextField eventDate;
    private JButton submitButton;
    private JButton backButton;

    private JFrame frame;  // Reference to the main JFrame

    // JDBC Configuration
    private static final String DB_URL = "jdbc:sqlserver://Lakshya\\SQLEXPRESS:1433;databaseName=EventsDB;encrypt=true;trustServerCertificate=true";
    private static final String USER = "your_sql_username";  // Replace with your SQL Server username
    private static final String PASSWORD = "your_sql_password";  // Replace with your SQL Server password

    public addAnEvent(JFrame frame) {
        this.frame = frame;

        // ActionListener for the Submit button to store data in the database
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = eventName.getText();
                String date = eventDate.getText();

                if (!name.isEmpty() && !date.isEmpty()) {
                    saveEventToDatabase(name, date);  // Save event to DB
                    JOptionPane.showMessageDialog(frame, "Event saved successfully!");
                    eventName.setText("");  // Clear the input fields
                    eventDate.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                }
            }
        });

        // ActionListener for the Back button to return to the main menu
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToMainMenu();  // Switch back to Main Menu
            }
        });
    }

    // Method to save event details to the database
    private void saveEventToDatabase(String name, String date) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Events (event_name, event_date) VALUES (?, ?)")) {

            stmt.setString(1, name);  // Set event name
            stmt.setString(2, date);  // Set event date
            stmt.executeUpdate();  // Execute the query
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error saving event: " + ex.getMessage());
        }
    }

    // Method to switch back to the main menu
    private void switchToMainMenu() {
        frame.setContentPane(new mainMenu(frame).mainMenuPanel);  // Switch to Main Menu panel
        frame.revalidate();
        frame.pack();
    }

    // Getter for the main panel of this page
    public JPanel getAddAnEventPanel() {
        return addAnEventCont;
    }
}
