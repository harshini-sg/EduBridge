package chapter2.program10;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        System.out.println("Person constructor");
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
