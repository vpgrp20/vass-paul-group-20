package week5;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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
    }
}
