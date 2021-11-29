package gr.codehub.model;


import lombok.Data;

@Data
public class Person {

    private String name;
    private int age;
    private Address address;
    private String speciality;

    private  boolean hired;
    private byte status;
    private char department;
    private short code;
    private int registrationId;
    private long identifier;
    private float balance;
    private double dBalance;

}
