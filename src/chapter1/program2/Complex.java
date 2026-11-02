package chapter1.program2;

public class Complex {
    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public void setReal(double real) { this.real = real; }
    public void setImag(double imag) { this.imag = imag; }

    // object passed as parameter, new object returned
    public Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    // (a + bi)(c + di) = (ac - bd) + (ad + bc)i
    public Complex multiply(Complex c) {
        double r = this.real * c.real - this.imag * c.imag;
        double i = this.real * c.imag + this.imag * c.real;
        return new Complex(r, i);
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    // returns 1 if this is larger, -1 if smaller, 0 if equal
    public int compareMagnitude(Complex c) {
        return Double.compare(this.magnitude(), c.magnitude());
    }

    // returns a brand new object with the same values
    public Complex copy() {
        return new Complex(this.real, this.imag);
    }

    public void display() {
        if (imag >= 0) {
            System.out.println(real + " + " + imag + "i");
        } else {
            System.out.println(real + " - " + Math.abs(imag) + "i");
        }
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(1, -2);

        System.out.print("c1 = "); c1.display();
        System.out.print("c2 = "); c2.display();

        System.out.print("c1 + c2 = "); c1.add(c2).display();
        System.out.print("c1 * c2 = "); c1.multiply(c2).display();

        int result = c1.compareMagnitude(c2);
        if (result > 0)      System.out.println("c1 has the larger magnitude");
        else if (result < 0) System.out.println("c2 has the larger magnitude");
        else                 System.out.println("Both magnitudes are equal");

        // Challenge: modify an object after copying it
        Complex copy = c1.copy();
        c1.setReal(100);
        c1.setImag(200);
        System.out.print("Modified original c1 = "); c1.display();
        System.out.print("Copy (unchanged)     = "); copy.display();
    }
}
