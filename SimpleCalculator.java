/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author student
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private boolean startNewNumber = true;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 2, 2));

        String[] buttons = {
            "√", "x²", "±", "C",
            "7", "8", "9", "+",
            "6", "5", "4", "-",
            "1", "2", "3", "*",
            "0", ".", "=", "/"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            if (text.equals("C")) {
                button.setForeground(Color.RED);
            }
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ((cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') || cmd.equals(".")) {
            if (startNewNumber) {
                display.setText(cmd);
                startNewNumber = false;
            } else {
                display.setText(display.getText() + cmd);
            }
        } else if (cmd.equals("C")) {
            display.setText("0");
            num1 = num2 = result = 0;
            startNewNumber = true;
        } else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                    if(num2 != 0) result = num1 / num2; 
                    else display.setText("Error");
                    break;
            }
            if(!display.getText().equals("Error")) {
                display.setText(String.valueOf(result));
            }
            startNewNumber = true;
        } else if (cmd.equals("√")) {
            double val = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.sqrt(val)));
            startNewNumber = true;
        } else if (cmd.equals("x²")) {
            double val = Double.parseDouble(display.getText());
            display.setText(String.valueOf(val * val));
            startNewNumber = true;
        } else if (cmd.equals("±")) {
            double val = Double.parseDouble(display.getText());
            display.setText(String.valueOf(val * -1));
        } else {
            operator = cmd.charAt(0);
            num1 = Double.parseDouble(display.getText());
            startNewNumber = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator().setVisible(true));
    }
}
