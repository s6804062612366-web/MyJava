import java.util.Scanner;

public class Occurrence {
    //attribute
    int count = 0;
    int max = 0;

    //method
    public void FindMax() {
        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            input = scanner.nextInt();
            if(input > this.max) {
                this.max = input;
                this.count = 1;
            } else if (input == this.max) {
                this.count++;
            }
        } while (input != 0);

        scanner.close();
    }

    public static void main(String[] args) {
        Occurrence find = new Occurrence();

        find.FindMax();
        System.out.println(find.max +" "+find.count);
    }
}