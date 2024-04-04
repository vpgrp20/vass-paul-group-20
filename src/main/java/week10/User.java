package week10;

import java.time.LocalDate;

public class User {

    private final String firstName;
    private final String lastName;
    private final LocalDate dob;

    public User(String firstName, String lastName, String[] dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = parseDoB(dateOfBirth);
    }

    private LocalDate parseDoB(String[] dateOfBirth) {
        int day = Integer.parseInt(dateOfBirth[0]);
        int month = Integer.parseInt(dateOfBirth[1]);
        int year = Integer.parseInt(dateOfBirth[2]);

        return LocalDate.of(year, month, day);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
