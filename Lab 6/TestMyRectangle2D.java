/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author kokarat
 */
public class TestMyRectangle2D {

    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
        System.out.println("Area is " + r1.getArea());
        System.out.println("Perimeter is " + r1.getPerimeter());

        System.out.println("r1.contains(3, 3): " + r1.contains(3, 3));

        MyRectangle2D r2 = new MyRectangle2D(4, 5, 10.5, 3.2);
        System.out.println("r1.contains(r2): " + r1.contains(r2));

        MyRectangle2D r3 = new MyRectangle2D(3, 5, 2.3, 5.4);
        System.out.println("r1.overlaps(r3): " + r1.overlaps(r3));
    }
}
