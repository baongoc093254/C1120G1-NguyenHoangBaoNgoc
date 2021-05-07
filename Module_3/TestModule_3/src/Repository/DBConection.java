package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "tychuot12";
    private static final String HOST = "localhost";
    private static final String DATABASE = "test2";
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

    public static void close() {

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

