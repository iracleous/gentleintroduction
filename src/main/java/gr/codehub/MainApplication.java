package gr.codehub;

import gr.codehub.model.Address;
import gr.codehub.model.Person;
import gr.codehub.services.Registration;
import gr.codehub.services.Validation;

import java.util.Locale;

public class MainApplication {


    public static void main(String[] args) {
        Person person = new Person();
        Registration registration = new Registration();
        Validation validation = new Validation();

        if (validation.personValidation(person))
            registration.register(person);
    }


    public static void test1() {
        Person person = new Person();
        Person otherPerson = new Person();
        otherPerson.setName("Danae");

        Address address = new Address("Doridos", "7-9", 11526, "Athens");

        otherPerson.setAddress(address);

        otherPerson.setAge(20);
        System.out.println("hello " + otherPerson);

        Person thirdPerson = otherPerson;
        thirdPerson.setAge(21);
        System.out.println("hello " + otherPerson);

        System.out.println("hello " + person);

        System.out.println("hello " + thirdPerson);
    }

}
