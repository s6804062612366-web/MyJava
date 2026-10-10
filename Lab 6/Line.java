/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author kokarat
 */
public class Line {
    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public Line() {
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getLong(Line a) {
        return Math.sqrt(Math.pow(a.x2 - a.x1, 2) + Math.pow(a.y2 - a.y1, 2));
    }
}