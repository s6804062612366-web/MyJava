/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab10;

/**
 *
 * @author kokarat
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RacingCars extends JFrame {
    private RaceCar[] cars = new RaceCar[4];
    private JTextField[] speedFields = new JTextField[4];

    public RacingCars() {
        JPanel panelCars = new JPanel(new GridLayout(4, 1));
        JPanel panelControls = new JPanel(new FlowLayout());

        for (int i = 0; i < 4; i++) {
            cars[i] = new RaceCar();
            panelCars.add(cars[i]);

            panelControls.add(new JLabel("Car " + (i + 1) + ":"));
            int defaultSpeed = (i + 1) * 2;
            speedFields[i] = new JTextField(String.valueOf(defaultSpeed), 3);
            cars[i].setSpeed(defaultSpeed);
            
            final int index = i;
            speedFields[i].addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    try {
                        int speed = Integer.parseInt(speedFields[index].getText());
                        cars[index].setSpeed(speed);
                    } catch (NumberFormatException ex) {
                        cars[index].setSpeed(0);
                    }
                }
            });
            panelControls.add(speedFields[i]);
        }

        setLayout(new BorderLayout());
        add(panelControls, BorderLayout.NORTH);
        add(panelCars, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new RacingCars();
        frame.setTitle("Exercise18_17");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class RaceCar extends JPanel {
    private int xBase = 0;
    private int speed = 0;
    private Timer timer = new Timer(50, new Listener());

    public RaceCar() {
        timer.start();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yBase = getHeight();
        
        if (xBase > getWidth()) {
            xBase = -20;
        } else {
            xBase += speed;
        }

        g.setColor(Color.BLACK);
        g.fillOval(xBase + 10, yBase - 10, 10, 10);
        g.fillOval(xBase + 30, yBase - 10, 10, 10);
        
        g.setColor(Color.GREEN);
        g.fillRect(xBase, yBase - 20, 50, 10);
        
        g.setColor(Color.RED);
        Polygon polygon = new Polygon();
        polygon.addPoint(xBase + 10, yBase - 20);
        polygon.addPoint(xBase + 20, yBase - 30);
        polygon.addPoint(xBase + 30, yBase - 30);
        polygon.addPoint(xBase + 40, yBase - 20);
        g.fillPolygon(polygon);
    }
}