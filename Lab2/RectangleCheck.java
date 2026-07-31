import java.util.Scanner;

public class RectangleCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double w1 = input.nextDouble();
        double h1 = input.nextDouble();

        System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double w2 = input.nextDouble();
        double h2 = input.nextDouble();

        double dx = Math.abs(x1 - x2);
        double dy = Math.abs(y1 - y2);

        if (dx + (w2 / 2) <= (w1 / 2) && dy + (h2 / 2) <= (h1 / 2)) {
            System.out.println("r2 is inside r1");
        } else if (dx <= (w1 + w2) / 2 && dy <= (h1 + h2) / 2) {
            System.out.println("r2 overlaps r1");
        } else {
            System.out.println("r2 does not overlap r1");
        }

        input.close();
    }
}