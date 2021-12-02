package gr.codehub.repository.impl;

import gr.codehub.exceptions.EntityNotFoundException;
import gr.codehub.model.Customer;
import gr.codehub.model.Product;

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
}
