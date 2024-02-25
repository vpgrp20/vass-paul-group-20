package week5;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;
    private final int age;
    private final List<Hobby> hobbies = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addHobbies(List<Hobby> hobbyList) {
        hobbies.addAll(hobbyList);
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", " + age + " years old";
    }
}
