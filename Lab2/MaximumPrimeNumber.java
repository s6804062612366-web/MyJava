import java.util.Scanner;

class PrimeAnalyzer {
    // attribute
    private int maxPrime;

    public PrimeAnalyzer() {
        this.maxPrime = -1;
    }

   // method
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false; 
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void processNumber(int num) {
        if (isPrime(num)) {
            if (num > maxPrime) {
                maxPrime = num;
            }
        }
    }

    public int getMaxPrime() {
        return maxPrime;
    }
}

public class MaximumPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimeAnalyzer analyzer = new PrimeAnalyzer();

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            
            if (num == 0) {
                break;
            }
            
            analyzer.processNumber(num);
        }

        System.out.println(analyzer.getMaxPrime());
        
        scanner.close();
    }
}