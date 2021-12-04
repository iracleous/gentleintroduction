package gr.codehub;

import gr.codehub.model.Address;
import gr.codehub.model.Cart;
import gr.codehub.model.Customer;
import gr.codehub.model.Product;
import gr.codehub.repository.impl.CartRepositoryImpl;
import gr.codehub.repository.impl.ProductRepositoryImpl;
import gr.codehub.services.CustomerService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MainApplication {


    public static void main(String[] args) {


        //GUI , front end
        Address address = new Address();
        address.setCity("Ioannina");

        Customer customer = new Customer();
        customer.setName("Eleftheria");
        customer.setAddress(address);

        Product product = new Product();
        product.setName("potatoes");
        product.setPrice(new BigDecimal("1"));

        // initialization of services
        CustomerService customerService = new CustomerService();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        CartRepositoryImpl cartRepository = new CartRepositoryImpl();

        // dispatching of customers
        System.out.println("Customer id (before) = " + customer.getId());
        customerService.register(customer);

        System.out.println("Customer id (after)= " + customer.getId());

        productRepository.create(product);

        Customer customerFromDb = null;

        try {
            customerFromDb = customerService.findById(1);

            System.out.println(customerFromDb.getName());
            System.out.println(customerFromDb.getAddress());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


       // cart creation process

        Cart cart = new Cart();
        cart.setCustomer(customerFromDb);
        cart.setDateTime( LocalDateTime.now());

        cart.getProducts().add(product);

        cartRepository.create(cart);

        System.out.println("Total cart cost = "+ cartRepository.getTotal(cart.getId()));



        customerService.save("customers.csv");


        System.out.println("The application has terminated normally");
    }
}
