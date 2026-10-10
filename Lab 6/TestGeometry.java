/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author kokarat
 */
public class TestGeometry {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0, "red", true);
        System.out.println(circle.toString());
        System.out.println("Circle Area: " + circle.findArea());
        System.out.println("Circle Perimeter: " + circle.findPerimeter());
        System.out.println("Color: " + circle.getColor() + ", Filled: " + circle.isFilled());

        System.out.println("-------------------------");

        Rectangle rectangle = new Rectangle(4.0, 6.0, "blue", false);
        System.out.println("Rectangle Width: " + rectangle.getWidth() + ", Height: " + rectangle.getHeight());
        System.out.println("Rectangle Area: " + rectangle.findArea());
        System.out.println("Rectangle Perimeter: " + rectangle.findPerimeter());
        System.out.println("Color: " + rectangle.getColor() + ", Filled: " + rectangle.isFilled());
    }
}