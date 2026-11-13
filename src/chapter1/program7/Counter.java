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
}
