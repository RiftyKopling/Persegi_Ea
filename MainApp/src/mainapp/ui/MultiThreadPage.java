package mainapp.ui;
/**
 * @author morxidia
 * this page show the main default branch output as text in java swing UI
 */

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import mainapp.Handling.InvalidDimensionException;
import mainapp.threading.*;
import mainapp.projek_pbo.*;

public class MultiThreadPage extends JPanel {
    private JTextArea textArea = new JTextArea(5, 20);
    private JButton button = new JButton("Show MultiThread Excetution");
    
    public MultiThreadPage() {
        setLayout(null);
        setPreferredSize(new Dimension(910, 500));
        
        button.setBounds(20, 20, 250, 45);
        add(button);
        
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 80, 860, 380);
        add(scrollPane);
        
        button.addActionListener(e -> {
            this.handleMultiThread();
        });
    }
    
    private void updateText(String text) {
        SwingUtilities.invokeLater(() -> textArea.append(text));
    }
    
    public void handleMultiThread(){
        textArea.setText("");
        List<BendaGeometri> shapes = new ArrayList<>(); // Polymorphism
        Random rand = new Random();

        // generate random object
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                try {
                    shapes.add(new BujurSangkar(
                        rand.nextInt(10) + 1,
                        rand.nextInt(10) + 1
                    ));
                } catch (InvalidDimensionException ex) {
                    // fallback aman (harusnya tidak kejadian karena random >=1)
                    shapes.add(new BujurSangkar());
                }
            } else {
                try {
                    shapes.add(new LimasPersegi(
                        rand.nextInt(10) + 1,
                        rand.nextInt(5) + 1
                    ));
                } catch (InvalidDimensionException ex) {
                    shapes.add(new LimasPersegi());
                }
            }
        }

        new Thread(() -> {
            SwingUtilities.invokeLater(() -> textArea.append("=== SINGLE THREAD ===\n"));
            List<String> singleOutput = ThreadExecutorSingle.processShapes(shapes);
            
            singleOutput.forEach(this::updateText);
            
            SwingUtilities.invokeLater(() -> textArea.append("\n=== MULTI THREAD ===\n"));
            List<String> multiOutput = ThreadExecutor.processShapes(shapes);
            
            multiOutput.forEach(this::updateText);
        }).start();
    }
}
