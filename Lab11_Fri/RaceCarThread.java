/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab11_Fri;

/**
 *
 * @author kokarat
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RaceCarThread extends JPanel implements Runnable {
    private int xBase = 0;

    public RaceCarThread() {
        setPreferredSize(new Dimension(400, 100));
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            xBase += 2;
            if (xBase > getWidth()) {
                xBase = -50;
            }
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yBase = getHeight() - 10;

        g.setColor(Color.BLACK);
        g.fillOval(xBase + 10, yBase - 10, 10, 10);
        g.fillOval(xBase + 30, yBase - 10, 10, 10);

        g.setColor(Color.GREEN);
        g.fillRect(xBase, yBase - 20, 50, 10);

        g.setColor(Color.RED);
        int[] xPolygon = {xBase + 10, xBase + 20, xBase + 30, xBase + 40};
        int[] yPolygon = {yBase - 20, yBase - 30, yBase - 30, yBase - 20};
        g.fillPolygon(xPolygon, yPolygon, 4);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Race Car Thread");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RaceCarThread());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}