package week9;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {

    @Test
    void getAge_calculatesAgeCorrectly() {
        Student s = new Student("A", "B", LocalDate.of(2000, 1, 1), Gender.M, "1234567890123");

        int expectedAge = 24;

        assertEquals(expectedAge, s.getAge());
    }

    @Test
    void shouldThrowException_whenFirstNameIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("", "B", LocalDate.of(2000, 1, 1), Gender.M, "1234567890123"));
    }

    @Test
    void shouldThrowException_whenLastNameIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("A", "", LocalDate.of(2000, 1, 1), Gender.M, "1234567890123"));
    }

    @Test
    void shouldThrowException_whenYearOfBirthBefore1900() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("A", "B", LocalDate.of(1899, 12, 31), Gender.M, "1234567890123"));
    }

    @Test
    void shouldThrowException_whenStudentIsYoungerThan18() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("A", "B", LocalDate.of(2006, 12, 31), Gender.M, "1234567890123"));
    }

    @Test
    void shouldThrowException_whenCnpDoesNotStartWith_1or2() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("A", "B", LocalDate.of(2000, 1, 1), Gender.M, "3234567890123"));
    }

    @Test
    void shouldThrowException_whenCnpIsNot13CharactersLong() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("A", "B", LocalDate.of(2000, 1, 1), Gender.M, "123456789012"));
    }

    @Test
    void shouldThrowException_whenCnpContainsCharactersOtherThanDigits() {
        assertThrows(RuntimeException.class,
                () -> new Student("A", "B", LocalDate.of(2000, 1, 1), Gender.M, "2904WXYZa0#!_"));
    }
}