import java.util.Scanner;

public class Fahrenheit2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (5.0/9.0)*(fahrenheit - 32);
        System.out.println("Celsius: " + celsius);
        scanner.close();
    }
}
