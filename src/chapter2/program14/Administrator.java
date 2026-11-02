package chapter2.program14;

public class Administrator extends Person {
    private final String post;

    public Administrator(String name, int age, String post) {
        super(name, age);
        this.post = post;
    }

    public String getPost() { return post; }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Administrator, Post: " + post);
    }
}
