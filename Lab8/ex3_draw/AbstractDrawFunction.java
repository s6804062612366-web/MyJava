package lab8;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kokarat
 */
import javax.swing.JPanel;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractDrawFunction extends JPanel {
    private Polygon p = new Polygon();

    protected AbstractDrawFunction() {
        drawFunction();
        setBackground(Color.white);
    }

    public abstract double f(double x);

    public void drawFunction() {
        for (int x = -100; x <= 100; x++) {
            p.addPoint(x + 200, 200 - (int) f(x));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(10, 200, 390, 200);
        g.drawLine(200, 30, 200, 390);
        g.drawLine(390, 200, 370, 190);
        g.drawLine(390, 200, 370, 210);
        g.drawLine(200, 30, 190, 50);
        g.drawLine(200, 30, 210, 50);
        g.drawString("X", 370, 170);
        g.drawString("Y", 220, 40);
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
} 

class FunctionA extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return x * x;
    }
} 

class FunctionB extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.sin(x);
    }
} 

class FunctionC extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.cos(x);
    }
}  

class FunctionD extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.tan(x);
    }
}  

class FunctionE extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.cos(x) + 5 * Math.sin(x);
    }
} 

class FunctionF extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 5 * Math.cos(x) + Math.sin(x);
    }
}  

class FunctionG extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.log10(x) + (x * x);
    }
}