package Service.Customer;

import Model.Customer;
import Repository.Customer.CustomerRepository;
import Repository.Customer.CustomerRepositoryImpl;
import Service.Customer.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
     return    customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(String id, Customer customer) {
        customerRepository.update(id,customer);
    }

    @Override
    public List<Customer> search(String search) {
       return customerRepository.search(search);
    }

//    @Override
//    public List<Customer> findCustomerByName(String name) {
//        return customerRepository.findCustomerByName(name);
//    }
//
//    @Override
//    public Customer findCustomerById(String id) {
//        return customerRepository.findCustomerById(id);
//    }

    @Override
    public void remove(String id) {
        customerRepository.remove(id);
    }

}
