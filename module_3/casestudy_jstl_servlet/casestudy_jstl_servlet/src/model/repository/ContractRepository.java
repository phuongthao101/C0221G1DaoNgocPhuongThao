package model.repository;

import model.bean.contract.Contract;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    BaseRepository baseRepository = new BaseRepository(); // tạo đối tượng


    final String SELECT_ALL_CONTRACT= "select* from contract  ;"; // hiển thị danh sách
    private final String INSERT_CONTRACT = "insert into contract (start_date, end_date, deposit, total_money, employee_id,customer_id, service_id)\n" +
            "values\n" +
            " (?,?,?,?,?,?,?);";

    final String SELECT_ALL_EMPLOYEE = "select* from employee  ;"; // hiển thị danh sách

    final String SELECT_ALL_CUSTOMER = "select* from customer  ;"; // hiển thị danh sách

    final String SELECT_ALL_SERVICE = "select* from service  ;"; // hiển thị danh sách


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

    public List<Service> findAllService() {
        // kết nối database => lấy lại cái danh sách
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<Service> serviceList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getInt("service_cost");
                int rent_type_id = resultSet.getInt("rent_type_id");
                int service_max_people = resultSet.getInt("service_max_people");
                int service_type_id = resultSet.getInt("service_type_id");
                String standard_room = resultSet.getString("standard_room");
                String description_other_convenience = resultSet.getString("description_other_convenience");
                String pool_area = resultSet.getString("pool_area");
                String number_of_floors = resultSet.getString("number_of_floors");


                Service service = new Service(id, name, area, cost, rent_type_id, service_type_id, service_max_people, standard_room, description_other_convenience, pool_area, number_of_floors);
                serviceList.add(service);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;

    }

    public List<Contract> findAllContract() {
        // kết nối database => lấy lại cái danh sách
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<Contract> contractList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("contract_id");
               String start_date = resultSet.getString("start_date");
              String end_date = resultSet.getString("end_date");
               int deposit = resultSet.getInt("deposit");
                int total_money = resultSet.getInt("total_money");
                int employee_id = resultSet.getInt("employee_id");
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");


//                start_date, end_date, deposit, total_money, employee_id,customer_id, service_id
                Contract contract = new Contract(id,start_date,end_date,deposit,total_money,employee_id,customer_id,service_id);

                contractList.add(contract);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;

    }

    public boolean create(Contract contract) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT);


            preparedStatement.setString(1,contract.getStartDate());
            preparedStatement.setString(2,contract.getEndDate());
            preparedStatement.setInt(3,contract.getDeposit());
            preparedStatement.setInt(4,contract.getTotalMoney());
            preparedStatement.setInt(5,contract.getEmployeeId());
            preparedStatement.setInt(6,contract.getCustomerId());
            preparedStatement.setInt(6,contract.getServiceId());

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
