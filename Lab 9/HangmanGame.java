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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HangmanGame extends JFrame {
    public HangmanGame() {
        setTitle("Hangman");
        HangmanPanel panel = new HangmanPanel();
        add(panel);
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    panel.swingLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    panel.swingRight();
                }
            }
        });
        
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setFocusable(true);
    }

    public static void main(String[] args) {
        new HangmanGame().setVisible(true);
    }
}

class HangmanPanel extends JPanel {
    private double angle = 0; 
    
    public void swingLeft() {
        angle -= Math.toRadians(5); 
        repaint();
    }

    public void swingRight() {
        angle += Math.toRadians(5); 
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int base = 20;
        
        g.drawArc(base, 220, 80, 40, 0, 180);
        g.drawLine(base + 40, 220, base + 40, 20);
        g.drawLine(base + 40, 20, base + 40 + 100, 20);
        g.drawLine(base + 40 + 100, 20, base + 40 + 100, 40);
        
        Graphics2D g2d = (Graphics2D) g.create();
        
        int pivotX = base + 40 + 100;
        int pivotY = 40;
        
        g2d.translate(pivotX, pivotY);
        g2d.rotate(angle);
        g2d.translate(-pivotX, -pivotY);
        
        int radius = 20;
        g2d.drawOval(pivotX - radius, 40, 2 * radius, 2 * radius);
        
        int headCenterY = 40 + radius;
        
        g2d.drawLine(pivotX - (int)(radius * Math.cos(Math.toRadians(45))), 
                   headCenterY + (int)(radius * Math.sin(Math.toRadians(45))), 
                   pivotX - 60, headCenterY + 60);
                   
        g2d.drawLine(pivotX + (int)(radius * Math.cos(Math.toRadians(45))), 
                   headCenterY + (int)(radius * Math.sin(Math.toRadians(45))), 
                   pivotX + 60, headCenterY + 60);
                   
        g2d.drawLine(pivotX, 40 + 2 * radius, pivotX, headCenterY + 80);
        
        g2d.drawLine(pivotX, headCenterY + 80, pivotX - 40, headCenterY + 80 + 40);
        g2d.drawLine(pivotX, headCenterY + 80, pivotX + 40, headCenterY + 80 + 40);
        
        g2d.dispose();
    }
}