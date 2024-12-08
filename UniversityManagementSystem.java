import java.util.ArrayList;
import java.util.Scanner;

public class UniversityManagementSystem {
    private static ArrayList<Instructor> instructors = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Subject> subjects = new ArrayList<>();
    private static ArrayList<Assigned> assignedSubjects = new ArrayList<>();
    private static ArrayList<Enrollment> enrolledSubjects = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n---------------Welcome to ICS University Management System---------------");
            System.out.println("\n1. Enroll Instructor");
            System.out.println("2. Enroll Student");
            System.out.println("3. Create Subject");
            System.out.println("4. Assign Subject to Instructor");
            System.out.println("5. Add Subject to Student");
            System.out.println("6. Unenroll/Reassign");
            System.out.println("7. Search Data");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addInstructor();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    addSubject();
                    break;
                case 4:
                    assignSubjectToInstructor();
                    break;
                case 5:
                    addSubjectToStudent();
                    break;
                case 6:
                    handleUnenrollReassign();
                    break;
                case 7:
                    searchData();
                    break;
                case 8:
                    System.out.println("\nExiting University Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addInstructor() {
        System.out.println("\nEnrolling Instructor");

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Middle Name (Optional): ");
        String middleName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Age (Minimum 24 years): ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (age < 24) {
            System.out.println("Age must be minimum 24 years. Instructor not added.");
            return;
        }

        Instructor instructor = new Instructor(lastName, firstName, middleName, address, age);
        instructors.add(instructor);

        System.out.println("Instructor Enrolled successfully. Instructor ID: " + instructor.getInstructorID());
    }

    private static void addStudent() {
        System.out.println("\nEnrolling Student");

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Middle Name (Optional): ");
        String middleName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Age (Minimum 17 years): ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (age < 17) {
            System.out.println("Age must be minimum 17 years. Student not added.");
            return;
        }

        Student student = new Student(lastName, firstName, middleName, address, age);
        students.add(student);

        System.out.println("Student Enrolled successfully. Student ID: " + student.getStudentID());
    }

    private static void addSubject() {
        System.out.println("\nCreating Subject");

        System.out.print("Enter Subject Title: ");
        String subjectTitle = scanner.nextLine();

        System.out.print("Enter Subject Description: ");
        String subjectDescription = scanner.nextLine();

        Subject subject = new Subject(subjectTitle, subjectDescription);
        subjects.add(subject);

        System.out.println("Subject Created successfully. Subject Code: " + subject.getSubjectCode());
    }

    private static void assignSubjectToInstructor() {
        System.out.println("\nAssigning Subject to Instructor");

        if (instructors.isEmpty() || subjects.isEmpty()) {
            System.out.println("No Instructors or Subjects available. Please add Instructors and Subjects first.");
            return;
        }

        System.out.print("Enter Instructor ID: ");
        String instructorID = scanner.nextLine();

        Instructor instructor = findInstructorById(instructorID);
        if (instructor == null) {
            System.out.println("Instructor not found with ID: " + instructorID);
            return;
        }

        System.out.print("Enter Subject Code: ");
        String subjectCode = scanner.nextLine();

        Subject subject = findSubjectByCode(subjectCode);
        if (subject == null) {
            System.out.println("Subject not found with Code: " + subjectCode);
            return;
        }

        assignedSubjects.add(new Assigned(instructorID, subjectCode));

        System.out.println(
                "Subject " + subject.getSubjectTitle() + " assigned to Instructor " + instructor.getFullName());
    }

    private static void addSubjectToStudent() {
        System.out.println("\nAdding Subject to Student");

        if (students.isEmpty() || subjects.isEmpty()) {
            System.out.println("No Students or Subjects available. Please add Students and Subjects first.");
            return;
        }

        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        Student student = findStudentById(studentID);
        if (student == null) {
            System.out.println("Student not found with ID: " + studentID);
            return;
        }

        System.out.print("Enter Subject Code: ");
        String subjectCode = scanner.nextLine();

        Subject subject = findSubjectByCode(subjectCode);
        if (subject == null) {
            System.out.println("Subject not found with Code: " + subjectCode);
            return;
        }

        enrolledSubjects.add(new Enrollment(studentID, subjectCode));

        System.out.println("Subject " + subject.getSubjectTitle() + " added to Student " + student.getFullName());
    }

