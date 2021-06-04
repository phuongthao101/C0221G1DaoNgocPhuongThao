package model.repository;

import model.bean.customer.TypeCustomer;
import model.bean.service.ServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository(); // tạo đối tượng

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
            " values(?,?,?,?,?,?,?,?);";
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

                ServiceType serviceType = new ServiceType(id,name);
                serviceTypeList.add(serviceType);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }
}
