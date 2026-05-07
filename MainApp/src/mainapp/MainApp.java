package mainapp;

import mainapp.projek_pbo.LimasPersegi;
import mainapp.projek_pbo.BujurSangkar;
import mainapp.threading.ThreadExecutor;
import mainapp.threading.ThreadExecutorSingle;
import mainapp.projek_pbo.BendaGeometri;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import ui.HomePanel; // Import your HomePanel class

public class MainApp {
    public static void main(String[] args) {
        // Always run Swing code on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        // 1. Create the window
        JFrame frame = new JFrame("Geometry Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Add your HomePanel to the frame
        // HomePanel is a JPanel, so it fits right in
        HomePanel mainContent = new HomePanel();
        frame.add(mainContent);

        // 3. Size and display
        frame.pack(); 
        frame.setLocationRelativeTo(null); // Centers the window on screen
        frame.setVisible(true);
    }
}

// ini branch bukan main 
