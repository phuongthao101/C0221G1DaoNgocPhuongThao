package model.repository;

import model.bean.User;

import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
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

    final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
     + "("

             + " ID serial,"

             + " NAME varchar(100) NOT NULL,"

             + " SALARY numeric(15, 2) NOT NULL,"

             + " CREATED_DATE timestamp,"

             + " PRIMARY KEY (ID)"

             + ")";

    final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";


    public User getUserById(int id) {
        Connection connection = baseRepository.connectDataBase();
        String query = "{CALL get_user_by_id(?)}";
        User user = null;
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {

                String name = rs.getString("name");

                String email = rs.getString("email");

                String country = rs.getString("country");

                user = new User(id, name, email, country);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;


    }

    public void insertUserStore(User user) {
        Connection connection = baseRepository.connectDataBase();
        String query = "{CALL insert_user(?,?,?)}";

        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, user.getName());

            callableStatement.setString(2, user.getEmail());

            callableStatement.setString(3, user.getCountry());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<User> findByAll() {
        // kết nối database => lấy lại cái danh sách
        Connection connection = baseRepository.connectDataBase(); // tạo connect với DB
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
        Connection connection = baseRepository.connectDataBase();
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
        Connection connection = baseRepository.connectDataBase();
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
        Connection connection = baseRepository.connectDataBase();

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
        Connection connection = baseRepository.connectDataBase();
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
        Connection connection = baseRepository.connectDataBase();
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
        Connection connection = baseRepository.connectDataBase();

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

    public void addUserTransaction(User user, int[] permision) {
        Connection conn = null;

        // for insert a new user

        PreparedStatement pstmt = null;

        // for assign permision to user

        PreparedStatement pstmtAssignment = null;

        // for getting user id

        ResultSet rs = null;
        try {


            conn = baseRepository.connectDataBase();

            // set auto commit to false

            conn.setAutoCommit(false);

            //

            // Insert user

            //

            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();

            // get user id

            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())

                userId = rs.getInt(1);

            //

            // in case the insert operation successes, assign permision to user

            //

            if (rowAffected == 1) {


                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);


                for (int permisionId : permision) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();

                }

                conn.commit();

            } else {

                conn.rollback();

            }

        } catch (SQLException ex) {

            // roll back the transaction

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

    public void insertUpdateUseTransaction() {


        try (Connection conn = baseRepository.connectDataBase();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);

            // start transaction block

            conn.setAutoCommit(false); // default true

            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            // Run list of update commands


            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

            psUpdate.setBigDecimal(1, new BigDecimal(999.99));


            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();


            // end transaction block, commit changes

            conn.commit();

            // good practice to set it back to default true

            conn.setAutoCommit(true);


        } catch (Exception e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

        }

    }

}