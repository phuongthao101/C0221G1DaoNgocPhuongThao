package com.codegym.model.service.impl;

import com.codegym.model.bean.Product;
import com.codegym.model.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {

    //    id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất.
    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Iphone5", 1000,"black","iphone"));
        products.put(2,new Product(2,"Sam sung note 10", 2000,"red","samsung"));
        products.put(3,new Product(3,"Iphone 7", 500,"white","iphone"));
        products.put(4,new Product(4,"Sam sung galaxy 10", 2500,"black","samsung"));

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
        products.put(id,product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }
    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        Set<Integer> setKey = products.keySet();
        for(int key : setKey){
            if(products.get(key).getName().contains(name)){
                productList.add(products.get(key));
            }
        }
        return productList;
    }
}
