/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author student
 */
import java.awt.*;
import javax.swing.*;

public class Test extends JFrame
{
    public Test()
    {
        getContentPane().setLayout(new GridLayout(2, 4, 5, 5));
        
        getContentPane().add(new DrawSquare()); 
        getContentPane().add(new DrawSine()); 
        getContentPane().add(new DrawCos());  
        getContentPane().add(new DrawTan());    
        getContentPane().add(new DrawCos5Sin()); 
        getContentPane().add(new Draw5CosSin()); 
        getContentPane().add(new DrawLog());  
    }
    
    public static void main(String[] args)
    {
        Test frame = new Test();
        frame.setSize(400, 400);
        frame.setTitle("Exercise 10.10");
        frame.setVisible(true);
    }
}

class DrawSquare extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return (Math.pow(x,2));
    }
}

class DrawSine extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 100*(Math.sin(Math.toRadians(x)));
    }
}
class DrawCos extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 100*(Math.cos(Math.toRadians(x)));
    }
}

class DrawTan extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 100*(Math.tan(Math.toRadians(x)));
    }
}

class DrawCos5Sin extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 10*(Math.cos(Math.toRadians(x)) + 5*Math.sin(Math.toRadians(x)));
    }
}

class Draw5CosSin extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 10*(5*Math.cos(Math.toRadians(x)) + Math.sin(Math.toRadians(x)));
    }
}

class DrawLog extends AbstractDrawFunction {
    @Override 
    public double f(double x) {
        return 10*(Math.log(x) + Math.pow(x, 2));
    }
}
