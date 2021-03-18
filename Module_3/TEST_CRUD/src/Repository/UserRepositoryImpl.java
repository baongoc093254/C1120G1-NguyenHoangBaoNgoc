package Repository;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    public static final String SELECT_ALL_USER = "SELECT * from users;";
    public static final String INSERT_USER ="INSERT INTO users  (`name`,`email`,`country`) VALUES  (?,?,?);";
    public static final String SELECT_USER_BY_ID = "SELECT `id`,`name`,`email`,`country` from users where `id` = ?";
    public static final String UPDATE_USER_BY_ID = "UPDATE `id`,`name`,`email`,`country` from users where id = ?";
    public static final String DELETE_USER_BY_ID = "DELETE FROM users where  `id` = ?;";

    @Override
    public List<User> findAll() {
        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_USER);
                resultSet = statement.executeQuery();

                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
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
                DBConection.close();
            }
        }
        return  userList;
    }
    @Override
    public User findByID(int id) {
        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_USER_BY_ID);
                statement.setInt(1,id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                     user = new User(id,name,email,country);

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
                DBConection.close();
            }

        }
            return user;
    }


    @Override
    public void save(User user) {
       Connection connection = DBConection.getConnection();
       PreparedStatement statement = null;
       if (connection != null) {
           try {
               statement = connection.prepareStatement(INSERT_USER);
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
           }
           DBConection.close();
       }

    }



    @Override
    public void update(int id, User user) {
        Connection connection = DBConection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID);
                preparedStatement.setInt(1,user.getId());
                preparedStatement.setString(2,user.getName());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getCountry());
                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            DBConection.close();

        }
    }

    @Override
    public void remove(int id) {
        Connection connection = DBConection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            DBConection.close();

        }

    }
}
