package Repository.CustomerType;

import Model.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    List<CustomerType> findAll();

    CustomerType findById(int id);
}
