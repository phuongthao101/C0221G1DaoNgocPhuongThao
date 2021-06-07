package model.repository;

import model.bean.CustomerService.CustomerUsing;
import model.bean.CustomerService.ShowAttachService;
import model.bean.customer.Customer;
import model.bean.employee.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingRepository {

    BaseRepository baseRepository = new BaseRepository(); // tạo đối tượng
    final String SELECT_ALL_VIEW = "select* from customer_view  ;"; // hiển thị danh sách
    final String SELECT_CUSTOMER_BY_NAME = "select * from customer_view where customer_name like ?"; // tìm kiếm theo tên
    final String UPDATE_CUSTOMER_USING = "update customer_view set  customer_id=?, customer_name=?, phone=?," +
            " service_name=?,contract_id=?,start_date=?,end_date,attach_service_name=?,quantity=? where customer_name =?";

    final String DELETE_CONTRACT_SQL = "delete from contract where contract_id = ?;";
    final String SELECT_BY_ID = "select * from customer_view where customer_id =?";
    final String SELECT_ATTACH_SERVICE_VIEW = "select * from show_attach_service;";

    public List<ShowAttachService> findAllAttach(){
        List<ShowAttachService> showAttachServiceList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ATTACH_SERVICE_VIEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int contractId = resultSet.getInt("contract_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                int quantity = resultSet.getInt("quantity");
                ShowAttachService  showAttachService = new ShowAttachService(contractId,attachServiceName,quantity);
                showAttachServiceList.add(showAttachService);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showAttachServiceList;
    }

    public List<CustomerUsing> findAllCustomerUsing() {
        // kết nối database => lấy lại cái danh sách
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<CustomerUsing> customerUsingList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VIEW); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int customer_id = resultSet.getInt("customer_id");
                String customer_name = resultSet.getString("customer_name");
                String phone = resultSet.getString("phone");
                String service_name = resultSet.getString("service_name");
                int contract_id = resultSet.getInt("contract_id");
                String start_date = resultSet.getString("start_date");
                String end_date = resultSet.getString("end_date");
                String attach_service_name = resultSet.getString("attach_service_name");
                int quantity = resultSet.getInt("quantity");

//                customer_id=?, customer_name=?, phone=?," +
//                " service_name=?,contract_id=?,start_date=?,end_date,attach_service_name=?,quantity=?


                CustomerUsing customerUsing = new CustomerUsing(customer_id,customer_name,phone,
                        service_name,contract_id,start_date,end_date,attach_service_name,quantity);
                customerUsingList.add(customerUsing);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUsingList;

    }

    public List<CustomerUsing> findByName(String name) {
        Connection connection = baseRepository.getConnection();

        List<CustomerUsing> customerUsingList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int customer_id = resultSet.getInt("customer_id");
                String customer_name = resultSet.getString("customer_name");
                String phone = resultSet.getString("phone");
                String service_name = resultSet.getString("service_name");
                int contract_id = resultSet.getInt("contract_id");
                String start_date = resultSet.getString("start_date");
                String end_date = resultSet.getString("end_date");
                String attach_service_name = resultSet.getString("attach_service_name");
                int quantity = resultSet.getInt("quantity");

                CustomerUsing customerUsing = new CustomerUsing(customer_id,customer_name,phone,
                        service_name,contract_id,start_date,end_date,attach_service_name,quantity);
                customerUsingList.add(customerUsing);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUsingList;

    }

    public boolean update(int id, CustomerUsing customerUsing) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {

//            int customerId, String customerName, int phone, String service_name, int contractId,
//            String startDate, String endDate, String attachServiceName, int quantity) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_USING); // update sử dụng set
            preparedStatement.setString(1, customerUsing.getCustomerName());
            preparedStatement.setString(2, customerUsing.getPhone());
            preparedStatement.setString(3, customerUsing.getService_name());
            preparedStatement.setInt(4, customerUsing.getContractId());
            preparedStatement.setString(5, customerUsing.getStartDate());
            preparedStatement.setString(6, customerUsing.getEndDate());
            preparedStatement.setString(7, customerUsing.getAttachServiceName());
            preparedStatement.setInt(8, customerUsing.getQuantity());
            preparedStatement.setInt(12, id);

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }

    public CustomerUsing findById(int id) {
        Connection connection = baseRepository.getConnection();
        CustomerUsing customerUsing = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int customer_id = resultSet.getInt("customer_id");
                String customer_name = resultSet.getString("customer_name");
                String phone = resultSet.getString("phone");
                String service_name = resultSet.getString("service_name");
                int contract_id = resultSet.getInt("contract_id");
                String start_date = resultSet.getString("start_date");
                String end_date = resultSet.getString("end_date");
                String attach_service_name = resultSet.getString("attach_service_name");
                int quantity = resultSet.getInt("quantity");

                customerUsing = new CustomerUsing(customer_id,customer_name,phone,
                        service_name,contract_id,start_date,end_date,attach_service_name,quantity);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUsing;

    }

    public boolean remove(int id) {
        boolean check = false;
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_CONTRACT_SQL);
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
