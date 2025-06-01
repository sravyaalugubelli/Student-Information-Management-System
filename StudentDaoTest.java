import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOTest {

    StudentDAO dao = new StudentDAO();

    @Test
    public void testAddAndGetAllStudents() throws SQLException {
        Student student = new Student(101, "John Doe", "john@example.com");
        dao.addStudent(student);

        List<Student> students = dao.getAllStudents();
        assertTrue(students.stream().anyMatch(s -> s.getId() == 101));
    }
}
