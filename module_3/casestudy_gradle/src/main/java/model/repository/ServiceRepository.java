package model.repository;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository(); // tạo đối tượng
    final String SELECT_ALL_SERVICE = "select* from service  ;"; // hiển thị danh sách

    final String INSERT_SERVICE_SQL = "insert into service(service_name ,\n" +
            "service_area,  \n" +
            "service_cost , \n" +
            "service_max_people,  \n" +
            "rent_type_id  ,\n" +
            "service_type_id  ,\n" +
            "standard_room  ,\n" +
            "description_other_convenience ,\n" +
            "pool_area  ,\n" +
            "number_of_floors)" +
            " values(?,?,?,?,?,?,?,?,?,?);";
    final String SELECT_TYPE_SERVICE = "select* from service_type;";
    final String SELECT_RENT_TYPE = "select* from rent_type;";


    public List<ServiceType> findAllServiceType() {
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<ServiceType> serviceTypeList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TYPE_SERVICE); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");

                ServiceType serviceType = new ServiceType(id, name);
                serviceTypeList.add(serviceType);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }

    public List<RentType> findAllRentType() {
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<RentType> rentTypeList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENT_TYPE); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu

            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                int cost = resultSet.getInt("rent_type_cost");

                RentType rentType = new RentType(id, name, cost);
                rentTypeList.add(rentType);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
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

    public boolean create(Service service) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL);

           preparedStatement.setString(1,service.getName());
           preparedStatement.setInt(2,service.getArea());
           preparedStatement.setDouble(3,service.getServiceCost());
           preparedStatement.setInt(4,service.getRentTypeId());
           preparedStatement.setInt(5,service.getMaxPeople());
           preparedStatement.setInt(6,service.getServiceTypeId());
           preparedStatement.setString(7,service.getStandardRoom());
           preparedStatement.setString(8,service.getConvenienceDescription());
           preparedStatement.setString(9,service.getPoolArea());
           preparedStatement.setString(10,service.getNumberFloors());

            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return check;
    }

}
