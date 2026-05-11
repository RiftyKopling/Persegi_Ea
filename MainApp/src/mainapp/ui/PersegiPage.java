/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainapp.ui;
import javax.swing.*;
import java.awt.*;
import mainapp.projek_pbo.*;
/**
 *
 * @author morxidia
 */
public class PersegiPage extends JPanel {
    private Persegi geometryObject= new Persegi();
    
    // input text object
    private JTextField inputSide = new JTextField(10);
    private JButton btnCalculate = new JButton("Calculate");
    
    // output text object
    private JTextField outputArea = new JTextField(20);
    private JTextField outputPerimeter = new JTextField(20);
    
    // Error Textarea;
    private JTextArea errorTextArea = new JTextArea(5, 20);

    public PersegiPage() {
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(410, 300));
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(new JLabel("Side:"));
        inputPanel.add(inputSide);
        
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
        outputPerimeter.setEditable(false); 
        outputPerimeter.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputPerimeter.setBackground(Color.WHITE);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setBackground(Color.WHITE);
        
        // adding result section as flow layout rather than box layout
        JPanel resultRow = new JPanel();
        resultRow.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultRow.add(new JLabel("Area: "));
        resultRow.add(outputArea);
        resultRow.add(Box.createRigidArea(new Dimension(10, 0)));
        resultRow.add(new JLabel("Perimeter: "));
        resultRow.add(outputPerimeter);

        resultPanel.add(resultRow);
        
        
        // Error Text panel
        errorTextArea.setEditable(false);
        errorTextArea.setForeground(Color.RED); 
        errorTextArea.setBackground(getBackground());
        add(errorTextArea, BorderLayout.SOUTH);
        
        btnCalculate.addActionListener(e -> {
            // calculate button eventlistener
            errorTextArea.setText(""); 
            outputArea.setText("");
            outputPerimeter.setText("");
            try{
                this.handleInput(inputSide.getText());
                outputArea.setText(String.valueOf(geometryObject.hitungLuas()) + " cm");
                outputPerimeter.setText(String.valueOf(geometryObject.hitungKeliling()) + " cm");
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
    
    private void handleInput(String input){
        double val = Double.parseDouble(input);
        geometryObject.setSisi(val);
    }
}
