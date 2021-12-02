package gr.codehub.model;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Person extends  Entity{


    private String name;
    private Address address;
    private LocalDate dateOfBirth;
    private String userName;
    private String password;

    }
