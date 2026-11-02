package chapter2.program12;

public class Shape {
    public double area() {
        return 0;
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(7);
        shapes[1] = new Rectangle(5, 8);
        shapes[2] = new Triangle(6, 4);

        for (Shape s : shapes) {
            System.out.println(s.getClass().getSimpleName()
                    + " area = " + String.format("%.2f", s.area()));
        }
    }

    /*
     * CHALLENGE - why does the actual object decide which method runs?
     * Overridden methods are resolved at RUN TIME (dynamic method dispatch).
     * The reference type (Shape) only tells the compiler that area() exists.
     * At run time the JVM looks at the real object on the heap (Circle, Rectangle or
     * Triangle) and calls that class's version of area().
     */
}
