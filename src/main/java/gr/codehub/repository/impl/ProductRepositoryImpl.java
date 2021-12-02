package gr.codehub.repository.impl;

import gr.codehub.model.Product;
import gr.codehub.repository.Repository;

import java.util.List;

public class ProductRepositoryImpl implements Repository<Product> {

    @Override
    public int create(Product product) {
        return 0;
    }

    @Override
    public Product read(int id) {
        return null;
    }

    @Override
    public List<Product> read() {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
