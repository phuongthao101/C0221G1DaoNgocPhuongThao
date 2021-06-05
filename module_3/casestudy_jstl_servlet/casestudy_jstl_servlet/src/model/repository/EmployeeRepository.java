package model.repository;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository(); // tạo đối tượng
    final String SELECT_ALL_EMPLOYEE = "select* from employee  ;"; // hiển thị danh sách

    private final String INSERT_EMPLOYEE = "insert into employee(employee_name, employee_birthday, employee_id_card, " +
            "employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id," +
            " division_id, username) " +
            "values (?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?)";

    final String SELECT_POSITION = "select* from position;";
    final String SELECT_EDUCATION_DEGREE = "select* from education_degree;";
    final String SELECT_DIVISION = "select* from division;";
    final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?;";
    final String SELECT_EMPLOYEE_BY_NAME = "select * from employee where employee_name like ?"; // tìm kiếm theo tên

    final String UPDATE_EMPLOYEE_SQL = " update employee set employee_name=?, employee_birthday=?, employee_id_card=?, \n" +
            "\temployee_salary=?, employee_phone=?, employee_email=?, employee_address=?,\n" +
            "           position_id=?, education_degree_id=?,\n" +
            "                    division_id=?, username=? \n" +
            "             where employee_id = ?;";

    final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id =?";


    public List<Employee> findAllEmployee() {
        // kết nối database => lấy lại cái danh sách
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<Employee> employeeList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getInt("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username = resultSet.getString("username");


                Employee employee = new Employee(id, name, birthday, employee_id_card, employee_salary, phone, employee_email, address, position_id,
                        education_degree_id, division_id, username);
                employeeList.add(employee);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;

    }

    public List<Position> findAllPosition() {
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<Position> positionList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("position_id");
                String name = resultSet.getString("position_name");

                Position position = new Position(id, name);
                positionList.add(position);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    public List<EducationDegree> findAllEducation() {
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<EducationDegree> degreeList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EDUCATION_DEGREE); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("education_degree_id");
                String name = resultSet.getString("education_degree_name");

                EducationDegree degree = new EducationDegree(id, name);
                degreeList.add(degree);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return degreeList;
    }

    public List<Division> findAllDivision() {
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<Division> divisionList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIVISION); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("division_id");
                String name = resultSet.getString("division_name");

                Division division = new Division(id, name);
                divisionList.add(division);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
    }

    public boolean create(Employee employee) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);

            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8, employee.getPosition_id());
            preparedStatement.setInt(9, employee.getEducation_degree_id());
            preparedStatement.setInt(10, employee.getDivision_id());
            preparedStatement.setString(11, employee.getUsername());


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
            preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
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

        List<Employee> employeeList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("employee_id");
                String name1 = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getInt("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                Employee employee = new Employee(id, name1, birthday, employee_id_card, employee_salary, phone, employee_email, address, position_id,
                        education_degree_id, division_id, username);
                employeeList.add(employee);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;

    }
//    final String UPDATE_EMPLOYEE_SQL = " update employee set employee_name=?, employee_birthday=?, employee_id_card=?, \n" +
//            "\temployee_salary=?, employee_phone=?, employee_email=?, employee_address=?,\n" +
//            "           position_id=?, education_degree_id=?,\n" +
//            "                    division_id=?, username=? \n" +
//            "             where employee_id = ?;";
    public boolean update(int id, Employee employee) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL); // update sử dụng set
            preparedStatement.setString(1, employee.getEmployee_name());
            preparedStatement.setString(2, employee.getEmployee_birthday());
            preparedStatement.setString(3, employee.getEmployee_id_card());
            preparedStatement.setDouble(4, employee.getEmployee_salary());
            preparedStatement.setString(5, employee.getEmployee_phone());
            preparedStatement.setString(6, employee.getEmployee_email());
            preparedStatement.setString(7, employee.getEmployee_address());
            preparedStatement.setInt(8, employee.getPosition_id());
            preparedStatement.setInt(9, employee.getEducation_degree_id());
            preparedStatement.setInt(10, employee.getDivision_id());
            preparedStatement.setString(11, employee.getUsername());

            preparedStatement.setInt(12, id);

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
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("employee_id");
                String name1 = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                double employee_salary = resultSet.getInt("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
                String username = resultSet.getString("username");

                employee = new Employee(id1,name1,birthday,employee_id_card,employee_salary,
                        phone,employee_email,address,position_id,education_degree_id,division_id,username);

            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;

    }
}
