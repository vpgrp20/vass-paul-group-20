package week4;

public class Contact {

    private String contactNumber;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    public Contact(String contactNumber, String phoneNumber, String firstName, String lastName) {
        this.contactNumber = contactNumber;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return contactNumber + ". " + firstName + " " + lastName + ", " + phoneNumber;
    }
}
