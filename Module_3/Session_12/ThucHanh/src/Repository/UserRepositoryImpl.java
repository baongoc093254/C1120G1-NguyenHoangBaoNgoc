package Repository;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository  {
    public static final String SELECT_ALL_USER = "select * from user";
    public static final String INSERT_NEW_USER = "INSERT INTO user(name ,email,country) VALUE (?,?,?)";


    @Override
    public List<User> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_USER);
                resultSet = statement.executeQuery();

                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("1");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id,name,email,country);
                    userList.add(user);

                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return  userList;
    }

    @Override
    public void save(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_USER);
                statement.setString(1,user.getName());
                statement.setString(2,user.getEmail());
                statement.setString(3,user.getCountry());

                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }

        }
    }

    @Override
    public User findByID(int id) {
        return null;
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void remove(int id) {

    }
}
