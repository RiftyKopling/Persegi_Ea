package mainapp.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mainapp.Handling.InvalidDimensionException;
import mainapp.projek_pbo.LimasPersegi;

public class LimasPage extends JPanel{
    private LimasPersegi geometryObject;
    
    private JTextField inputSide = new JTextField(10);
    private JTextField inputHeight = new JTextField(10);
    private JButton btnCalculate = new JButton("Calculate");
    
    private JTextField outputArea = new JTextField(20);
    private JTextField outputPerimeter = new JTextField(20);
    
    private JTextArea errorTextArea = new JTextArea(5, 20);

    public LimasPage() {
        geometryObject = new LimasPersegi();
        
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(410, 300));
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(new JLabel("Base edge:"));
        inputPanel.add(inputSide);
        inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        inputPanel.add(new JLabel("Height:"));
        inputPanel.add(inputHeight);
        
        inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        inputPanel.add(btnCalculate);
        add(inputPanel, BorderLayout.NORTH);
        
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
        JLabel header = new JLabel("Result");
        header.setFont(new Font("SansSerif", Font.BOLD, 18));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultPanel.add(header);
        add(resultPanel, BorderLayout.CENTER);
        
        outputPerimeter.setEditable(false); 
        outputPerimeter.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputPerimeter.setBackground(Color.WHITE);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setBackground(Color.WHITE);
        
        JPanel resultRow = new JPanel();
        resultRow.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultRow.add(new JLabel("Volume: "));
        resultRow.add(outputArea);
        resultRow.add(Box.createRigidArea(new Dimension(10, 0)));
        resultRow.add(new JLabel("Surface Area: "));
        resultRow.add(outputPerimeter);

        resultPanel.add(resultRow);
        
        errorTextArea.setEditable(false);
        errorTextArea.setForeground(Color.RED); 
        errorTextArea.setBackground(getBackground());
        add(errorTextArea, BorderLayout.SOUTH);
        
        btnCalculate.addActionListener(e -> {
            errorTextArea.setText(""); 
            outputArea.setText("");
            outputPerimeter.setText("");
            try{
                this.handleInput(this.inputSide.getText(), this.inputHeight.getText());
                outputArea.setText(this.formatValue(geometryObject.hitungVolume()));
                outputPerimeter.setText(this.formatValue(geometryObject.hitungLuasPermukaan()));
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Input harus angka valid");
            }
            catch (InvalidDimensionException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
    
    private String formatValue(Double input){
        return String.format("%.2f", input);
    }
    
    private void handleInput(String side, String height) throws InvalidDimensionException {
        double sideVal = Double.parseDouble(side);
        double heightVal = Double.parseDouble(height);
        geometryObject.setSisi(sideVal);
        geometryObject.setTinggi(heightVal);
    }
}
