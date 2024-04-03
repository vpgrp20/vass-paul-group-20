package week9;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {

    private final Map<String, Student> students = new HashMap<>();

    public void add(Student student) {
        students.put(student.getCnp(), student);
    }

    public void remove(String cnp) {
        if (students.get(cnp) == null) {
            throw new NullPointerException("ID is empty");
        }

        Student s = students.remove(cnp);

        if (s == null) {
            throw new NullPointerException("Student does not exist");
        }
    }

    public List<Student> getByAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        return students.values()
                .stream()
                .filter(student -> student.getAge() == age)
                .toList();
    }

    public List<Student> listStudents() {
        Comparator<Student> c = Comparator.comparing(Student::getLastName)
                .thenComparing(Student::getAge);

        return students.values()
                .stream()
                .sorted(c)
                .toList();
    }

    public int getNumberOfStudents() {
        return students.size();
    }
}
