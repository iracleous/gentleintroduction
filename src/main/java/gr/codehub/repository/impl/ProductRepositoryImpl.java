package gr.codehub.repository.impl;

import gr.codehub.model.Product;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

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
        tList.clear();
        try(Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");

                int id = Integer.parseInt(words[0]);
                String name = words[1];
                BigDecimal price = null;
                if (!"null".equals(words[2])) price = new BigDecimal(words[2].trim());
                Product product = new Product();
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                tList.add(product);
            }
        }
    }

}
