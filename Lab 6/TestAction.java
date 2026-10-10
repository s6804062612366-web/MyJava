/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author kokarat
 */
public class TestAction {
    public static void main(String[] args) {
        Line line1 = new Line(0, 0, 5, 5);
        Line line2 = new Line(2, 0, 2, 6);
        
        RectangleQ8 rect1 = new RectangleQ8(4, 4, 1, 5);
        RectangleQ8 rect2 = new RectangleQ8(3, 3, 2, 6);

        GeometryAction action = new GeometryAction();

        System.out.println("Line length: " + line1.getLong(line1));
        System.out.println("Rectangle Area: " + rect1.getArea(rect1));

        System.out.println("Contains Line in Rect1? (1=Yes, 0=No): " + action.contains(line1, rect1));
        System.out.println("Lines cross? (1=Yes, 0=No): " + action.cross(line1, line2));
        System.out.println("Rectangles overlap? (1=Yes, 0=No): " + action.overlaps(rect1, rect2));
        System.out.println("Distance between Line1 and Rect1: " + action.distance(line1, rect1));
    }
}