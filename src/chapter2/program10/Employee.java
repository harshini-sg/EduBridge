package chapter2.program10;

public class Employee extends Person {
    private final int empId;
    private final double basicSalary;

    public Employee(String name, int age, int empId, double basicSalary) {
        super(name, age);
        System.out.println("Employee constructor");
        this.empId = empId;
        this.basicSalary = basicSalary;
    }

    public double getBasicSalary() { return basicSalary; }

    @Override
    public void display() {
        super.display();
        System.out.println("Employee ID: " + empId + ", Basic Salary: " + basicSalary);
    }
}
