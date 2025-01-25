import javax.swing.*; 

public class Grapic { 

    public static void main(String[] args) {
        // Create a JFrame (the window)
        JFrame frame = new JFrame("My Graphic Application"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // Create a JPanel (the content pane)
        JPanel panel = new JPanel(); 

        // Add components to the panel (e.g., buttons, labels, etc.)
        // Example: Add a button
        JButton button = new JButton("Click Me");
        panel.add(button);

        // Set the panel as the content pane of the frame
        frame.setContentPane(panel);

        // Set the size of the frame
        frame.setSize(400, 400); 

        // Make the frame visible
        frame.setVisible(true); 
    }
}