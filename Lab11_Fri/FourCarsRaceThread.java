import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CarPane extends JPanel implements Runnable {
    private int xBase = 0;
    private int speed;

    public CarPane(int speed) {
        this.speed = speed;
        setPreferredSize(new Dimension(400, 50));
        Thread thread = new Thread(this);
        thread.start();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yBase = getHeight() - 10;

        g.setColor(Color.BLACK);
        g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);

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
}

public class FourCarsRaceThread extends JFrame {
    private CarPane[] cars = new CarPane[4];
    private JTextField[] speedFields = new JTextField[4];

    public FourCarsRaceThread() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 8));

        int[] initialSpeeds = {10, 20, 30, 40};

        for (int i = 0; i < 4; i++) {
            controlPanel.add(new JLabel("Car " + (i + 1) + ": "));
            speedFields[i] = new JTextField(String.valueOf(initialSpeeds[i]));
            controlPanel.add(speedFields[i]);
            
            final int carIndex = i;
            speedFields[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int newSpeed = Integer.parseInt(speedFields[carIndex].getText());
                        cars[carIndex].setSpeed(newSpeed);
                    } catch (NumberFormatException ex) {
                        speedFields[carIndex].setText("10");
                        cars[carIndex].setSpeed(10);
                    }
                }
            });
        }

        JPanel racePanel = new JPanel();
        racePanel.setLayout(new GridLayout(4, 1));

        for (int i = 0; i < 4; i++) {
            cars[i] = new CarPane(initialSpeeds[i]);
            racePanel.add(cars[i]);
        }

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);
        add(racePanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        FourCarsRaceThread frame = new FourCarsRaceThread();
        frame.setTitle("Exercise18_17");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}