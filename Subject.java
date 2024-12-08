import java.util.Random;

public class Subject {
    private String subjectCode;
    private String subjectTitle;
    private String subjectDescription;

    public Subject(String subjectTitle, String subjectDescription) {
        this.subjectCode = generateSubjectCode();
        this.subjectTitle = subjectTitle;
        this.subjectDescription = subjectDescription;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    private String generateSubjectCode() {
        Random rand = new Random();
        return "SUB-" + (rand.nextInt(9000) + 1000);
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public void displayInfo() {
        System.out.println("Subject Code: " + subjectCode);
        System.out.println("Title: " + subjectTitle);
        System.out.println("Description: " + subjectDescription);
    }
}
