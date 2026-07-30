import java.util.Scanner;

public class CalculateInterest {
    //attribute
    double Interest = 0.0;
    double balance = 0.0;
    double annualInterestRate = 0.0;

    //method
    public void Calculate() {
        this.Interest = this.balance * (this.annualInterestRate / 1200);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculateInterest app = new CalculateInterest();

        System.out.println("Enter balance and interest rate (e.g., 3 for 3%): ");
        app.balance = scanner.nextDouble();
        app.annualInterestRate = scanner.nextDouble();

        app.Calculate();

        System.out.printf("The interest is %.5f\n",app.Interest);

        scanner.close();
    }
}