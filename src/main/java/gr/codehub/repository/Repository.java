package gr.codehub.repository;

import gr.codehub.exceptions.EntityNotFoundException;

import java.util.List;



public interface Repository<T> {

    //CRUD

     int create(T t);
     T read(int id) throws EntityNotFoundException;
     List<T> read();
     boolean update(int id, T t);
     boolean delete(int id) ;
}
