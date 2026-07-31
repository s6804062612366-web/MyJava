import java.util.Scanner;

public class Estimate {
    //method
    public double m(int i) {
        double sum = 0.0;

        for(int j = 1; j <= i; j++) {
            double A = Math.pow(-1,j + 1);
            double B = (2.0 * j) - 1;
            sum += A / B;
        }

        return 4.0 * sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Estimate Cal = new Estimate();
        int n = input.nextInt();
        
        double result = Cal.m(n);

        System.out.printf("%.4f\n", result);

    }
}