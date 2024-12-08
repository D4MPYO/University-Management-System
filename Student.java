import java.util.Random;

public class Student extends Details {
    private String studentID;

    public Student(String lastName, String firstName, String middleName, String address, int age) {
        super(lastName, firstName, middleName, address, age);
        this.studentID = generateStudentID();
    }

    public String getStudentID() {
        return studentID;
    }

    private String generateStudentID() {
        Random rand = new Random();
        return "ST" + (+24) + "-" + (rand.nextInt(9000) + 1000);
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + getFullName());
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
    }
}
