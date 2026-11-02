package chapter2.program8;

public class PermanentEmployee extends Employee {
    private final double allowance;
    private final double bonus;

    public PermanentEmployee(int id, String name, double basicSalary,
                             double allowance, double bonus) {
        super(id, name, basicSalary);   // reuse parent constructor
        this.allowance = allowance;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBasicSalary() + allowance + bonus;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Type: Permanent, Allowance: " + allowance + ", Bonus: " + bonus);
    }
}
