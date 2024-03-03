package week5;

public class Address {

    private final Country country;
    private final String location;

    public Address(Country country, String location) {
        this.country = country;
        this.location = location;
    }

    @Override
    public String toString() {
        return country.toString();
    }
}
