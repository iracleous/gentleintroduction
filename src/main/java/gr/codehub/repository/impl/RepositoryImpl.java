package gr.codehub.repository.impl;

import gr.codehub.exceptions.EntityNotFoundException;
import gr.codehub.model.Customer;
import gr.codehub.model.Entity;
import gr.codehub.repository.Repository;


import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryImpl<T extends Entity> implements Repository<T> {

    private final List<T> tList;
    private static int tCount;

    public RepositoryImpl(){
        tList = new ArrayList<>();
    }

    @Override
    public int create(T t){
        tList.add(t);
        tCount++;
        t.setId(tCount);
        return tCount;
    }

    @Override
    public T read(int id) throws EntityNotFoundException{
        for(T customer: tList)
            if (customer.getId() == id)
                return customer;
        throw new  EntityNotFoundException("The customer with id " + id +"is not found");
    }


    @Override
    public List<T> read(){
        return tList;
    }



    @Override
    public boolean delete(int id) {
        try{
            T dbCustomer = read(id);
             tList.remove(dbCustomer);
            return true;
        }
        catch(EntityNotFoundException e){
            return false;
        }
    }


}
