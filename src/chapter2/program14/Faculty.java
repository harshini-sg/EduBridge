package chapter2.program14;

public class Faculty extends Person {
    private final String designation;
    private final Department department;

    public Faculty(String name, int age, String designation, Department department) {
        super(name, age);
        this.designation = designation;
        this.department = department;
    }

    public String getDesignation() { return designation; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Faculty, Designation: " + designation
                + ", Department: " + department);
    }
}
