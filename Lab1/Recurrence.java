import java.util.Scanner;

public class Recurrence {
    //attribute
    int n;
    double a0;
    double a1;
    double[] a;
    
    //method
    public void CalRecurrence() {
        this.a[0] = this.a0;
        this.a[1] = this.a1;

        for(int k = 2; k <= this.n; k++) {
            this.a[k] = Math.pow(k,2) * a[k - 1] - a[k - 2] + Math.pow(3,k);
        }
    }

    public void PrintA() {
        System.out.print("Output is: ");
        for(int i = 0; i <= n; i++) {
            System.out.print((int)this.a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Recurrence cal = new Recurrence();

        System.out.println("Please input n, a0 and a1: ");
        cal.n = scanner.nextInt();
        cal.a0 = scanner.nextDouble();
        cal.a1 = scanner.nextDouble();

        cal.a = new double[cal.n + 1];

        cal.CalRecurrence();
        cal.PrintA();

        scanner.close();

    }
}