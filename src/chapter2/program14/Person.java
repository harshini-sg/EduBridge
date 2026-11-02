package chapter2.program14;

public class Person {
    public static final String INSTITUTION = "ABC Institute of Technology";  // final constant
    private static int personCount = 0;

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        personCount++;
    }

    public String getName() { return name; }
    public int getAge()     { return age; }
    public static int getPersonCount() { return personCount; }

    // Nested class representing a college department
    public static class Department {
        private final String deptName;
        private final String hod;

        public Department(String deptName, String hod) {
            this.deptName = deptName;
            this.hod = hod;
        }

        @Override
        public String toString() {
            return deptName + " (HOD: " + hod + ")";
        }
    }

    // overridden in subclasses
    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    // overloaded version
    public void displayDetails(String heading) {
        System.out.println("=== " + heading + " ===");
        displayDetails();   // run-time polymorphism applies here too
    }

    public static void main(String[] args) {
        Department cse = new Department("Computer Science", "Dr. Nair");
        Department mech = new Department("Mechanical", "Dr. Shetty");

        Person[] people = {
                new Student("Aarav", 20, "1AB22CS010", cse),
                new Faculty("Dr. Kavita", 45, "Professor", cse),
                new Administrator("Mr. Suresh", 50, "Registrar"),
                new Student("Diya", 21, "1AB21ME004", mech)
        };

        System.out.println("Institution: " + INSTITUTION);
        for (Person p : people) {
            p.displayDetails();          // run-time polymorphism
            System.out.println();
        }

        people[0].displayDetails("Overloaded method demo");
        System.out.println("\nTotal people created: " + Person.getPersonCount());
    }

    /*
     * CLASS HIERARCHY
     *
     *                 Person
     *       (name, age, static count, final INSTITUTION,
     *        nested class Department, displayDetails() + overload)
     *         /          |             \
     *    Student      Faculty     Administrator
     *
     * CONCEPTS DEMONSTRATED
     * - Person        : encapsulation (private fields + getters), static counter,
     *                   final constant, static nested class, method overloading.
     * - Student       : inheritance, super(), method overriding, uses nested Department.
     * - Faculty       : inheritance, super(), overriding, uses nested Department.
     * - Administrator : inheritance, super(), overriding.
     * - main()        : Person[] array holding subclass objects -> run-time polymorphism.
     */
}
