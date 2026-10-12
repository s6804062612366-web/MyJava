/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

/**
 *
 * @author kokarat
 */
import javax.swing.JFrame;
import java.awt.GridLayout;

public class TestDraw extends JFrame {
    public TestDraw() {
        getContentPane().setLayout(new GridLayout(2, 4, 5, 5));
        getContentPane().add(new FunctionA());
        getContentPane().add(new FunctionB());
        getContentPane().add(new FunctionC());
        getContentPane().add(new FunctionD());
        getContentPane().add(new FunctionE());
        getContentPane().add(new FunctionF());
        getContentPane().add(new FunctionG());
    }

    public static void main(String[] args) {
        TestDraw frame = new TestDraw();
        frame.setSize(1200, 600);
        frame.setTitle("Exercise 10.10");
        frame.setVisible(true);
    }
}