package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseRepository {
//    allowPublicKeyRetrieval=true&
//    private String jdbcURL = "jdbc:mysql://localhost:3306/database_furama?allowPublicKeyRetrieval=true&useSSL=false";

    private String jdbcURL= "jdbc:mysql://localhost:3306/examination?useSSL=false";
    private String jdbcUserName = "root";
    private String jdbcPassword ="12345678";

    protected Connection getConnection(){
        Connection connection =null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}


