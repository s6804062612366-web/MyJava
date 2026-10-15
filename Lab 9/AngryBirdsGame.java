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
import java.util.Random;

public class AngryBirdsGame extends JFrame {
    private JTextField yField, speedField, angleField, scoreField;
    private int score = 0;
    private GamePanel gamePanel;

    public AngryBirdsGame() {
        setTitle("SCENE 1: At Tokyo");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(new JLabel("SCENE 1: At Tokyo"));
        topPanel.add(Box.createHorizontalStrut(100)); 
        topPanel.add(new JLabel("SCORE"));
        scoreField = new JTextField("0", 5);
        scoreField.setEditable(false);
        topPanel.add(scoreField);
        add(topPanel, BorderLayout.NORTH);

        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 5, 2, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        bottomPanel.add(new JLabel("Bird Position in y-axis"), gbc);
        gbc.gridx = 1;
        yField = new JTextField(15);
        bottomPanel.add(yField, gbc);
        gbc.gridx = 2;
        bottomPanel.add(new JLabel("m"), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        bottomPanel.add(new JLabel("Shooting speed"), gbc);
        gbc.gridx = 1;
        speedField = new JTextField(15);
        bottomPanel.add(speedField, gbc);
        gbc.gridx = 2;
        bottomPanel.add(new JLabel("m/s"), gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        bottomPanel.add(new JLabel("Angle"), gbc);
        gbc.gridx = 1;
        angleField = new JTextField(15);
        bottomPanel.add(angleField, gbc);
        gbc.gridx = 2;
        bottomPanel.add(new JLabel("degree"), gbc);

        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.CENTER;
        JButton okBtn = new JButton("OK");
        bottomPanel.add(okBtn, gbc);

        add(bottomPanel, BorderLayout.SOUTH);

        gamePanel.resetPigPosition();

        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double syStr = Double.parseDouble(yField.getText());
                    double u = Double.parseDouble(speedField.getText());
                    double angle = Double.parseDouble(angleField.getText());

                    double sy = -syStr; 
                    
                    double rad = Math.toRadians(angle);
                    double uy = u * Math.sin(rad);
                    double ux = u * Math.cos(rad);
                    double g = -10;

                    double a = 0.5 * g;
                    double b = uy;
                    double c = -sy;
                    
                    double t = -1;
                    
                    double discriminant = b*b - 4*a*c;
                    if(discriminant >= 0) {
                         double t1 = (-b + Math.sqrt(discriminant)) / (2*a);
                         double t2 = (-b - Math.sqrt(discriminant)) / (2*a);
                         t = Math.max(t1, t2); 
                    }

                    if (t > 0) {
                        double sx = ux * t;
                        double landXPixel = 250 + sx; 

                        gamePanel.animateBird(syStr, landXPixel, t, ux, uy);

                        if (Math.abs(landXPixel - gamePanel.getPigX()) <= 30) {
                            score += 100;
                            scoreField.setText(String.valueOf(score));
                            JOptionPane.showMessageDialog(null, "Hit! +100 Points");
                            gamePanel.resetPigPosition();
                        } else {
                            JOptionPane.showMessageDialog(null, "Miss! Landed at: " + String.format("%.2f", landXPixel));
                        }
                        gamePanel.resetBird();
                    } else {
                         JOptionPane.showMessageDialog(null, "Bird won't reach the ground.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers");
                }
            }
        });

        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new AngryBirdsGame().setVisible(true);
    }
}

class GamePanel extends JPanel {
    private int pigX;
    private int birdStartX = 250;
    private int birdCurrentX = 250;
    private int birdCurrentY = 200; 
    private Random rand = new Random();
    
    private Image bgImage;
    private Image birdImage;
    private Image pigImage;

    public GamePanel() {
        try {
            bgImage = new ImageIcon(getClass().getResource("bg.jpeg")).getImage();
            birdImage = new ImageIcon(getClass().getResource("bird.png")).getImage();
            pigImage = new ImageIcon(getClass().getResource("pig.png")).getImage();
        } catch (Exception e) {
            bgImage = new ImageIcon("bg.jpeg").getImage();
            birdImage = new ImageIcon("bird.png").getImage();
            pigImage = new ImageIcon("pig.png").getImage();
        }
    }

    public void resetPigPosition() {
        pigX = 300 + rand.nextInt(350); 
        repaint();
    }
    
    public int getPigX() {
        return pigX;
    }
    
    public void resetBird() {
        birdCurrentX = birdStartX;
        birdCurrentY = 200;
        repaint();
    }

    public void animateBird(double startY, double landX, double totalTime, double ux, double uy) {
        int steps = 50;
        double dt = totalTime / steps;
        
        for(int i=0; i<=steps; i++) {
            double currentTime = i * dt;
            double currentSx = ux * currentTime;
            double currentSy = (uy * currentTime) + (0.5 * -10 * currentTime * currentTime);
            
            birdCurrentX = birdStartX + (int)currentSx;
            birdCurrentY = 200 - (int)startY - (int)currentSy; 
            
            paintImmediately(0, 0, getWidth(), getHeight());
            
            try {
                Thread.sleep(20); 
            } catch (InterruptedException e) {
                
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (bgImage != null && bgImage.getWidth(null) > 0) {
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(new Color(135, 206, 235));
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 200, getWidth(), getHeight() - 200);
        }

        if (birdImage != null && birdImage.getWidth(null) > 0) {
            g.drawImage(birdImage, birdCurrentX - 25, birdCurrentY - 25, 50, 50, this);
        } else {
            g.setColor(Color.RED);
            g.fillOval(birdCurrentX - 15, birdCurrentY - 15, 30, 30);
        }

        if (pigImage != null && pigImage.getWidth(null) > 0) {
            g.drawImage(pigImage, pigX - 25, 200 - 40, 50, 50, this);
        } else {
            g.setColor(Color.GREEN);
            g.fillRect(pigX - 15, 200 - 30, 30, 30);
        }
    }
}