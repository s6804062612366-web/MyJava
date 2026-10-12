/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab11_Fri;

/**
 *
 * @author kokarat
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClockAnimationThread extends JPanel implements Runnable {
    
    public ClockAnimationThread() {
        setPreferredSize(new Dimension(300, 300));
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int radius = (int) (Math.min(getWidth(), getHeight()) * 0.4);

        g.drawOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
        g.drawString("12", xCenter - 5, yCenter - radius + 15);
        g.drawString("9", xCenter - radius + 5, yCenter + 5);
        g.drawString("3", xCenter + radius - 15, yCenter + 5);
        g.drawString("6", xCenter - 5, yCenter + radius - 5);

        Calendar calendar = new GregorianCalendar();
        int second = calendar.get(Calendar.SECOND);
        int minute = calendar.get(Calendar.MINUTE);
        int hour = calendar.get(Calendar.HOUR);

        int sLength = (int) (radius * 0.8);
        int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        int mLength = (int) (radius * 0.65);
        int xMinute = (int) (xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        int hLength = (int) (radius * 0.5);
        int xHour = (int) (xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ClockAnimationThread());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}