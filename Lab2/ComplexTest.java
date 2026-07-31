class Complex {
    private double r, i;

    Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }

    Complex(Complex c) {
        this(c.r, c.i);
    }

    // method +
    public void add(Complex c) {
        r += c.r;
        i += c.i;
    }

    // method -
    public void subtract(Complex c) {
        r -= c.r;
        i -= c.i;
    }

    // method *
    public void multiply(Complex c) {
        double newR = (r * c.r) - (i * c.i);
        double newI = (r * c.i) + (i * c.r);
        r = newR;
        i = newI;
    }

    // method /
    public void divide(Complex c) {
        double denominator = (c.r * c.r) + (c.i * c.i);
        double newR = ((r * c.r) + (i * c.i)) / denominator;
        double newI = ((i * c.r) - (r * c.i)) / denominator;
        r = newR;
        i = newI;
    }

    public void print() {
        System.out.println(r + " + " + i + "i");
    }
}

class ComplexTest {
    public static void main(String args[]) {
        Complex a = new Complex(1.0, 2.0);
        Complex b = new Complex(3.0, 4.0);

        Complex c1 = new Complex(a);
        c1.add(b);
        System.out.print("Add: ");
        c1.print();

        Complex c2 = new Complex(a);
        c2.subtract(b);
        System.out.print("Subtract: ");
        c2.print();

        Complex c3 = new Complex(a);
        c3.multiply(b);
        System.out.print("Multiply: ");
        c3.print();

        Complex c4 = new Complex(a);
        c4.divide(b);
        System.out.print("Divide: ");
        c4.print();
    }
}