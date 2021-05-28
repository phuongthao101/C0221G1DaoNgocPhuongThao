package model.repository;

import model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private static Map<Integer, Product> map = new HashMap<>();

    static {

        map.put(1, new Product(1, "SP1", 200, "black", "iphone"));
        map.put(2, new Product(2, "SP2", 200, "black", "iphone"));
        map.put(3, new Product(3, "SP3", 200, "black", "iphone"));
        map.put(4, new Product(4, "SP4", 200, "black", "iphone"));

    }

    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }


    public void save(Product product) {
        map.put(product.getId(), product); // add đối tượng vào bộ nhớ
    }


    public Product findById(int id) {
        return map.get(id);
    }


    public void update(int id, Product product) {
        map.put(id, product);
    }


    public void remove(int id) {
        map.remove(id);
    }
}
