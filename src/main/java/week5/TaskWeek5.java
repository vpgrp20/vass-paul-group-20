package week5;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

public class TaskWeek5 {
    public static void main(String[] args) {

        Person person1 = new Person("name1", 20);
        Person person2 = new Person("name2", 25);
        Person person3 = new Person("name3", 30);

        // created comparator for Person treeSet
        Comparator<Person> personComparator = Comparator
                .comparing(Person::getName)
                .thenComparing(Person::getAge);

        Set<Person> persons = new TreeSet<>(personComparator);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        // iterating through the treeSet and printing each person's name + age
        persons.forEach(System.out::println);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println();
        person1.addHobbies(List.of(
                new Hobby("cycling", 3,
                        List.of(new Address(Country.ROMANIA, "home"), new Address(Country.GERMANY, "gym"))),
                new Hobby("swimming", 2,
                        List.of(new Address(Country.FRANCE, "pool"), new Address(Country.ENGLAND, "beach")))));

        Map<Person, List<Hobby>> personHobbies = new HashMap<>();
        personHobbies.put(person1, person1.getHobbies());

        for (Person p : personHobbies.keySet()) {
            System.out.println(p + ", hobbies: ");
            personHobbies.get(p).forEach(System.out::println);
        }
    }
}
