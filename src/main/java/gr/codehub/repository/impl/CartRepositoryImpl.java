package gr.codehub.repository.impl;

import gr.codehub.model.Cart;
import gr.codehub.model.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CartRepositoryImpl extends RepositoryImpl<Cart>{

    @Override
    public boolean update(int id, Cart cart) {
        return false;
    }


    @Override
    public void load(String filename) throws IOException {
            throw new IOException();
    }

    public BigDecimal getTotal(int cartId) {
        try {
            Cart cartFromDb = read(cartId);
            BigDecimal total = new BigDecimal("0");
            for (Product product : cartFromDb.getProducts()) {
                total = total.add(product.getPrice());
            }
            return total;
        } catch (Exception e) {
            return new BigDecimal("0");
        }
    }
}
