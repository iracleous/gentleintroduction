package gr.codehub.repository;

import gr.codehub.model.Customer;

import java.util.ArrayList;
import java.util.List;



public interface Repository<T> {

    //CRUD

     int create(T t);
     T read(int id);
     List<T> read();
     void update(int id, T t);
     boolean delete(int id) ;
}
