package com.codegym.model.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
    private boolean checkItemInCart(Product product){


    }
}
