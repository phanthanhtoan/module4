package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Tivi", 10000.0, 5));
        products.put(2, new Product(2, "Washing Machine", 9000.0, 10));
        products.put(3, new Product(3, "SmartPhone", 10000.0, 15));
        products.put(4, new Product(4, "Fridge", 17000.0, 7));
        products.put(5, new Product(5, "Gas Cooker", 8000.0, 9));
        products.put(6, new Product(6, "Air Conditioning", 12000.0, 12));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
