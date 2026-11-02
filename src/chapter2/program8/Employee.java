package chapter2.program8;

public class Employee {
    private final int id;
    private final String name;
    private final double basicSalary;

    public Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public int getId()             { return id; }
    public String getName()        { return name; }
    public double getBasicSalary() { return basicSalary; }

    // overridden by subclasses
    public double calculateSalary() {
        return basicSalary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name
                + ", Basic Salary: " + basicSalary);
    }

    public static void main(String[] args) {
        // parent-type array holding both kinds of employees
        Employee[] employees = {
                new PermanentEmployee(101, "Anita", 40000, 8000, 5000),
                new ContractEmployee(102, "Rahul", 0, 120, 450),
                new PermanentEmployee(103, "Vikram", 55000, 10000, 7500),
                new ContractEmployee(104, "Sneha", 0, 100, 500)
        };

        for (Employee e : employees) {
            e.display();
            System.out.println("Calculated Salary: " + e.calculateSalary());
            System.out.println("-----------------------------");
        }
    }
}
