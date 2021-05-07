package Service;

import Model.Customer;
import Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void remove(int id);

    void update(int id, Product product);

    //    List<Customer> findCustomerByName(String name);
//
//    Customer findCustomerById(String id);
    List<Product> search(String search);
}
