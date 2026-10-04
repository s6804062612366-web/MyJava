import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class HelicopterGame extends JPanel implements ActionListener, KeyListener, MouseListener {
    private Timer gameTimer;
    private Timer countdownTimer;
    
    private int playerX = 360;
    private final int playerY = 500;
    private final int playerWidth = 60;
    private final int playerHeight = 40;
    
    private int heliX = 0;
    private int heliY = 80;
    private int heliSpeed = 4;
    private int heliDirection = 1;
    private final int heliWidth = 100;
    private final int heliHeight = 50;
    private int rotorTick = 0;
    
    private ArrayList<Point> bullets;
    
    private int score = 0;
    private int timeLeft = 60;
    private boolean gameOver = false;
    
    private final Rectangle restartButton = new Rectangle(300, 380, 200, 50);

    public HelicopterGame() {
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        
        bullets = new ArrayList<>();
        
        gameTimer = new Timer(16, this);
        gameTimer.start();
        
        countdownTimer = new Timer(1000, e -> {
            if (timeLeft > 0) {
                timeLeft--;
            } else {
                gameOver = true;
                gameTimer.stop();
                countdownTimer.stop();
            }
            repaint();
        });
        countdownTimer.start();
    }

    private void resetGame() {
        score = 0;
        timeLeft = 60;
        gameOver = false;
        heliX = 0;
        heliY = 80;
        heliDirection = 1;
        playerX = 360;
        bullets.clear();
        
        gameTimer.start();
        countdownTimer.start();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint skyPaint = new GradientPaint(0, 0, new Color(135, 206, 235), 0, 600, new Color(220, 240, 255));
        g2d.setPaint(skyPaint);
        g2d.fillRect(0, 0, 800, 600);
        
        g2d.setColor(new Color(34, 139, 34));
        g2d.fillRect(0, 540, 800, 60);

        if (gameOver) {
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Arial", Font.BOLD, 60));
            FontMetrics metrics = g2d.getFontMetrics();
            g2d.drawString("GAME OVER", (800 - metrics.stringWidth("GAME OVER")) / 2, 300);
            
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SansSerif", Font.BOLD, 30));
            String finalScore = "Final Score: " + score;
            g2d.drawString(finalScore, (800 - g2d.getFontMetrics().stringWidth(finalScore)) / 2, 350);
            
            g2d.setColor(new Color(50, 150, 50));
            g2d.fillRoundRect(restartButton.x, restartButton.y, restartButton.width, restartButton.height, 20, 20);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("SansSerif", Font.BOLD, 24));
            String btnText = "Play Again";
            FontMetrics btnMetrics = g2d.getFontMetrics();
            int textX = restartButton.x + (restartButton.width - btnMetrics.stringWidth(btnText)) / 2;
            int textY = restartButton.y + (restartButton.height - btnMetrics.getHeight()) / 2 + btnMetrics.getAscent();
            g2d.drawString(btnText, textX, textY);
            return;
        }

        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("Score: " + score, 20, 40);
        g2d.drawString("Time: " + timeLeft, 680, 40);

        drawLauncher(g2d);
        drawHelicopter(g2d);

        g2d.setColor(Color.RED);
        for (Point bullet : bullets) {
            g2d.fillOval(bullet.x, bullet.y, 10, 10);
        }
    }

    private void drawLauncher(Graphics2D g2d) {
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRoundRect(playerX, playerY + 20, playerWidth, 20, 10, 10);
        
        g2d.setColor(Color.GRAY);
        g2d.fillArc(playerX + 10, playerY + 5, 40, 40, 0, 180);
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(6));
        g2d.drawLine(playerX + 30, playerY + 10, playerX + 30, playerY - 15);
    }

    private void drawHelicopter(Graphics2D g2d) {
        AffineTransform oldTransform = g2d.getTransform();
        
        g2d.translate(heliX + heliWidth / 2.0, heliY + heliHeight / 2.0);
        if (heliDirection == -1) {
            g2d.scale(-1, 1);
        }
        
        int drawX = -heliWidth / 2;
        int drawY = -heliHeight / 2;

        g2d.setColor(new Color(60, 60, 60));
        g2d.fillRect(drawX, drawY + 18, 45, 8);
        
        g2d.setColor(Color.BLACK);
        if (rotorTick % 4 < 2) {
            g2d.fillOval(drawX - 5, drawY + 8, 10, 28);
        } else {
            g2d.fillOval(drawX - 2, drawY + 8, 4, 28);
        }

        g2d.setColor(new Color(220, 50, 50)); 
        g2d.fillRoundRect(drawX + 30, drawY + 5, 65, 35, 25, 25);
        
        g2d.setColor(new Color(150, 220, 255));
        g2d.fillArc(drawX + 65, drawY + 8, 30, 20, 0, 90);
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(drawX + 45, drawY + 40, drawX + 45, drawY + 50);
        g2d.drawLine(drawX + 75, drawY + 40, drawX + 75, drawY + 50);
        g2d.drawLine(drawX + 35, drawY + 50, drawX + 90, drawY + 50);

        g2d.fillRect(drawX + 55, drawY - 5, 6, 10);
        
        if (rotorTick % 4 < 2) {
            g2d.fillOval(drawX + 15, drawY - 8, 85, 4);
        } else {
            g2d.fillOval(drawX + 35, drawY - 8, 45, 4);
        }

        g2d.setTransform(oldTransform); 
        rotorTick++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        heliX += heliSpeed * heliDirection;
        if (heliX >= 800 - heliWidth) {
            heliX = 800 - heliWidth;
            heliDirection = -1; 
        } else if (heliX <= 0) {
            heliX = 0;
            heliDirection = 1; 
        }

        ArrayList<Point> bulletsToRemove = new ArrayList<>();
        Rectangle heliRect = new Rectangle(heliX, heliY, heliWidth, heliHeight);

        for (Point bullet : bullets) {
            bullet.y -= 12; 
            
            if (bullet.y < 0) {
                bulletsToRemove.add(bullet);
            }
            else if (heliRect.contains(bullet)) {
                score += 10; 
                bulletsToRemove.add(bullet); 
            }
        }
        bullets.removeAll(bulletsToRemove);
        
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) return;
        
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && playerX > 0) {
            playerX -= 15;
        } else if (key == KeyEvent.VK_RIGHT && playerX < 800 - playerWidth) {
            playerX += 15;
        } else if (key == KeyEvent.VK_SPACE) {
            bullets.add(new Point(playerX + 25, playerY - 15));
        }
    }
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (gameOver) {
            if (restartButton.contains(e.getPoint())) {
                resetGame();
            }
            return;
        }
        
        Rectangle playerRect = new Rectangle(playerX, playerY, playerWidth, playerHeight + 20);
        if (playerRect.contains(e.getPoint())) {
            bullets.add(new Point(playerX + 25, playerY - 15)); 
        }
    }
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Helicopter Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new HelicopterGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}