package gr.codehub;

import gr.codehub.exceptions.EntityNotFoundException;
import gr.codehub.model.*;
import gr.codehub.repository.impl.CartRepositoryImpl;
import gr.codehub.repository.impl.ProductRepositoryImpl;
import gr.codehub.services.BusinessService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainApplication {


    public static void main(String[] args) throws EntityNotFoundException {

        scenario3();

    }

    /**
     *
     */

    private static final int CUSTOMER_ID =1;
    private static final int PRODUCT_ID =1;
    private static final String CUSTOMERS_FILENAME ="customers.csv";
    private static final String PRODUCTS_FILENAME ="products.csv";


    public static void scenario3() throws EntityNotFoundException {
        BusinessService businessService = new BusinessService();

        businessService.loadCustomers(CUSTOMERS_FILENAME);
        businessService.loadProducts(PRODUCTS_FILENAME);

        Customer customer = businessService.findCustomerById(CUSTOMER_ID);
        Product product = businessService.findProductById(PRODUCT_ID);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setDateTime( LocalDateTime.now());

        cart.getProducts().add(product);

        businessService.createCart(cart);


        System.out.println(customer.getName() +  "   " + customer.getCategory());
        System.out.println("Total cart cost = "+ businessService.getTotal(cart.getId()));


    }




    public static void scenario2(){


        BusinessService customerService = new BusinessService();

        customerService.loadCustomers(CUSTOMERS_FILENAME);

        try {
            Customer customer = customerService.findCustomerById(1);
           System.out.println(customer.getName() + "  "+ customer.getAddress().getCity());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

    }



    public static void scenario1(){
        //GUI , front end
        Address address = new Address();
        address.setCity("Ioannina");

        Customer customer = new Customer();
        customer.setName("Eleftheria");
        customer.setAddress(address);
        customer.setCategory(CustomerCategory.PREMIUM);
        int year = 2000; int month = 8; int day =22;
        customer.setDateOfBirth(LocalDate.of(year, month, day));

        Product product = new Product();
        product.setName("potatoes");
        product.setPrice(new BigDecimal("1"));

        // initialization of services
        BusinessService customerService = new BusinessService();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        CartRepositoryImpl cartRepository = new CartRepositoryImpl();

        // dispatching of customers
        System.out.println("Customer id (before) = " + customer.getId());
        customerService.registerCustomer(customer);

        System.out.println("Customer id (after)= " + customer.getId());

        productRepository.create(product);

        Customer customerFromDb = null;

        try {
            customerFromDb = customerService.findCustomerById(1);

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



        customerService.saveCustomers("customers.csv");


        System.out.println("The application has terminated normally");
    }


}
