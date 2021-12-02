package gr.codehub.services;

import gr.codehub.exceptions.EntityNotFoundException;
import gr.codehub.model.Customer;
import gr.codehub.repository.impl.CustomerRepositoryImpl;

public class CustomerService {

    private CustomerRepositoryImpl customerRepository
            = new CustomerRepositoryImpl();


    public void register(Customer customer) {
        int index = customerRepository.create(customer);
        if (index == 0) {
            System.out.println("The customer was not persisted");
        }
    }


    public Customer findById(int customerId) throws EntityNotFoundException {

            return customerRepository.read(customerId);

    }
}
