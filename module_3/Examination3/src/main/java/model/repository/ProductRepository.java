package model.repository;

import model.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

public class ProductRepository {
    BaseRepository baseRepository = new BaseRepository(); // tạo đối tượng

    final String SELECT_ALL_PRODUCT = "select* from product  ;"; // hiển thị danh sách
    final String INSERT_PRODUCT_SQL = "insert into product(product_name,\n" +
            "price,\n" +
            "quantity,\n" +
            "color," +
            "description,\n" +
            "category)" +
            " values(?,?,?,?,?,?);";

    final String SELECT_PRODUCT_BY_NAME = "select * from product where product_name like ?"; // tìm kiếm theo tên
    final String DELETE_PRODUCT_SQL = "delete from product where product_id = ?;";
    final String UPDATE_PRODUCT_SQL = "update product set product_name =?,\n" +
            "price =?,\n" +
            "quantity=? ,\n" +
            "color=? , `description`=?,\n" +
            "category =? where product_id = ?;";
    final String SELECT_PRODUCT_BY_ID = "select * from product where product_id =?";

    public List<Product> findByAll() {
        // kết nối database => lấy lại cái danh sách
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<Product> productList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("product_id");
                String name = resultSet.getString("product_name");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");


                Product product = new Product(id, name,price,quantity,color,description,category);
                productList.add(product);

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;

    }

    public boolean add(Product product) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getCategory());

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check;
    }

    public List<Product> findByName(String name) {
        Connection connection = baseRepository.getConnection();

        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");

                String name1 = resultSet.getString("product_name");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");

//                product_name ,
//                        price ,
//                        quantity ,
//                        color , `description`,
//                category
                Product product = new Product(id,name1,price,quantity,color,description,category);
                productList.add(product);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;

    }

    public boolean remove(int id) {
        boolean check = false;
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }

    public boolean update(int id, Product product) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL); // update sử dụng set

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getCategory());

            preparedStatement.setInt(7, id);// truyền tham số id

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }

    public Product findById(int id) {
        Connection connection = baseRepository.getConnection();
        Product product = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id); // thêm giá trị cho dấu ? của id
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id2 = resultSet.getInt("product_id");
                String name1 = resultSet.getString("product_name");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");


                product = new Product(id2,name1,price,quantity,color,description,category);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;

    }

}
