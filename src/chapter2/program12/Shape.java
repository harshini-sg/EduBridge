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
}
