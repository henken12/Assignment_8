package Assigment8;

import java.util.ArrayList;
import java.util.List;

public class MyPersonList {
    private List<Person> personList;

    public MyPersonList() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person p) {
        personList.add(p);
    }

    public Person getPerson(int index) {
        if (index >= 0 && index < personList.size()) {
            return personList.get(index);
        }
        return null; // or throw an exception
    }

    public Person searchByLastName(String lastName) {
        for (Person p : personList) {
            if (p.getLast().equals(lastName)) {
                return p;
            }
        }
        return null;
    }

    public boolean removePerson(Person p) {
        return personList.remove(p);
    }




    public static void main(String[] args) {
        MyPersonList list = new MyPersonList();
        list.addPerson(new Person("Smith", "John", 30));
        list.addPerson(new Person("Doe", "Jane", 25));

        Person foundPerson = list.searchByLastName("Doe");
        if (foundPerson != null) {
            System.out.println("Found person: " + foundPerson);
        } else {
            System.out.println("Person not found.");
        }
    }
}


class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String last, String first, int a) {
        lastName = last;
        firstName = first;
        age = a;
    }

    public String getLast() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person [LastName=" + lastName + "\n FirstName=" + firstName + "\nAge=" + age + "]";
    }
}
