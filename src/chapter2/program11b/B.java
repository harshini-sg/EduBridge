package chapter2.program11b;

public class B extends A {
    B(int value) {
        super(value + 1);   // passes a different value to A
        System.out.println("B constructor, value = " + value);
    }
}
