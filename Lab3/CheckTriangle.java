import java.util.Scanner;

public class CheckTriangle {

    public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        double D = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);

        return D > 0;
    }

    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        double D = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);

        return D == 0;
    }

    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {
        double D = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        boolean isBetweenX = x2 >= Math.min(x0, x1) && x2 <= Math.max(x0, x1);
        boolean isBetweenY = y2 >= Math.min(y0, y1) && y2 <= Math.max(y0, y1);

        return D == 0 && isBetweenX && isBetweenY;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double x0 = input.nextDouble();
        double y0 = input.nextDouble();
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            System.out.println(0); 
        } else if (leftOfTheLine(x0, y0, x1, y1, x2, y2)) {
            System.out.println(2);
        } else {
            System.out.println(1);
        }
    }
}