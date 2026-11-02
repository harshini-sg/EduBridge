package chapter2.program13;

public class CardPayment extends Payment {
    private static final double FEE_PERCENT = 2.0;   // 2% card fee

    @Override
    public double calculateAmount(double amount) {
        return amount + (amount * FEE_PERCENT / 100);
    }
}
