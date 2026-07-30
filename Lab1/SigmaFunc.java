import java.util.Scanner;

public class SigmaFunc {
    //attribute
    double x = 0;
    int n = 0;
    double result = 0.0;
    
    //method
    public void Func() {
        for(int i = 0; i <= this.n; i++) {
            this.result = this.result + Math.pow(this.x,i);
        } 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SigmaFunc cal = new SigmaFunc();

        System.out.println("Please input x, n: ");
        cal.x = scanner.nextDouble();
        cal.n = scanner.nextInt();

        cal.Func();

        System.out.println("Output is: " + (int)cal.result);
    }
} 