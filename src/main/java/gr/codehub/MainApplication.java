package gr.codehub;

import gr.codehub.model.Address;
import gr.codehub.model.Customer;
import gr.codehub.model.Person;
import gr.codehub.services.Registration;
import gr.codehub.services.Validation;

import java.util.ArrayList;
import java.util.Locale;

public class MainApplication {


    public static void main(String[] args) {
        Registration registration = new Registration();
        Validation validation = new Validation();

       for(long i = 0; i <5; i++)
        {
            Customer person = new Customer();
            person.setName("Danae");
            Address address = new Address("Doridos", "7-9", 11526, "Thessaloniki");
            person.setAddress(address);


            if (validation.personValidation(person))
                registration.register(person);
        }

        registration.showPersons();


        System.out.println("Total balance of persons is "+ registration.calculateTotalBalance());

    }
}
