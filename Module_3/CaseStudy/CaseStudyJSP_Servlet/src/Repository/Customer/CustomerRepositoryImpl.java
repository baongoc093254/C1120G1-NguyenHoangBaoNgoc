package Repository.Customer;

import Model.Customer;
import Model.CustomerType;
import Repository.CustomerType.CustomerTypeRepositoryImpl;
import Repository.DBConection;
import Service.CustomerType.CustomerTypeService;
import Service.CustomerType.CustomerTypeServiceImpl;

import java.lang.ref.PhantomReference;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class CustomerRepositoryImpl implements CustomerRepository {
    public static final String INSERT_INTO_CUSTOMER = "INSERT INTO customer (customer_id, customer_name, " +
            "customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address,customer_type_id) " +
            " VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_CUSTOMER = "update customer set customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, \n" +
            "customer_phone = ?, customer_email = ? , customer_address = ?, customer_type_id = ? where customer_id = ?;";
    public static final String FIND_BY_ID = "SELECT * from customer where  `customer_id` = ?";
    public static final String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id = ?;";
//    public static final String FIND_CUSTOMER_BY_NAME = "select * from customer where customer_name like  concat ('%',?,'%')";
    public static final String FIND_CUSTOMER_BY_SOMETHING = "select * from customer where customer_id like concat('%',?,'%')\n" +
            "union \n" +
            "select * from customer where customer_name like  concat ('%',?,'%') \n" +
            "union\n" +
            "select customer_id, customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,\n" +
            "customer_email,customer_address, customer.customer_type_id \n" +
            "from customer inner join customer_type on customer.customer_type_id = customer_type.customer_type_id \n" +
            "where customer_type.customer_type_name like concat('%',?,'%') \n" +
            "union \n" +
            "select * from customer where customer_address like concat('%',?,'%');";
    private CustomerTypeRepositoryImpl customerTypeRepository = new CustomerTypeRepositoryImpl();
    public static final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer";
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    @Override
    public List<Customer> findAll() {
        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> customerList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = statement.executeQuery();

                Customer customer = null;
                while (resultSet.next()) {
                    String id = resultSet.getString("customer_id");
                    String name = resultSet.getString("customer_name");
                    String birthday = resultSet.getString("customer_birthday");
                    int int_gender = (resultSet.getInt("customer_gender"));
                    boolean gender = (int_gender == 1);
                    String idcard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    CustomerType customerType = customerTypeService.findById(resultSet.getInt("customer_type_id"));
                    customer = new Customer(id,name,birthday,gender,idcard,phone,email,address,customerType);
                    customerList.add(customer);
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
        return  customerList;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_INTO_CUSTOMER);
                statement.setString(1,customer.getCustomer_id());
                statement.setString(2,customer.getCustomer_name());
                statement.setString(3,customer.getCustomer_birthday());
                statement.setBoolean(4,customer.isCustomer_gender());
                statement.setString(5,customer.getCustomer_id_card());
                statement.setString(6,customer.getCustomer_phone());
                statement.setString(7,customer.getCustomer_email());
                statement.setString(8,customer.getCustomer_address());
                statement.setInt(9,customer.getCustomerType().getCustomer_type_id());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
                DBConection.close();
        }

    }

    @Override
    public Customer findById(String id) {
        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;
        Customer customer = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_BY_ID);
                statement.setString(1,id);
                 resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("customer_name");
                    String birthday = resultSet.getString("customer_birthday");
                    int int_gender = (resultSet.getInt("customer_gender"));
                    boolean gender = (int_gender == 1);
                    String idcard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    CustomerType customerType = customerTypeService.findById(resultSet.getInt("customer_type_id"));
                    customer = new Customer(id,name,birthday,gender,idcard,phone,email,address,customerType);
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
                return customer;
    }

    @Override
    public void remove(String id) {
        System.out.println("da vao remove");
        Connection connection = DBConection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
                preparedStatement.setString(1,id);
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
    public void update(String id, Customer customer) {
        Connection connection = DBConection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_CUSTOMER);
                statement.setString(1,customer.getCustomer_name());
                statement.setString(2,customer.getCustomer_birthday());
                statement.setBoolean(3,customer.isCustomer_gender());
                statement.setString(4,customer.getCustomer_id_card());
                statement.setString(5,customer.getCustomer_phone());
                statement.setString(6,customer.getCustomer_email());
                statement.setString(7,customer.getCustomer_address());
                statement.setInt(8,customer.getCustomerType().getCustomer_type_id());
                statement.setString(9,customer.getCustomer_id());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConection.close();
        }
    }

    @Override
    public List<Customer> search(String search) {
       Connection connection = DBConection.getConnection();
       PreparedStatement preparedStatement = null;
       Customer customer;
       ResultSet resultSet = null;
       List<Customer> customerList = new ArrayList<>();
       if (connection != null) {
           try {
               preparedStatement = connection.prepareStatement(FIND_CUSTOMER_BY_SOMETHING);
               preparedStatement.setString(1,search);
               preparedStatement.setString(2,search);
               preparedStatement.setString(3,search);
               preparedStatement.setString(4,search);
               resultSet = preparedStatement.executeQuery();
               while (resultSet.next()) {
                   String id = resultSet.getString("customer_id");
                   String name = resultSet.getString("customer_name");
                   String birthday = resultSet.getString("customer_birthday");
                   int int_gender = (resultSet.getInt("customer_gender"));
                   boolean gender = (int_gender == 1);
                   String idcard = resultSet.getString("customer_id_card");
                   String phone = resultSet.getString("customer_phone");
                   String email = resultSet.getString("customer_email");
                   String address = resultSet.getString("customer_address");
                   CustomerType customerType = customerTypeService.findById(resultSet.getInt("customer_type_id"));
                   customer = new Customer(id,name,birthday,gender,idcard,phone,email,address,customerType);
                   customerList.add(customer);
               }
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
       }
       return  customerList;
    }









//    @Override
//    public List<Customer> findCustomerByName(String name) {
//        Connection connection = DBConection.getConnection();
//        PreparedStatement preparedStatement = null;
//        Customer customer;
//        ResultSet resultSet = null;
//        List<Customer> customerList = new ArrayList<>();
//        if (connection != null) {
//            try {
//                preparedStatement = connection.prepareStatement(FIND_CUSTOMER_BY_NAME);
//                preparedStatement.setString(1,name);
//                resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    String customer_id = resultSet.getString("customer_id");
//                    String customer_name = resultSet.getString("customer_name");
//                    String customer_birthday = resultSet.getString("customer_birthday");
//                    boolean gender = Boolean.parseBoolean(resultSet.getString("customer_gender"));
//                    String customer_id_card = resultSet.getString("customer_id_card");
//                    String customer_phone = resultSet.getString("customer_phone");
//                    String customer_email = resultSet.getString("customer_email");
//                    String customer_address = resultSet.getString("customer_address");
//                    CustomerType customerType = customerTypeService.findById(Integer.parseInt(resultSet.getString("customer_type_id")));
//                    customer = new Customer(customer_id,customer_name,customer_birthday,
//                            gender,customer_id_card,customer_phone,customer_email,
//                            customer_address,customerType);
//                    customerList.add(customer);
//                }
//
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return  customerList;
//    }

//    @Override
//    public Customer findCustomerById(String id) {
//        Connection connection = DBConection.getConnection();
//        PreparedStatement preparedStatement = null;
//        Customer customer = null;
//        ResultSet resultSet = null;
//        if (connection != null) {
//            try {
//                preparedStatement = connection.prepareStatement(FIND_BY_IDCUS);
//                preparedStatement.setString(1,id);
//                resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    String customer_id = resultSet.getString("customer_id");
//                    String customer_name = resultSet.getString("customer_name");
//                    String customer_birthday = resultSet.getString("customer_birthday");
//                    boolean gender = Boolean.parseBoolean(resultSet.getString("customer_gender"));
//                    String customer_id_card = resultSet.getString("customer_id_card");
//                    String customer_phone = resultSet.getString("customer_phone");
//                    String customer_email = resultSet.getString("customer_email");
//                    String customer_address = resultSet.getString("customer_address");
//                    CustomerType customerType = customerTypeService.findById(Integer.parseInt(resultSet.getString("customer_type_id")));
//                    customer = new Customer(customer_id,customer_name,customer_birthday,
//                            gender,customer_id_card,customer_phone,customer_email,
//                            customer_address,customerType);
//
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//
//        }
//        return customer;
//    }

}
