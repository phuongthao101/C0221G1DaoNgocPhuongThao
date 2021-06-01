package model.repository;

import model.bean.User;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    BaseRepository baseRepository = new BaseRepository(); // tạo đối tượng

    final String SELECT_ALL_USERS = "select* from users ;"; // hiển thị danh sách
    final String INSERT_USERS_SQL = "insert into users(name, email, country) values(?,?,?);";
    final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?"; //hiển thị các mục cần truy xuất
    final String DELETE_USERS_SQL = "delete from users where id = ?;";
    final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    final String SELECT_USER_BY_COUNTRY = "select * from users where country like ?"; // tìm kiếm theo contry
    final String SORT_BY_NAME = "select * from users order by name"; // sắp xếp theo tên

    public List<User> findByAll() {
        // kết nối database => lấy lại cái danh sách
        Connection connection = baseRepository.getConnection(); // tạo connect với DB
        List<User> userList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu
            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                User user = new User(id, name, email, country);
                userList.add(user);


            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;


    }


    public boolean update(User user) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL); // update sử dụng set
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());


            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }

    public User findById(int id) {
        Connection connection = baseRepository.getConnection();
        User user = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id1, name, email, country);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    public List<User> findByCountry(String country) {
        Connection connection = baseRepository.getConnection();

        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            preparedStatement.setString(1, "%" + country + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country1 = resultSet.getString("country");
                User user = new User(id, name, email, country1);
                userList.add(user);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    public boolean add(User user) {
        Connection connection = baseRepository.getConnection();
        boolean check = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

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
            preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;


    }

    public List<User> sortByName() {
        Connection connection = baseRepository.getConnection();

        List<User> userList = new ArrayList<>(); // tạo list chứa thông tin user
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_NAME); // truy vấn
            ResultSet resultSet = preparedStatement.executeQuery(); // dùng cho câu lệnh select; chứa dữ liệu
            while (resultSet.next()) {// trỏ đến từng record
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                User user = new User(id, name1, email, country);
                userList.add(user);

            }
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;

    }

    public List<User> viewUserStore() {
        Connection connection = baseRepository.getConnection();
        List<User> userList = new ArrayList<>();
        String query = "{CALL view_list_user_procedure()}";
        try{
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                String email = resultSet.getString("email");

                String country = resultSet.getString("country");

                userList.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    public boolean updateUserStore(User user) {
        Connection connection = baseRepository.getConnection();
        String query = "{CALL update_user_procedure(?,?,?,?)}";
        boolean check = false;
        try{
            CallableStatement callableStatement = connection.prepareCall(query);

            callableStatement.setInt(1, user.getId());

            callableStatement.setString(2, user.getName());

            callableStatement.setString(3, user.getEmail());

            callableStatement.setString(4, user.getCountry());

            check = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public void deleteUserStore(int id) {
        Connection connection =baseRepository.getConnection();
        String query = "{CALL delete_user_procedure(?)}";
        boolean check = false;
        try  {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void addUserTransaction(User user, int[] permisions) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmtAssignment = null;


        ResultSet rs = null;

        try {

            conn = baseRepository.getConnection();

            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())
                userId = rs.getInt(1);
            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "
                        + "VALUES(?,?)";
                pstmtAssignment = conn.prepareStatement(sqlPivot);
                for (int permisionId : permisions) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permisionId);
                    pstmtAssignment.executeUpdate();

                }
                conn.commit();
            } else {

                conn.rollback();
            }
        } catch (SQLException ex) {
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (pstmtAssignment != null) pstmtAssignment.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}