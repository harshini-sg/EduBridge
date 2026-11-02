package chapter1.program1;

public class Calculator {

    // returns the sum
    int calculate(int a, int b) {
        return a + b;
    }

    // returns the product
    double calculate(double a, double b) {
        return a * b;
    }

    // returns the largest of three numbers
    int calculate(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // returns the difference as a double
    double calculate(int a, double b) {
        return a - b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Sum (int, int)            : " + calc.calculate(10, 20));
        System.out.println("Product (double, double)  : " + calc.calculate(2.5, 4.0));
        System.out.println("Largest (int, int, int)   : " + calc.calculate(7, 42, 15));
        System.out.println("Difference (int, double)  : " + calc.calculate(10, 3.5));
    }

    /*
     * CHALLENGE - How does Java select the overloaded method?
     * Overload resolution happens at COMPILE TIME using the method NAME plus the
     * number, types and order of the arguments (the return type is NOT considered).
     * 1. The compiler first looks for an exact match of argument types.
     * 2. If none exists, it tries widening (int -> long -> float -> double),
     *    then boxing/unboxing, then varargs.
     * 3. If more than one method fits equally well, the call is ambiguous
     *    and a compile-time error is reported.
     * Example: calculate(10, 3.5) matches (int, double) exactly.
     *          calculate(2.5, 4.0) matches (double, double) exactly.
     */
}
