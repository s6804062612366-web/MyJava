import java.util.Scanner;

public class MultiTable {
    //attribute
    int column = 0;
    int row = 0;
    int result = 0;

    //method
    public void Table() {
        System.out.print("    ");
        for(int i = 1; i <= this.column; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        System.out.println("----------------------------------------");

        for(int i = 1; i <= this.row; i++) {
            System.out.printf("%2d |", i);

            for(int j = 1; j <= this.column; j++) {
                System.out.printf("%4d",i * j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MultiTable generate = new MultiTable();

        System.out.println("Please input number of columns and rows: ");
        generate.column = scanner.nextInt();
        generate.row = scanner.nextInt();

        generate.Table();

        scanner.close();
    }
        
}