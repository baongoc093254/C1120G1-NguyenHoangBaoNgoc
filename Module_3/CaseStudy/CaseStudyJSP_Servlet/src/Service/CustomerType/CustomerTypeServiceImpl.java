package Service.CustomerType;

import Model.CustomerType;
import Repository.CustomerType.CustomerTypeRepository;
import Repository.CustomerType.CustomerTypeRepositoryImpl;
import Service.CustomerType.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository  customerTypeRepository = new CustomerTypeRepositoryImpl();
        @Override
        public List<CustomerType> findAll() {
          return   customerTypeRepository.findAll();
        }

        @Override
        public CustomerType findById(int id) {
          return   customerTypeRepository.findById(id);
        }


}
