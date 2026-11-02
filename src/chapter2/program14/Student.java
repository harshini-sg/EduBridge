package chapter2.program14;

public class Student extends Person {
    private final String usn;
    private final Department department;

    public Student(String name, int age, String usn, Department department) {
        super(name, age);
        this.usn = usn;
        this.department = department;
    }

    public String getUsn() { return usn; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Student, USN: " + usn + ", Department: " + department);
    }
}
