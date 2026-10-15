/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

/**
 *
 * @author kokarat
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JTextField usField;
    private JTextField canField;
    private JButton convertBtn;

    public CurrencyConverter() {
        setTitle("Convert US Dollars to Canadian Dollars");
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        centerPanel.add(new JLabel("US Dollars"));
        usField = new JTextField();
        centerPanel.add(usField);
        centerPanel.add(new JLabel("Canadian Dollars"));
        canField = new JTextField();
        canField.setEditable(false);
        centerPanel.add(canField);
        
        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        convertBtn = new JButton("Convert");
        southPanel.add(convertBtn);
        add(southPanel, BorderLayout.SOUTH);

        convertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double us = Double.parseDouble(usField.getText());
                double can = us * 1.5; 
                canField.setText(String.format("%.2f", can));
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new CurrencyConverter().setVisible(true);
    }
}