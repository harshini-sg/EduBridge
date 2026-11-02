package chapter2.program10;

public class Manager extends Employee {
    private final String department;
    private final double bonus;

    public Manager(String name, int age, int empId, double basicSalary,
                   String department, double bonus) {
        super(name, age, empId, basicSalary);
        System.out.println("Manager constructor");
        this.department = department;
        this.bonus = bonus;
    }

    public double totalSalary() {
        return getBasicSalary() + bonus;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + department + ", Bonus: " + bonus);
        System.out.println("Total Salary: " + totalSalary());
    }

    public static void main(String[] args) {
        Manager m = new Manager("Priya", 38, 501, 90000, "Engineering", 25000);
        System.out.println("----------------");
        m.display();
    }

    /*
     * PREDICTED ORDER when a Manager is created:
     *   Person constructor
     *   Employee constructor
     *   Manager constructor
     * Reason: Manager() calls super(...) first -> Employee() calls super(...) first ->
     * Person() runs its body first. Bodies then complete from the top of the hierarchy
     * down to the child.
     */
}
