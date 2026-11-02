package chapter2.program8;

public class ContractEmployee extends Employee {
    private final int hoursWorked;
    private final double hourlyRate;

    public ContractEmployee(int id, String name, double basicSalary,
                            int hoursWorked, double hourlyRate) {
        super(id, name, basicSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Type: Contract, Hours: " + hoursWorked + ", Rate: " + hourlyRate);
    }
}