    private static void searchData() {
        System.out.println("\nSearch Data");
        System.out.println("1. Search Student");
        System.out.println("2. Search Instructor");
        System.out.println("3. Search Subject");
        System.out.println("4. Back");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                searchStudent();
                break;
            case 2:
                searchInstructor();
                break;
            case 3:
                searchSubject();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void searchStudent() {
        System.out.println("\nSearch Student");

        System.out.print("\nEnter Student ID: ");
        String studentID = scanner.nextLine();

        Student student = findStudentById(studentID);
        if (student == null) {
            System.out.println("Student not found with ID: " + studentID);
            return;
        }

        System.out.println("\nStudent Details:");
        student.displayInfo();

        System.out.println("\nEnrolled Subjects:");
        for (Enrollment enrollment : enrolledSubjects) {
            if (enrollment.getStudentID().equals(studentID)) {
                Subject subject = findSubjectByCode(enrollment.getSubjectCode());
                if (subject != null) {
                    System.out.println("- " + subject.getSubjectTitle());
                }
            }
        }

        System.out.println("\nOptions:");
        System.out.println("1. Edit Data");
        System.out.println("2. Delete Data");
        System.out.println("3. Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new Last Name: ");
                student.setLastName(scanner.nextLine());

                System.out.print("Enter new First Name: ");
                student.setFirstName(scanner.nextLine());

                System.out.print("Enter new Middle Name (Optional): ");
                student.setMiddleName(scanner.nextLine());

                System.out.print("Enter new Address: ");
                student.setAddress(scanner.nextLine());

                System.out.print("Enter new Age (Minimum 17 years): ");
                int age = scanner.nextInt();
                scanner.nextLine();
                if (age < 17) {
                    System.out.println("Age must be minimum 17 years. Student not updated.");
                    return;
                }
                student.setAge(age);

                System.out.println("Student information updated successfully.");

                break;
            case 2:
                students.remove(student);
                System.out.println("Student deleted successfully.");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. No action taken.");
        }
    }

