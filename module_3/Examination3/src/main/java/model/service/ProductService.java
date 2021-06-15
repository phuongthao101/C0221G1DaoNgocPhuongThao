package model.service;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {

    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findByAll() {
        return productRepository.findByAll();
    }

    @Override
    public boolean add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public boolean remove(int id) {
        return productRepository.remove(id);
    }

    @Override
    public boolean update(int id, Product product) {
        return productRepository.update(id,product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
