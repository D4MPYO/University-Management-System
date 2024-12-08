import java.util.Random;

public class Instructor extends Details {
    private String instructorID;

    public Instructor(String lastName, String firstName, String middleName, String address, int age) {
        super(lastName, firstName, middleName, address, age);
        this.instructorID = generateInstructorID();
    }

    public String getInstructorID() {
        return instructorID;
    }

    private String generateInstructorID() {
        Random rand = new Random();
        return "INS" + (+24) + "-" + (rand.nextInt(9000) + 1000);
    }

    public void displayInfo() {
        System.out.println("Instructor ID: " + instructorID);
        System.out.println("Name: " + getFullName());
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
    }
}
