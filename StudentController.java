import java.util.List;
import java.util.Scanner;

public class StudentController {
    private StudentDAO dao = new StudentDAO();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("\n1. Add Student\n2. View All Students\n3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    private void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Student student = new Student(id, name, email);
        try {
            dao.addStudent(student);
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private void viewStudents() {
        try {
            List<Student> students = dao.getAllStudents();
            for (Student s : students) {
                System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Email: " + s.getEmail());
            }
        } catch (Exception e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
    }
}
