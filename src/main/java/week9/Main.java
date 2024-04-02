package week9;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StudentRepository s = new StudentRepository();

        s.add(new Student("First1", "Last1", LocalDate.of(2001, 3, 1), Gender.M, "1990123456789"));
        s.add(new Student("First2", "Last2", LocalDate.of(1999, 3, 1), Gender.F, "1991123456789"));
        s.add(new Student("First3", "Last3", LocalDate.of(1975, 3, 1), Gender.M, "1992123456789"));
        s.add(new Student("First4", "Last4", LocalDate.of(1998, 5, 7), Gender.F, "1993123456789"));
        s.add(new Student("First5", "Last5", LocalDate.of(2004, 3, 1), Gender.M, "1994123456789"));

        // students ordered by lastname/birthday
        final List<Student> students = s.listStudents();
        System.out.println(students);

        // students by age
        final List<Student> byAge = s.getByAge(25);
        System.out.println(byAge);

        // removing a student
        s.remove("1992123456789");
        final List<Student> studentsAfterRemoval = s.listStudents();
        System.out.println(studentsAfterRemoval);
    }
}
