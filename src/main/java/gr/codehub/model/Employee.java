package gr.codehub.model;

import lombok.Data;

import java.util.Date;

@Data
public class Employee extends Person{
    private String speciality;
    private Date hireDate;
    private char department;

}
