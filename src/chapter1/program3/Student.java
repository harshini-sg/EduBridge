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

    /*
     * PREDICTED OUTPUT:
     *   20
     *   95
     *
     * 1. Why does n retain its value?
     *    int is a primitive. A COPY of the value 20 is passed to x, so changing x
     *    does not affect n.
     *
     * 2. Why does st.marks change?
     *    The reference st is copied into s. Both refer to the SAME object on the heap,
     *    so s.marks = 95 modifies that shared object.
     *
     * 3. Why doesn't s = new Student(50) change st?
     *    s is only a local copy of the reference. Re-pointing s to a new object
     *    does not alter st in main(); st still refers to the original object.
     *
     * 4. Is Java pass-by-value or pass-by-reference?
     *    Always PASS-BY-VALUE. For objects, the value being copied is the
     *    reference (address), not the object itself.
     */
}
