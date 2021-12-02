package gr.codehub.repository.impl;

import gr.codehub.model.Customer;
import gr.codehub.repository.Repository;


import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements Repository<Customer> {

    private final List<Customer> customers;
    private static int customerCount;

    public CustomerRepositoryImpl(){
        customers = new ArrayList<>();
    }

    @Override
    public int create(Customer customer){
        customers.add(customer);
        customerCount++;
        customer.setId(customerCount);
        return customerCount;
    }

    @Override
    public Customer read(int customerId){
        for(Customer customer: customers)
            if (customer.getId()==customerId)
                return customer;
        return null;
    }
    @Override
    public List<Customer> read(){
        return customers;
    }

    @Override
    public void update(int customerId, Customer customer){
        Customer dbCustomer = read(customerId);
        if (dbCustomer == null)
            return;
        dbCustomer.setAddress(customer.getAddress());
        dbCustomer.setBalance(customer.getBalance());
    }

    @Override
    public boolean delete(int customerId) {
        Customer dbCustomer = read(customerId);
        if (dbCustomer == null)
            return false;
        customers.remove(dbCustomer);
        return true;
    }


}
