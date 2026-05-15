package mainapp;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import mainapp.ui.HomePanel;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Geometry Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HomePanel mainContent = new HomePanel();
        frame.add(mainContent);

        frame.pack(); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}
