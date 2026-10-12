/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

/**
 *
 * @author kokarat
 */
public class TestRectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4.0, 5.0);
        Rectangle r2 = new Rectangle(2.0, 10.0);
        System.out.println(r1.equals(r2));
        System.out.println(r1.compareTo(r2));
    }
}
