package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + ", " + age + " years old";
    }
}
