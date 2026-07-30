import java.util.Scanner;

public class Noru {
    //attribute
    double stormX;
    double stormY;
    double r;
    double v;
    int n;
    double[] houseX;
    double[] houseY;
    boolean[] isHit;
    int totalAffected;

    //method
    public void inputData(Scanner scanner) {
        this.stormX = scanner.nextDouble();
        this.stormY = scanner.nextDouble();
        this.r = scanner.nextDouble();
        this.v = scanner.nextDouble();
        this.n = scanner.nextInt();
        
        this.houseX = new double[this.n];
        this.houseY = new double[this.n];
        this.isHit = new boolean[this.n];

        for(int i = 0; i < this.n; i++) {
            this.houseX[i] = scanner.nextDouble();
            this.houseY[i] = scanner.nextDouble();
        }
    }

    public void CalStorm() {
        do {

            for(int i = 0; i < this.n; i++) {
                if(this.isHit[i] == false) {
                    double distance = Math.sqrt(Math.pow(this.houseX[i] - this.stormX,2) + Math.pow(this.houseY[i] - this.stormY,2));

                    if(distance <= this.r) {
                        this.isHit[i] = true;
                        this.totalAffected++;
                    }
                }
            }

            this.stormX = this.stormX - this.v;
            this.v = this.v * 0.8;
            this.r = this.r * 0.8;

        } while (this.v >= 1.0);
        
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Noru forecast = new Noru();

        forecast.inputData(scanner);
        forecast.CalStorm();
        System.out.println(forecast.totalAffected);

        scanner.close();
    }
}