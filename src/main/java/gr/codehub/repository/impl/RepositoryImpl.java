package gr.codehub.repository.impl;

import gr.codehub.exceptions.EntityNotFoundException;
import gr.codehub.model.Customer;
import gr.codehub.model.Entity;
import gr.codehub.repository.Repository;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class RepositoryImpl<T extends Entity> implements Repository<T> {

    protected final List<T> tList;
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
        for(T t: tList)
            if (t.getId() == id)
                return t;
        throw new  EntityNotFoundException("The item with id " + id +"is not found");
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


    @Override
    public void save(  String filename) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(filename)){
            for(Entity entity :tList){
                printWriter.println(entity.forTextFile());
            }
        }
     }








}
