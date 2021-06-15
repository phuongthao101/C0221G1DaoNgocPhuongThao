package model.repository;

import model.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    BaseRepository baseRepository = new BaseRepository(); // tạo đối tượng

    final String SELECT_ALL_EMPLOYEE = "select* from employee  ;"; // hiển thị danh sách
    final String INSERT_EMPLOYEE_SQL = "insert into employee(name,birthday)" +
            " values(?,?);";

    final String SELECT_EMPLOYEE_BY_NAME = "select * from employee where name like ?"; // tìm kiếm theo tên
    final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    final String UPDATE_EMPLOYEE_SQL = "update employee set name=?,birthday=? where employee_id = ?;";
    final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id =?";
//    final String SELECT_TYPE_CUSTOMER = "select* from customer_type;";

    public List<Employee> findByAll()   {
        // kết nối database => lấy lại cái danh sách
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<Employee> employeeList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");


                Employee employee = new Employee(id, name,  birthday);
                employeeList.add(employee);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;

    }

    public boolean update(int id, Employee employee) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL); // update sử dụng set

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setInt(3, id);// truyền tham số id

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }

    public List<Employee> findByName(String name) {
        Connection connection = baseRepository.getConnection();

        List<Employee> customerList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name1 = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                Employee employee = new Employee(id, name1,  birthday);
                customerList.add(employee);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;

    }

    public boolean create(Employee employee) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());


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
            preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }

    public Employee findById(int id) {
        Connection connection = baseRepository.getConnection();
        Employee employee = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id); // thêm giá trị cho dấu ? của id
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("employee_id");
                String name1 = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                employee = new Employee(id1,name1,birthday);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;

    }
}
