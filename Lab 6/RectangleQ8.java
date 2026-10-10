/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author kokarat
 */
public class RectangleQ8 {
    public double width;
    public double height;
    public double x;
    public double y;

    public RectangleQ8() {
    }

    public RectangleQ8(double width, double height, double x, double y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public double getArea(RectangleQ8 a) {
        return a.width * a.height;
    }
}