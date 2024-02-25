package week5;

import java.util.List;

public class Hobby {

    private final String name;
    private final int frequency;
    private final List<Address> addresses;

    public Hobby(String name, int frequency, List<Address> addresses) {
        this.name = name;
        this.frequency = frequency;
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Hobby: " + name;
    }
}
