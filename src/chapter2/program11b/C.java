package chapter2.program11b;

public class C extends B {
    C(int value) {
        super(value + 1);   // passes a different value to B
        System.out.println("C constructor, value = " + value);
    }

    public static void main(String[] args) {
        C obj = new C(10);
    }
}
