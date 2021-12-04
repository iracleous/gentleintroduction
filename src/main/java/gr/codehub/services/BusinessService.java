package gr.codehub.services;

import gr.codehub.exceptions.EntityNotFoundException;
import gr.codehub.model.Cart;
import gr.codehub.model.Customer;
import gr.codehub.model.Product;
import gr.codehub.repository.impl.CartRepositoryImpl;
import gr.codehub.repository.impl.CustomerRepositoryImpl;
import gr.codehub.repository.impl.ProductRepositoryImpl;

import java.io.IOException;
import java.math.BigDecimal;

public class BusinessService {

    private final CustomerRepositoryImpl customerRepository
            = new CustomerRepositoryImpl();

    private final ProductRepositoryImpl productRepository
            = new ProductRepositoryImpl();


    private final CartRepositoryImpl cartRepository
            = new CartRepositoryImpl();

    public void registerCustomer(Customer customer) {
        int index = customerRepository.create(customer);
        if (index == 0) {
            System.out.println("The customer was not persisted");
        }
    }

    public Customer findCustomerById(int customerId) throws EntityNotFoundException {
        return customerRepository.read(customerId);
    }

    public Product findProductById(int productId) throws EntityNotFoundException {
        return productRepository.read(productId);
    }

    public void saveCustomers(String filename) {
        try {
            customerRepository.save(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCustomers(String filename) {
        try {
            customerRepository.load(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveProducts(String filename) {
        try {
            productRepository.save(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProducts(String filename) {
        try {
            productRepository.load(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////

    public boolean createCart(Cart cart) {
        // we do not allow the creation of cart to customers with balance >100
        if (cart.getCustomer().getBalance().compareTo(new BigDecimal("100")) > 0) {
            return false;
        }
        cartRepository.create(cart);
        return true;
    }

    public BigDecimal getTotal(int cartId) {
        return cartRepository.getTotal(cartId);
    }


}
