package Service.Customer;

import Model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(String id);

    void remove(String id);

    void update(String id, Customer customer);

//    List<Customer> findCustomerByName(String name);
//
//    Customer findCustomerById(String id);
    List<Customer> search (String search);

}
