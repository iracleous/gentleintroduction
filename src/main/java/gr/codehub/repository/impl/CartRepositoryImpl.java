package gr.codehub.repository.impl;

import gr.codehub.model.Cart;
import gr.codehub.model.Product;

import java.math.BigDecimal;

public class CartRepositoryImpl extends RepositoryImpl<Cart>{

    @Override
    public boolean update(int id, Cart cart) {
        return false;
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
