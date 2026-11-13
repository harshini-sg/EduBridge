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
}
