package gr.codehub.services;

import gr.codehub.model.Person;

import java.util.ArrayList;

public class Registration {

    private ArrayList<Person> persons = new ArrayList<>();


    public void register(Person person){
            persons.add(person);
    }


    public void hire(Person person){

    }
    public void dismiss(Person person){

    }


    public void showPersons(){
        /*
        for (int i = 0;i < persons.size(); i++){
            System.out.println(persons.get(i));
        }

        for(Person person:persons){
            System.out.println(person);
        }

        persons.forEach(person -> System.out.println(person));
*/
        persons.forEach(System.out::println);

    }






    public float calculateTotalBalance(){

        float totalBalance = 0;
//        for (int i = 0;i < persons.size(); i++){
//            totalBalance += persons.get(i).getBalance();
//        }


//  imperative programming

       for(Person person:persons){
           totalBalance += person.getBalance();
        }

       //functional programming

//        totalBalance = persons
//                .stream()
//                .map(person  -> person.getBalance())
//                .reduce(0.0f, (a,b) -> a+b);

        return totalBalance;
    }

}
