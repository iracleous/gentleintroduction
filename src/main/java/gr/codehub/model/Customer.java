package gr.codehub.model;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Customer extends Person{

    private BigDecimal balance;

}