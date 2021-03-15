package Repository;

import Model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findByID(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
