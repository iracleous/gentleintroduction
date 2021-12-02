package gr.codehub.services;

import gr.codehub.model.Person;

import java.util.Locale;

public class Validation {


    public boolean personValidation (Person person){

        if (person.getName() == null   || person.getName().trim().equals("")) {
            System.out.println("No name was given");
            return false;
        }
//athens -> 10, thessaloniki ->50, elsewhere ->70

//        if (person.getAddress() == null || person.getAddress().getCity() == null
//                || person.getAddress().getCity().trim().equals(""))
//            return false;
//        else if (person.getAddress().getCity().toLowerCase(Locale.ROOT).equals("athens"))
//            person.setBalance(person.getBalance() + 10);
//        else if (person.getAddress().getCity().toLowerCase(Locale.ROOT).equals("thessaloniki"))
//            person.setBalance(person.getBalance() + 50);
//        else
//            person.setBalance(person.getBalance() + 70);

        return true;
    }

}
