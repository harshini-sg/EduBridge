package chapter1.program3;

public class Student {
    int marks;

    Student(int marks) {
        this.marks = marks;
    }

    static void change(int x, Student s) {
        x = 100;                 // changes only the local copy
        s.marks = 95;            // follows the copied reference -> modifies the real object
        s = new Student(50);     // only the local reference now points to a new object
    }

    public static void main(String[] args) {
        int n = 20;
        Student st = new Student(60);

        change(n, st);

        System.out.println(n);          // 20
        System.out.println(st.marks);   // 95
    }
