/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8;

/**
 *
 * @author kokarat
 */
public class TestOctagon {
    public static void main(String[] args) {
        Octagon oct1 = new Octagon(5);
        System.out.println(oct1.getArea());
        System.out.println(oct1.getPerimeter());
        
        Octagon oct2 = (Octagon) oct1.clone();
        System.out.println(oct1.equals(oct2));
    }
}