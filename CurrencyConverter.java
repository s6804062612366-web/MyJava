import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author student
 */
public class CurrencyConverter extends JFrame {
    
    //variable
    private JTextField txtUsDollar;
    private JTextField txtCanadianDollar;
    private JButton btnConvert;
    
    public CurrencyConverter() {
        setTitle("Convert US Dollars to Canadian Dollars");
        setLayout(new BorderLayout(10, 10));
        
        JPanel panelWest = new JPanel(new GridLayout(2, 1, 5, 5));
        panelWest.add(new JLabel("US Dollars"));
        panelWest.add(new JLabel("Canadian Dollars"));
        
        JPanel panelCenter = new JPanel(new GridLayout(2,1,5,5));
        txtUsDollar = new JTextField();
        txtCanadianDollar = new JTextField();
        txtCanadianDollar.setEditable(false);
        
        panelCenter.add(txtUsDollar);
        panelCenter.add(txtCanadianDollar);
        
        JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnConvert = new JButton("Convert");
        panelSouth.add(btnConvert);
        
        add(panelWest, BorderLayout.WEST);
        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
        
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculationConversion();
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);
    }
    
    private void calculationConversion() {
        try {
            double usAmount = Double.parseDouble(txtUsDollar.getText());
            double canAmount = usAmount * 1.5;
            txtCanadianDollar.setText(String.valueOf(canAmount));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this ,"Plese Enter Correctly","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new CurrencyConverter().setVisible(true);
            }   
        });
    }
}
