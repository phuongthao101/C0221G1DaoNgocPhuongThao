package model.repository;

import model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    BaseRepository baseRepository = new BaseRepository(); // tạo đối tượng

    final String SELECT_ALL_CUSTOMER = "select* from customer  ;"; // hiển thị danh sách
    final String INSERT_CUSTOMER_SQL = "insert into customer(type_customer_id,customer_name, gender,birthday, id_card, phone, email, address)" +
            " values(?,?,?,?,?,?,?,?);";
    final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name like ?"; // tìm kiếm theo tên
    final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    final String UPDATE_CUSTOMER_SQL = "update customer set type_customer_id = ?,customer_name=?, gender=?,birthday=?, id_card=?, phone=?, " +
            "email=?, address=? where customer_id = ?;";


    public List<Customer> findByAll() {
        // kết nối database => lấy lại cái danh sách
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<Customer> userList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String gender = resultSet.getString("gender");
                String birthday = resultSet.getString("birthday");
                String idCard = resultSet.getString("id_card");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                Customer customer = new Customer(id, name, gender, birthday, idCard, phone, email, address);
                userList.add(customer);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    public boolean update(Customer customer) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL); // update sử dụng set
            preparedStatement.setInt(1, customer.getCustomer_type_id());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setString(3, customer.getCustomer_gender());
            preparedStatement.setString(4, customer.getCustomer_birthday());
            preparedStatement.setString(5, customer.getCustomer_id_card());
            preparedStatement.setString(6, customer.getCustomer_phone());
            preparedStatement.setString(6, customer.getCustomer_email());
            preparedStatement.setString(6, customer.getCustomer_address());

            preparedStatement.setInt(7, customer.getCustomer_id());

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }

    public List<Customer> findByName(String name) {
        Connection connection = baseRepository.getConnection();

        List<Customer> userList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String name1 = resultSet.getString("customer_name");
                String gender = resultSet.getString("gender");
                String birthday = resultSet.getString("birthday");
                String idCard = resultSet.getString("id_card");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                Customer customer = new Customer(id, name1, gender, birthday, idCard, phone, email, address);
                userList.add(customer);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    public boolean add(Customer customer) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);

            preparedStatement.setInt(1, customer.getCustomer_type_id());
            preparedStatement.setString(2, customer.getCustomer_name());
            preparedStatement.setString(3, customer.getCustomer_gender());
            preparedStatement.setString(4, customer.getCustomer_birthday());
            preparedStatement.setString(5, customer.getCustomer_id_card());
            preparedStatement.setString(6, customer.getCustomer_phone());
            preparedStatement.setString(6, customer.getCustomer_email());
            preparedStatement.setString(6, customer.getCustomer_address());

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return check;
    }

    public boolean remove(int id) {
        boolean check = false;
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }

}
