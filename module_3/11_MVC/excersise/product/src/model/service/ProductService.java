package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {
//    bao gồm các phương thức:
//    findAll(): Trả về danh sách tất cả khách hàng
//    save(): Lưu một khách hàng
//    findById(): Tìm một khách hàng theo Id
//    update(): Cập nhật thông tin của một khách hàng
//    remove(): Xoá một khách hàng khỏi danh sách

    List<Product> findAll();

    void save(Product product);

    Product findById(int Id);

    void update(int id, Product product);

    void remove(int id);
}