    private static void searchInstructor() {
        System.out.println("\nSearch Instructor");

        System.out.print("\nEnter Instructor ID: ");
        String instructorID = scanner.nextLine();

        Instructor instructor = findInstructorById(instructorID);
        if (instructor == null) {
            System.out.println("Instructor not found with ID: " + instructorID);
            return;
        }

        System.out.println("\nInstructor Details:");
        instructor.displayInfo();

        System.out.println("\nAssigned Subjects:");
        for (Assigned assignment : assignedSubjects) {
            if (assignment.getInstructorID().equals(instructorID)) {
                Subject subject = findSubjectByCode(assignment.getSubjectCode());
                if (subject != null) {
                    System.out.println("- " + subject.getSubjectTitle());
                }
            }
        }

        System.out.println("\nOptions:");
        System.out.println("1. Edit Data");
        System.out.println("2. Delete Data");
        System.out.println("3. Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new Last Name: ");
                instructor.setLastName(scanner.nextLine());

                System.out.print("Enter new First Name: ");
                instructor.setFirstName(scanner.nextLine());

                System.out.print("Enter new Middle Name (Optional): ");
                instructor.setMiddleName(scanner.nextLine());

                System.out.print("Enter new Address: ");
                instructor.setAddress(scanner.nextLine());

                System.out.print("Enter new Age (Minimum 24 years): ");
                int age = scanner.nextInt();
                scanner.nextLine();
                if (age < 24) {
                    System.out.println("Age must be minimum 24 years. Instructor not updated.");
                    return;
                }
                instructor.setAge(age);

                System.out.println("Instructor information updated successfully.");
                break;
            case 2:
                instructors.remove(instructor);
                System.out.println("Instructor deleted successfully.");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. No action taken.");
        }
    }

    private static void searchSubject() {
        System.out.println("\nSearch Subject");

        System.out.print("\nEnter Subject Code: ");
        String subjectCode = scanner.nextLine();

        Subject subject = findSubjectByCode(subjectCode);
        if (subject == null) {
            System.out.println("Subject not found with Code: " + subjectCode);
            return;
        }

        System.out.println("\nSubject Details:");
        subject.displayInfo();

        System.out.println("\nEnrolled Students:");
        boolean hasEnrolledStudents = false;
        for (Enrollment enrollment : enrolledSubjects) {
            if (enrollment.getSubjectCode().equals(subjectCode)) {
                Student student = findStudentById(enrollment.getStudentID());
                if (student != null) {
                    System.out.println("- " + student.getFullName());
                    hasEnrolledStudents = true;
                }
            }
        }
        if (!hasEnrolledStudents) {
            System.out.println("No students enrolled in this subject.");
        }

        System.out.println("\nAssigned Instructor:");
        boolean hasAssignedInstructor = false;
        for (Assigned assignment : assignedSubjects) {
            if (assignment.getSubjectCode().equals(subjectCode)) {
                Instructor instructor = findInstructorById(assignment.getInstructorID());
                if (instructor != null) {
                    System.out.println("- " + instructor.getFullName());
                    hasAssignedInstructor = true;
                }
            }
        }
        if (!hasAssignedInstructor) {
            System.out.println("No instructor assigned to this subject.");
        }

        System.out.println("\nOptions:");
        System.out.println("1. Edit Data");
        System.out.println("2. Delete Data");
        System.out.println("3. Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new Title: ");
                subject.setSubjectTitle(scanner.nextLine());
                System.out.print("Enter new Description: ");
                subject.setSubjectDescription(scanner.nextLine());

                System.out.println("Subject information updated successfully.");
                break;
            case 2:
                subjects.remove(subject);
                System.out.println("Subject deleted successfully.");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. No action taken.");
        }
    }

    private static void handleUnenrollReassign() {
        System.out.println("\nUnenroll/Reassign");
        System.out.println("1. Unenroll Student");
        System.out.println("2. Reassign Handled Subject");
        System.out.println("3. Back");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                unenrollStudent();
                break;
            case 2:
                reassignHandledSubject();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void unenrollStudent() {
        System.out.print("Enter Student ID to unenroll: ");
        String studentID = scanner.nextLine();

        System.out.print("Enter Subject Code to unenroll from: ");
        String subjectCode = scanner.nextLine();

        boolean found = false;
        for (Enrollment enrollment : enrolledSubjects) {
            if (enrollment.getStudentID().equals(studentID) && enrollment.getSubjectCode().equals(subjectCode)) {
                enrolledSubjects.remove(enrollment);
                found = true;
                System.out.println("Student unenrolled successfully from the subject.");
                break;
            }
        }
        if (!found) {
            System.out.println("Student not enrolled in the specified subject.");
        }
    }

    private static void reassignHandledSubject() {
        System.out.print("Enter current Instructor ID of the subject: ");
        String currentInstructorID = scanner.nextLine();

        System.out.print("Enter Subject Code to reassign: ");
        String subjectCode = scanner.nextLine();

        System.out.print("Enter new Instructor ID to assign: ");
        String newInstructorID = scanner.nextLine();

        boolean found = false;
        for (Assigned assignment : assignedSubjects) {
            if (assignment.getInstructorID().equals(currentInstructorID)
                    && assignment.getSubjectCode().equals(subjectCode)) {
                assignment.setInstructorID(newInstructorID);
                found = true;
                System.out.println("Subject reassigned successfully to the new Instructor.");
                break;
            }
        }
        if (!found) {
            System.out.println("No subject assigned to the specified Instructor with the given Subject Code.");
        }
    }

    // Utility methods for finding objects
    private static Student findStudentById(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    private static Instructor findInstructorById(String instructorID) {
        for (Instructor instructor : instructors) {
            if (instructor.getInstructorID().equals(instructorID)) {
                return instructor;
            }
        }
        return null;
    }

    private static Subject findSubjectByCode(String subjectCode) {
        for (Subject subject : subjects) {
            if (subject.getSubjectCode().equals(subjectCode)) {
                return subject;
            }
        }
        return null;
    }
}
