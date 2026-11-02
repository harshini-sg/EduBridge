package chapter2.program13;

public class UPIPayment extends Payment {
    private static final double FLAT_FEE = 5.0;   // flat Rs. 5 fee

    @Override
    public double calculateAmount(double amount) {
        return amount + FLAT_FEE;
    }
}
