/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mainapp.projek_pbo.BujurSangkar;

/**
 *
 * @author morxidia
 */
public class BujurSangkarPage extends JPanel {
    private BujurSangkar geometryObject= new BujurSangkar();
    
    // input text object
    private JTextField inputSide = new JTextField(10);
    private JTextField inputHeight = new JTextField(10);
    private JButton btnCalculate = new JButton("Calculate");
    
    // output text object
    private JTextField outputVolume = new JTextField(20);
    private JTextField outputSurfaceArea = new JTextField(20);
    
    // Error Textarea;
    private JTextArea errorTextArea = new JTextArea(5, 20);

    public BujurSangkarPage() {
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(410, 300));
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(new JLabel("Base edge:"));
        inputPanel.add(inputSide);
        inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        inputPanel.add(new JLabel("Height:"));
        inputPanel.add(inputHeight);
        
        // to set the spacer and "calculate" button 
        inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        inputPanel.add(btnCalculate);
        add(inputPanel, BorderLayout.NORTH);
        
        // Result Section
        // header use box layout
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
        JLabel header = new JLabel("Result");
        header.setFont(new Font("SansSerif", Font.BOLD, 18));
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultPanel.add(header);
        add(resultPanel, BorderLayout.CENTER);
        
        // ouput view&behaviour setting
        outputSurfaceArea.setEditable(false); 
        outputSurfaceArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputSurfaceArea.setBackground(Color.WHITE);
        outputVolume.setEditable(false);
        outputVolume.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputVolume.setBackground(Color.WHITE);
        
        // adding result section as flow layout rather than box layout
        JPanel resultRow = new JPanel();
        resultRow.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultRow.add(new JLabel("Volume: "));
        resultRow.add(outputVolume);
        resultRow.add(Box.createRigidArea(new Dimension(10, 0)));
        resultRow.add(new JLabel("Surface Area: "));
        resultRow.add(outputSurfaceArea);

        resultPanel.add(resultRow);
        
        
        // Error Text panel
        errorTextArea.setEditable(false);
        errorTextArea.setForeground(Color.RED); 
        errorTextArea.setBackground(getBackground());
        add(errorTextArea, BorderLayout.SOUTH);
        
        btnCalculate.addActionListener(e -> {
            // calculate button eventlistener
            errorTextArea.setText(""); 
            outputVolume.setText("");
            outputSurfaceArea.setText("");
            try{
                this.handleInput(this.inputSide.getText(), this.inputHeight.getText());
                outputVolume.setText(this.formatValue(geometryObject.hitungVolume()));
                outputSurfaceArea.setText(this.formatValue(geometryObject.hitungLuasPermukaan()));
            }
            // Handle error for parse error String to Double
            catch(NumberFormatException ex){
                errorTextArea.setText("Error: Invalid Number input please enter valid number");
            }
            // other error handle by parent Exception object
            catch(Exception ex){
                errorTextArea.setText("Error: " + ex.getMessage());
            }
        });
    }
    
    private String formatValue(Double input){
        return String.format("%.2f", input);
    }
    
    private void handleInput(String side, String height){
        double sideVal = Double.parseDouble(side);
        double heightVal = Double.parseDouble(height);
        geometryObject.setSisi(sideVal);
        geometryObject.setTinggi(heightVal);
    }
}
