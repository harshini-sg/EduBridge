package chapter1.program4;

public class Student {
    private static final int MAX_MARKS = 100;   // constant: never changes
    private static int studentCount = 0;        // shared by all students

    private final String usn;
    private final String name;
    private final int[] marks = new int[3];

    public Student(String usn, String name, int m1, int m2, int m3) {
        if (!isValid(m1) || !isValid(m2) || !isValid(m3)) {
            throw new IllegalArgumentException(
                    "Marks must be between 0 and " + MAX_MARKS);
        }
        this.usn = usn;
        this.name = name;
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
        studentCount++;
    }

    // validation method protecting the marks
    public static boolean isValid(int mark) {
        return mark >= 0 && mark <= MAX_MARKS;
    }

    public String getUsn()  { return usn; }
    public String getName() { return name; }
    public int[] getMarks() { return marks.clone(); }   // copy keeps the original safe
    public static int getStudentCount() { return studentCount; }

    public int total() {
        return marks[0] + marks[1] + marks[2];
    }

    public double average() {
        return total() / 3.0;
    }

    // Nested class holding the result summary
    public static class ResultSummary {
        private final String usn;
        private final int total;
        private final double average;
        private final String result;

        ResultSummary(String usn, int total, double average, String result) {
            this.usn = usn;
            this.total = total;
            this.average = average;
            this.result = result;
        }

        public String getUsn()      { return usn; }
        public int getTotal()       { return total; }
        public double getAverage()  { return average; }
        public String getResult()   { return result; }
    }

    // returns a NEW object containing the result summary
    public ResultSummary getResultSummary() {
        boolean pass = marks[0] >= 35 && marks[1] >= 35 && marks[2] >= 35;
        return new ResultSummary(usn, total(), average(), pass ? "PASS" : "FAIL");
    }

    // overloaded display(): basic details
    public void display() {
        System.out.println("USN: " + usn + ", Name: " + name);
    }

    // overloaded display(): result
    public void display(ResultSummary summary) {
        System.out.println("USN: " + summary.getUsn()
                + " | Total: " + summary.getTotal()
                + " | Average: " + String.format("%.2f", summary.getAverage())
                + " | Result: " + summary.getResult());
    }

    public static void main(String[] args) {
        Student s1 = new Student("1AB21CS001", "Asha", 78, 85, 90);
        Student s2 = new Student("1AB21CS002", "Ravi", 30, 60, 72);

        s1.display();
        s1.display(s1.getResultSummary());
        s2.display();
        s2.display(s2.getResultSummary());

        System.out.println("Students created: " + Student.getStudentCount());

        try {
            new Student("1AB21CS003", "Invalid", 120, 50, 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*
     * CHALLENGE
     * - static suits the count because the count belongs to the CLASS, not to any one
     *   student. One shared copy is updated by every constructor call.
     * - MAX_MARKS can be final because the maximum permitted marks is a fixed rule that
     *   must never change while the program runs; final (with static) makes it a
     *   true constant and prevents accidental modification.
     */
}
