package chapter2.program11b;

public class C extends B {
    C(int value) {
        super(value + 1);   // passes a different value to B
        System.out.println("C constructor, value = " + value);
    }

    public static void main(String[] args) {
        C obj = new C(10);
    }

    /*
     * OUTPUT:
     *   A constructor, value = 12
     *   B constructor, value = 11
     *   C constructor, value = 10
     *
     * CHALLENGE - super()/super(value) after another statement:
     *   C(int value) {
     *       System.out.println("Hello");
     *       super(value + 1);      // COMPILE ERROR
     *   }
     * The call to super(...) or this(...) MUST be the first statement in a constructor
     * (older Java versions report "call to super must be first statement in constructor").
     * Reason: the parent part of the object has to be built before the child part runs.
     * (Java 22+ allows statements before super() only if they don't use 'this'.)
     */
}
