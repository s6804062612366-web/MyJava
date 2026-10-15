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

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private String operator = "";
    private double firstOperand = 0;
    private boolean startNewInput = true;

    public Calculator() {
        setTitle("Simple Calculator");
        setLayout(new BorderLayout(5, 5));

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 2, 2));
        
        String[] buttons = {
            "√", "x²", "±", "C",
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", ".", "=", "/"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            if (text.equals("C")) {
                btn.setForeground(Color.RED);
            }
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 300);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ((cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') || cmd.equals(".")) {
            if (startNewInput) {
                if(cmd.equals(".")) {
                   display.setText("0.");
                } else {
                   display.setText(cmd);
                }
                startNewInput = false;
            } else {
                if (cmd.equals(".") && display.getText().contains(".")) {
                    return;
                }
                display.setText(display.getText() + cmd);
            }
        } else if (cmd.equals("C")) {
            display.setText("0");
            operator = "";
            firstOperand = 0;
            startNewInput = true;
        } else if (cmd.equals("±")) {
            double value = Double.parseDouble(display.getText());
            value = value * -1;
            display.setText(String.valueOf(value));
            startNewInput = true;
        } else if (cmd.equals("√")) {
            double value = Double.parseDouble(display.getText());
            if(value >= 0) {
               display.setText(String.valueOf(Math.sqrt(value)));
            } else {
               display.setText("Error");
            }
            startNewInput = true;
        } else if (cmd.equals("x²")) {
            double value = Double.parseDouble(display.getText());
            display.setText(String.valueOf(value * value));
            startNewInput = true;
        } else if (cmd.equals("=")) {
            double secondOperand = Double.parseDouble(display.getText());
            double result = 0;
            switch (operator) {
                case "+": result = firstOperand + secondOperand; break;
                case "-": result = firstOperand - secondOperand; break;
                case "*": result = firstOperand * secondOperand; break;
                case "/": 
                    if(secondOperand != 0) {
                        result = firstOperand / secondOperand; 
                    } else {
                        display.setText("Error");
                        startNewInput = true;
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            startNewInput = true;
        } else {
            firstOperand = Double.parseDouble(display.getText());
            operator = cmd;
            startNewInput = true;
        }
    }

    public static void main(String[] args) {
        new Calculator().setVisible(true);
    }
}