package Repository;

import Model.Customer;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    public static final String FIND_ALL = "SELECT * FROM Product";
    public static final String FIND_ID = "SELECT * FROM Product where `idproduct` = ?";
    public static final String INSERT_PRODUCT = "INSERT INTO product(nameproduct,price,discount,stock) value (?,?,?,?)";

    @Override
    public List<Product> findAll() {
        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_ALL);
                resultSet = statement.executeQuery();

                Product product = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("idproduct");
                    String name = resultSet.getString("nameproduct");
                    Double price = resultSet.getDouble("price");
                    int discount = (resultSet.getInt("discount"));
                    int stock = resultSet.getInt("stock");
                    product = new Product(id,name,price,discount,stock);
                    productList.add(product);
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
        return  productList;
    }

    @Override
    public void save(Product product) {
        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_PRODUCT);
                statement.setString(1,product.getNameProduct());
                statement.setDouble(2,product.getPrice());
                statement.setInt(3,product.getDiscount());
                statement.setInt(4,product.getStock());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConection.close();
        }
    }

    @Override
    public Product findById(int id) {
        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;
        Product product = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_ID);
                statement.setInt(1,id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("nameproduct");
                    Double price = resultSet.getDouble("price");
                    int discount = (resultSet.getInt("discount"));
                    int stock = resultSet.getInt("stock");
                    product = new Product(id,name,price,discount,stock);
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
        return product;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public List<Product> search(String search) {

        Connection connection = DBConection.getConnection();
        PreparedStatement preparedStatement = null;
        Product product;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("");
                preparedStatement.setString(1,search);
                preparedStatement.setString(2,search);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("nameproduct");
                    Double price = resultSet.getDouble("price");
                    int discount = (resultSet.getInt("discount"));
                    int stock = resultSet.getInt("stock");
                    product = new Product(name,price,discount,stock);
                    productList.add(product);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return  productList;
    }
}
