package gr.codehub.repository.impl;

import gr.codehub.model.Product;
import gr.codehub.repository.Repository;

import java.io.IOException;
import java.util.List;

public class ProductRepositoryImpl extends RepositoryImpl<Product> {


    @Override
    public boolean update(int productId, Product product){
        try {
            Product dbProduct = read(productId);

            dbProduct.setName(product.getName());
            dbProduct.setPrice(product.getPrice());
            return true;
        }
        catch(Exception e){
            return false;
        }
    }



    @Override
    public void load(String filename) throws IOException {
        throw new IOException();
    }

}
