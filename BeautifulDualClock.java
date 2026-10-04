/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kokarat
 */
import javax.swing.*;
import java.awt.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BeautifulDualClock extends JFrame {

    public BeautifulDualClock() {
        setTitle("Dual Timezone Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2, 5, 0));
        getContentPane().setBackground(new Color(25, 25, 35)); 

        add(new ClockPanel("Thailand Time", "Asia/Bangkok"));
        add(new ClockPanel("Japan Time", "Asia/Tokyo"));

        setSize(850, 500);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BeautifulDualClock().setVisible(true);
        });
    }
}

class ClockPanel extends JPanel {
    private String title;
    private ZoneId zoneId;
    private int hour, minute, second;
    private String digitalTime;
    private String dateText;

    public ClockPanel(String title, String zoneIdString) {
        this.title = title;
        this.zoneId = ZoneId.of(zoneIdString);
        setBackground(new Color(25, 25, 35)); 

        Timer timer = new Timer(50, e -> {
            updateTime();
            repaint();
        });
        timer.start();
        updateTime();
    }

    private void updateTime() {
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        hour = now.getHour();
        minute = now.getMinute();
        second = now.getSecond();
        
        digitalTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        dateText = now.format(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int cx = getWidth() / 2;
        int cy = getHeight() / 2 - 30;
        int radius = Math.min(getWidth(), getHeight()) / 2 - 80;

        g2d.setColor(new Color(220, 220, 220));
        g2d.setFont(new Font("SansSerif", Font.BOLD, 24));
        FontMetrics fmTitle = g2d.getFontMetrics();
        g2d.drawString(title, cx - fmTitle.stringWidth(title) / 2, 40);

        g2d.setColor(new Color(40, 40, 50));
        g2d.fillOval(cx - radius, cy - radius, radius * 2, radius * 2);
        
        g2d.setColor(new Color(100, 150, 255));
        g2d.setStroke(new BasicStroke(4));
        g2d.drawOval(cx - radius, cy - radius, radius * 2, radius * 2);

        for (int i = 0; i < 60; i++) {
            double angle = Math.toRadians(i * 6 - 90);
            int outR = radius - 5;
            int inR = (i % 5 == 0) ? radius - 20 : radius - 10;
            
            int x1 = (int) (cx + Math.cos(angle) * inR);
            int y1 = (int) (cy + Math.sin(angle) * inR);
            int x2 = (int) (cx + Math.cos(angle) * outR);
            int y2 = (int) (cy + Math.sin(angle) * outR);
            
            if (i % 5 == 0) { 
                g2d.setColor(new Color(200, 200, 200));
                g2d.setStroke(new BasicStroke(3));
            } else { 
                g2d.setColor(new Color(100, 100, 100));
                g2d.setStroke(new BasicStroke(1));
            }
            g2d.drawLine(x1, y1, x2, y2);
        }

        double secAngle = Math.toRadians(second * 6 - 90);
        double minAngle = Math.toRadians(minute * 6 + second * 0.1 - 90);
        double hourAngle = Math.toRadians((hour % 12) * 30 + minute * 0.5 - 90);

        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        drawHand(g2d, cx, cy, hourAngle, radius * 0.5);

        g2d.setColor(new Color(200, 200, 200));
        g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        drawHand(g2d, cx, cy, minAngle, radius * 0.75);

        g2d.setColor(new Color(255, 80, 80));
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        int tailX = (int) (cx - Math.cos(secAngle) * 20);
        int tailY = (int) (cy - Math.sin(secAngle) * 20);
        int headX = (int) (cx + Math.cos(secAngle) * (radius * 0.85));
        int headY = (int) (cy + Math.sin(secAngle) * (radius * 0.85));
        g2d.drawLine(tailX, tailY, headX, headY);

        g2d.setColor(new Color(255, 80, 80));
        g2d.fillOval(cx - 6, cy - 6, 12, 12);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(cx - 2, cy - 2, 4, 4);

        g2d.setColor(new Color(100, 200, 255));
        g2d.setFont(new Font("Monospaced", Font.BOLD, 30));
        FontMetrics fmTime = g2d.getFontMetrics();
        g2d.drawString(digitalTime, cx - fmTime.stringWidth(digitalTime) / 2, cy + radius + 50);

        g2d.setColor(new Color(150, 150, 150));
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 16));
        FontMetrics fmDate = g2d.getFontMetrics();
        g2d.drawString(dateText, cx - fmDate.stringWidth(dateText) / 2, cy + radius + 75);
    }

    private void drawHand(Graphics2D g2d, int cx, int cy, double angle, double length) {
        int x = (int) (cx + Math.cos(angle) * length);
        int y = (int) (cy + Math.sin(angle) * length);
        g2d.drawLine(cx, cy, x, y);
    }
}
