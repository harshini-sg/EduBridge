package chapter1.program7;

public class Counter {
    static int count = 0;
    int id;

    static {
        System.out.println("Static block");
    }

    {
        count++;
        id = count;
        System.out.println("Instance block: " + id);
    }

    Counter() {
        System.out.println("Constructor: " + id);
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        System.out.println(Counter.count);
    }

    /*
     * PREDICTED OUTPUT:
     *   Static block
     *   Instance block: 1
     *   Constructor: 1
     *   Instance block: 2
     *   Constructor: 2
     *   2
     *
     * - Static block runs ONCE, when the class is loaded (before main starts here).
     * - Instance initialization block runs 2 times (once per object created).
     * - Order per object: instance initialization block first, then constructor body.
     * - Final value of count: 2
     */
}
