package chapter2.program13;

public class Payment {

    // overridden in subclasses
    public double calculateAmount(double amount) {
        return amount;
    }

    // overloaded: amount + discount percentage
    public double calculateAmount(double amount, double discountPercent) {
        double discounted = amount - (amount * discountPercent / 100);
        return calculateAmount(discounted);   // fee rule of the ACTUAL object is applied
    }

    public static void main(String[] args) {
        Payment p1 = new CardPayment();   // parent reference, child object
        Payment p2 = new UPIPayment();

        System.out.println("Card, 1000          : " + p1.calculateAmount(1000));
        System.out.println("UPI,  1000          : " + p2.calculateAmount(1000));
        System.out.println("Card, 1000, 10% off : " + p1.calculateAmount(1000, 10));
        System.out.println("UPI,  1000, 10% off : " + p2.calculateAmount(1000, 10));
    }

    /*
     * COMPILE TIME vs RUN TIME
     * - Compile time: for p1.calculateAmount(1000) the compiler checks the reference type
     *   (Payment) and picks the SIGNATURE calculateAmount(double). For (1000, 10) it picks
     *   calculateAmount(double, double). This is overloading resolution.
     * - Run time: the JVM looks at the real object (CardPayment / UPIPayment) and runs
     *   that class's overridden calculateAmount(double). This is overriding resolution.
     *
     * CHALLENGE
     * - Can a private method be overridden? NO. A private method is not inherited, so a
     *   subclass method with the same signature is a completely new method (and is
     *   not called polymorphically).
     * - Can a final method be overridden? NO. final prevents overriding; a subclass that
     *   tries gives a compile-time error.
     */
}
