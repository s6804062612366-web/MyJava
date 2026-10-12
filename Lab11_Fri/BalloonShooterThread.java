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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BalloonShooterThread extends JPanel implements Runnable {
    private int gunX = 200;
    private int bulletX = -1;
    private int bulletY = -1;
    private boolean isShooting = false;
    
    private int balloonX;
    private int balloonY;
    private Random random = new Random();

    public BalloonShooterThread() {
        setPreferredSize(new Dimension(400, 400));
        setFocusable(true);
        spawnBalloon();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gunX -= 10;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gunX += 10;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (!isShooting) {
                        bulletX = gunX;
                        bulletY = getHeight() - 40;
                        isShooting = true;
                    }
                }
            }
        });

        Thread thread = new Thread(this);
        thread.start();
    }

    private void spawnBalloon() {
        balloonX = random.nextInt(350);
        balloonY = random.nextInt(200) + 20;
    }

    @Override
    public void run() {
        while (true) {
            if (isShooting) {
                bulletY -= 10;
                
                if (bulletY < 0) {
                    isShooting = false;
                }
                
                if (bulletX >= balloonX && bulletX <= balloonX + 30 &&
                    bulletY >= balloonY && bulletY <= balloonY + 30) {
                    isShooting = false;
                    spawnBalloon();
                }
            }
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLUE);
        g.fillOval(balloonX, balloonY, 30, 30);
        g.drawLine(balloonX + 15, balloonY + 30, balloonX + 15, balloonY + 45);

        g.setColor(Color.BLACK);
        g.fillRect(gunX - 5, getHeight() - 30, 10, 30);
        g.fillRect(gunX - 20, getHeight() - 10, 40, 10);

        if (isShooting) {
            g.setColor(Color.RED);
            g.fillOval(bulletX - 3, bulletY, 6, 6);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Balloon Shooter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BalloonShooterThread());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}