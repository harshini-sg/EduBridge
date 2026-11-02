package chapter2.program11;

public class C extends B {
    C() {
        System.out.println("C constructor");
    }

    public static void main(String[] args) {
        C obj = new C();
    }

    /*
     * PREDICTED OUTPUT:
     *   A constructor
     *   B constructor
     *   C constructor
     * (The compiler inserts an implicit super() as the first statement of each constructor.)
     */
}
