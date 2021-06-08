package model.repository;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    BaseRepository baseRepository = new BaseRepository(); // tạo đối tượng

    final String SELECT_ALL_CUSTOMER = "select* from customer  ;"; // hiển thị danh sách
    final String INSERT_CUSTOMER_SQL = "insert into customer(type_customer_id,customer_name, gender,birthday, id_card, phone, email, address)" +
            " values(?,?,?,?,?,?,?,?);";
    final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name like ?"; // tìm kiếm theo tên
    final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    final String UPDATE_CUSTOMER_SQL = "update customer set type_customer_id = ?,customer_name=?, gender=?,birthday=?, id_card=?, phone=?, " +
            "email=?, address=? where customer_id = ?;";
    final String SELECT_USER_BY_ID = "select * from customer where customer_id =?";
    final String SELECT_TYPE_CUSTOMER = "select* from customer_type;";

    public List<Customer> findByAll() {
        // kết nối database => lấy lại cái danh sách
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<Customer> userList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("customer_id");
                int id1 = resultSet.getInt("type_customer_id");
                String name = resultSet.getString("customer_name");
                String gender = resultSet.getString("gender");
                String birthday = resultSet.getString("birthday");
                String idCard = resultSet.getString("id_card");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                Customer customer = new Customer(id, id1, name, gender, birthday, idCard, phone, email, address);
                userList.add(customer);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    public List<TypeCustomer> findAllTypeCustomer() {
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<TypeCustomer> typeCustomers = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TYPE_CUSTOMER); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");

                TypeCustomer typeCustomer = new TypeCustomer(id,name);
                typeCustomers.add(typeCustomer);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeCustomers;
    }


    public boolean update(int id, Customer customer) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL); // update sử dụng set
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getGender());
            preparedStatement.setString(4, customer.getBirthday());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());

            preparedStatement.setInt(9, id);// truyền tham số id

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

        List<Customer> customerList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int id1 = resultSet.getInt("type_customer_id");
                String name1 = resultSet.getString("customer_name");
                String gender = resultSet.getString("gender");
                String birthday = resultSet.getString("birthday");
                String idCard = resultSet.getString("id_card");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                Customer customer = new Customer(id, id1, name1, gender, birthday, idCard, phone, email, address);
                customerList.add(customer);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;

    }

    public boolean add(Customer customer) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);

            preparedStatement.setInt(1, customer.getCustomerTypeId()); //thêm giá trị cho dấu ?
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getGender());
            preparedStatement.setString(4, customer.getBirthday());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());

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

    public Customer findById(int id) {
        Connection connection = baseRepository.getConnection();
        Customer customer = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id); // thêm giá trị cho dấu ? của id
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id2 = resultSet.getInt("customer_id");
                int id1 = resultSet.getInt("type_customer_id");
                String name1 = resultSet.getString("customer_name");
                String gender = resultSet.getString("gender");
                String birthday = resultSet.getString("birthday");
                String idCard = resultSet.getString("id_card");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                customer = new Customer(id2, id1, name1, gender, birthday, idCard, phone, email, address);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;

    }

}
