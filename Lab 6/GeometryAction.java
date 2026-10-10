/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

/**
 *
 * @author kokarat
 */
public class GeometryAction {
    public int contains(Line a, RectangleQ8 b) {
        boolean p1In = a.x1 >= b.x && a.x1 <= b.x + b.width && a.y1 <= b.y && a.y1 >= b.y - b.height;
        boolean p2In = a.x2 >= b.x && a.x2 <= b.x + b.width && a.y2 <= b.y && a.y2 >= b.y - b.height;
        if (p1In && p2In) {
            return 1;
        }
        return 0;
    }

    public int cross(Line a, Line b) {
        double minXA = Math.min(a.x1, a.x2);
        double maxXA = Math.max(a.x1, a.x2);
        double minYA = Math.min(a.y1, a.y2);
        double maxYA = Math.max(a.y1, a.y2);
        double minXB = Math.min(b.x1, b.x2);
        double maxXB = Math.max(b.x1, b.x2);
        double minYB = Math.min(b.y1, b.y2);
        double maxYB = Math.max(b.y1, b.y2);

        if (maxXA >= minXB && maxXB >= minXA && maxYA >= minYB && maxYB >= minYA) {
            return 1;
        }
        return 0;
    }

    public int overlaps(RectangleQ8 a, RectangleQ8 b) {
        if (a.x > b.x + b.width || b.x > a.x + a.width) {
            return 0;
        }
        if (a.y - a.height > b.y || b.y - b.height > a.y) {
            return 0;
        }
        return 1;
    }

    public double distance(Line a, RectangleQ8 b) {
        double lineMidX = (a.x1 + a.x2) / 2;
        double lineMidY = (a.y1 + a.y2) / 2;
        double rectMidX = b.x + (b.width / 2);
        double rectMidY = b.y - (b.height / 2);
        return Math.sqrt(Math.pow(lineMidX - rectMidX, 2) + Math.pow(lineMidY - rectMidY, 2));
    }
}