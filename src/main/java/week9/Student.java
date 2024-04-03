package week9;

import java.time.LocalDate;
import java.time.Period;

public class Student {

    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Gender gender;
    private final String cnp;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, String cnp) {
        this.firstName = validateName(firstName);
        this.lastName = validateName(lastName);
        this.dateOfBirth = validateAge(dateOfBirth);
        this.gender = gender;
        this.cnp = validateCnp(cnp);
    }

    private String validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        return name;
    }

    private LocalDate validateAge(LocalDate dateOfBirth) {
        if (dateOfBirth.getYear() < 1900) {
            throw new IllegalArgumentException("Year of birth cannot be earlier than 1900");
        }

        if (Period.between(dateOfBirth, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Student must be at least 18 years old");
        }

        return dateOfBirth;
    }

    private String validateCnp(String cnp) {

        if (cnp.length() != 13) {
            throw new IllegalArgumentException("CNP must be 13 characters long");
        }

        if (!cnp.startsWith("1") && !cnp.startsWith("2")) {
            throw new IllegalArgumentException("Invalid CNP");
        }

        try {
            Long.parseLong(cnp);
        } catch (NumberFormatException e) {
            throw new RuntimeException("CNP must only contain numbers");
        }

        return cnp;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCnp() {
        return cnp;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + gender + ", " + getAge() + " years old";
    }
}
