package gr.codehub.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Cart {
    private int id;
    private LocalDateTime dateTime;
    private Customer customer;
    private List<Product> products;
    private Employee helpingEmployee;

}
