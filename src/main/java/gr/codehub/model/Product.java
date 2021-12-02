package gr.codehub.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product extends Entity{


    private String name;
    private BigDecimal price;
}
