package gr.codehub.repository.impl;

import gr.codehub.exceptions.EntityNotFoundException;
import gr.codehub.model.Address;
import gr.codehub.model.Customer;
import gr.codehub.model.CustomerCategory;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer>{
    @Override
    public boolean update(int customerId, Customer customer){
       try {
           Customer dbCustomer = read(customerId);

           dbCustomer.setAddress(customer.getAddress());
           dbCustomer.setBalance(customer.getBalance());
           return true;
       }
       catch (EntityNotFoundException exception){
          return false;
       }

    }


    @Override
    public void load(String filename) throws IOException, NumberFormatException, DateTimeParseException {
        tList.clear();
        try(Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");

                int id = Integer.parseInt(words[0]);
                String name = words[1];
                Address address = new Address();
                address.setCity(words[2]);
                LocalDate dateOfBirth = null;
                if (!"null".equals(words[3])) {
                    dateOfBirth = LocalDate.parse(words[3]);
                }
                String userName = words[4];
                String password = words[5];

                BigDecimal balance = new BigDecimal("0");
                if (!"null".equals(words[6])) balance = new BigDecimal(words[6]);

                CustomerCategory category = CustomerCategory.valueOf(words[7]);

                Customer customer = new Customer();

                customer.setId(id);
                customer.setName(name);
                customer.setAddress(address);
                customer.setDateOfBirth(dateOfBirth);
                customer.setUserName(userName);
                customer.setPassword(password);
                customer.setBalance(balance);
                customer.setCategory(category);

                tList.add(customer);
            }
        }
    }



}
