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
import java.awt.event.*;
import java.util.Random;

public class BalloonGame extends JFrame {
    public BalloonGame() {
        add(new GamePanel());
    }

    public static void main(String[] args) {
        JFrame frame = new BalloonGame();
        frame.setTitle("Balloon Game");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class GamePanel extends JPanel {
    private int gunX = 180;
    private int balloonX;
    private int balloonY;
    private int bulletX;
    private int bulletY;
    private boolean isShooting = false;
    private Timer timer;
    private Random random = new Random();

    public GamePanel() {
        setFocusable(true);
        spawnBalloon();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gunX -= 10;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gunX += 10;
                } else if (e.getKeyCode() == KeyEvent.VK_UP && !isShooting) {
                    isShooting = true;
                    bulletX = gunX + 8;
                    bulletY = getHeight() - 40;
                }
                repaint();
            }
        });

        timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isShooting) {
                    bulletY -= 10;
                    
                    Rectangle bulletRect = new Rectangle(bulletX, bulletY, 4, 10);
                    Rectangle balloonRect = new Rectangle(balloonX, balloonY, 30, 40);
                    
                    if (bulletRect.intersects(balloonRect)) {
                        isShooting = false;
                        spawnBalloon();
                    } else if (bulletY < 0) {
                        isShooting = false;
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    private void spawnBalloon() {
        balloonX = random.nextInt(350);
        balloonY = random.nextInt(150) + 20;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.RED);
        g.fillOval(balloonX, balloonY, 30, 40);
        g.drawLine(balloonX + 15, balloonY + 40, balloonX + 15, balloonY + 60);

        g.setColor(Color.BLUE);
        g.fillRect(gunX, getHeight() - 20, 20, 20);
        g.fillRect(gunX + 6, getHeight() - 40, 8, 20);

        if (isShooting) {
            g.setColor(Color.BLACK);
            g.fillRect(bulletX, bulletY, 4, 10);
        }
    }
}
