public class Assigned {
    private String instructorID;
    private String subjectCode;

    public Assigned(String instructorID, String subjectCode) {
        this.instructorID = instructorID;
        this.subjectCode = subjectCode;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }
}

class Enrollment {
    private String studentID;
    private String subjectCode;

    public Enrollment(String studentID, String subjectCode) {
        this.studentID = studentID;
        this.subjectCode = subjectCode;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getSubjectCode() {
        return subjectCode;
    }
}
