/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author kokarat
 */
public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle2D() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double px, double py) {
        return px >= x - width / 2 && px <= x + width / 2 &&
               py >= y - height / 2 && py <= y + height / 2;
    }

    public boolean contains(MyRectangle2D r) {
        return r.getX() - r.getWidth() / 2 >= x - width / 2 &&
               r.getX() + r.getWidth() / 2 <= x + width / 2 &&
               r.getY() - r.getHeight() / 2 >= y - height / 2 &&
               r.getY() + r.getHeight() / 2 <= y + height / 2;
    }

    public boolean overlaps(MyRectangle2D r) {
        return !(r.getX() - r.getWidth() / 2 > x + width / 2 ||
                 r.getX() + r.getWidth() / 2 < x - width / 2 ||
                 r.getY() - r.getHeight() / 2 > y + height / 2 ||
                 r.getY() + r.getHeight() / 2 < y - height / 2);
    }
}