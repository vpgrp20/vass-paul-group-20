package week9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentRepositoryTest {

    StudentRepository repository;

    @BeforeEach
    void setup() {
        repository = new StudentRepository();

        repository.add(new Student("First1", "Last1", LocalDate.of(2001, 3, 1), Gender.M, "1990123456789"));
        repository.add(new Student("First4", "Last4", LocalDate.of(1998, 5, 7), Gender.F, "1993123456789"));
        repository.add(new Student("First5", "Last5", LocalDate.of(2004, 3, 1), Gender.M, "1994123456789"));
        repository.add(new Student("First2", "Last2", LocalDate.of(1999, 3, 1), Gender.F, "1991123456789"));
        repository.add(new Student("First3", "Last3", LocalDate.of(1975, 3, 1), Gender.M, "1992123456789"));
    }

    @AfterEach
    void cleanup() {
        repository = null;
    }

    @Test
    void remove_shouldThrowException_WhenTryingToRemoveStudentThatIsNotInRepository() {
        repository.remove("1990123456789");

        assertThrows(NullPointerException.class, () -> repository.remove("1990123456789"));
    }

    @Test
    void getByAge_returnsCorrectNumberOfStudents() {
        int expectedStudentsAge25 = 2;

        int actualStudentsAge25 = repository.getByAge(25).size();

        assertEquals(expectedStudentsAge25, actualStudentsAge25);
    }

    @Test
    void getByAge_shouldThrowException_whenArgumentIsNegative() {
        int invalidArgument = -5;
        assertThrows(IllegalArgumentException.class, () -> repository.getByAge(invalidArgument));
    }

    @Test
    void listStudents_OrderOfStudentsIsCorrect() {
        String expectedName = "Last5";

        Student lastStudentInOrderedList = repository.listStudents().get(repository.getNumberOfStudents() - 1);

        assertEquals(expectedName, lastStudentInOrderedList.getLastName());
    }
}