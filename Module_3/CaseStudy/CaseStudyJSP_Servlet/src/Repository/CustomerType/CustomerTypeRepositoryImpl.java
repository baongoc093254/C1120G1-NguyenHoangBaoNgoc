package Repository.CustomerType;

import Model.CustomerType;
import Repository.CustomerType.CustomerTypeRepository;
import Repository.DBConection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
    public static final String SELECT_ID_FROM_CUSTOMER_TYPE = "SELECT * FROM customer_type where customer_type_id = ?;";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "tychuot12";
    private static final String HOST = "localhost";
    private static final String DATABASE = "furamaResort_database";
    private static final String PORT = "3306";
    private static final String URL = "jdbc:mysql://"+ HOST + ":" + PORT+"/"+DATABASE+ "?useSSL=false";
    private static Connection connection;
    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<CustomerType> findAll() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<CustomerType> customerTypes = new ArrayList<>();
        // Step 1: Establishing a Connection
        // Step 2:Create a statement using connection object
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  customer_type")) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("customer_type_id");
                String name = rs.getString("customer_type_name");
                customerTypes.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypes;
    }

    @Override
    public CustomerType findById(int id) {
        CustomerType customerType = null;
        try (Connection connection = DBConection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_FROM_CUSTOMER_TYPE)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("customer_type_name");
                customerType = new CustomerType(id, name);
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return customerType;
    }
}
