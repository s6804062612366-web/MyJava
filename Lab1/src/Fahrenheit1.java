import javax.swing.JOptionPane;

public class Fahrenheit1 {
    public static void main(String[] args) {
        String inputStr = JOptionPane.showInputDialog("Input Fahrenheit:");
        double fahrenheit = Double.parseDouble(inputStr);
        double celsius = (5.0/9.0)*(fahrenheit - 32);
        JOptionPane.showMessageDialog(null, "Celsius: " + celsius);
    }
}