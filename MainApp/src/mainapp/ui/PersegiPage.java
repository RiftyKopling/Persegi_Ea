package mainapp.ui;
import javax.swing.*;
import java.awt.*;
import mainapp.Handling.InvalidDimensionException;
import mainapp.projek_pbo.*;

public class PersegiPage extends JPanel {
    private Persegi geometryObject;
    
    private JTextField inputSide = new JTextField(10);
    private JButton btnCalculate = new JButton("Calculate");
    
    private JTextField outputArea = new JTextField(20);
    private JTextField outputPerimeter = new JTextField(20);
    
    private JTextArea errorTextArea = new JTextArea(5, 20);

    public PersegiPage() {
        geometryObject = new Persegi();
        
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(410, 300));
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(new JLabel("Side:"));
        inputPanel.add(inputSide);
        
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
        resultRow.add(new JLabel("Area: "));
        resultRow.add(outputArea);
        resultRow.add(Box.createRigidArea(new Dimension(10, 0)));
        resultRow.add(new JLabel("Perimeter: "));
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
                this.handleInput(inputSide.getText());
                outputArea.setText(String.valueOf(geometryObject.hitungLuas()) + " cm");
                outputPerimeter.setText(String.valueOf(geometryObject.hitungKeliling()) + " cm");
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Input harus angka valid");
            }
            catch (InvalidDimensionException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
    
    private void handleInput(String input) throws InvalidDimensionException {
        double val = Double.parseDouble(input);
        geometryObject.setSisi(val);
    }
}
