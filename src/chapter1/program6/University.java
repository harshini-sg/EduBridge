package chapter1.program6;

public class University {
    private final String name;

    public University(String name) {
        this.name = name;
    }

    // static nested class: does not need a University object
    public static class Department {
        private final String deptName;

        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void display() {
            System.out.println("Department: " + deptName);
        }
    }

    // non-static inner class: tied to a University object
    public class Faculty {
        private final String facultyName;
        private final String designation;

        public Faculty(String facultyName, String designation) {
            this.facultyName = facultyName;
            this.designation = designation;
        }

        public void display() {
            System.out.println("Faculty: " + facultyName + " (" + designation + ")"
                    + " at " + name);   // can use the outer object's members
        }
    }

    public void displayUniversity() {
        System.out.println("University: " + name);
    }

    public static void main(String[] args) {
        University uni = new University("Global Tech University");

        // Department without any University object
        University.Department dept = new University.Department("Computer Science");

        // Faculty requires the University object
        University.Faculty fac = uni.new Faculty("Dr. Meera Rao", "Professor");

        uni.displayUniversity();
        dept.display();
        fac.display();
    }

    /*
     * CHALLENGE
     * A non-static inner class holds a hidden reference to its enclosing instance
     * (University.this) and may use its fields (like name), so an outer object must
     * exist first: uni.new Faculty(...).
     * A static nested class is just a class placed inside another for grouping; it has
     * no hidden reference to an outer instance, so it is created independently:
     * new University.Department(...).
     */
}
