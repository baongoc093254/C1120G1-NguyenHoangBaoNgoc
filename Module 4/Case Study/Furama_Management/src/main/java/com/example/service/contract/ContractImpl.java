package com.example.service.contract;

import com.example.model.contract.Contract;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractImpl implements ContractService {
    @Override
    public List<Contract> findAll() {
        return null;
    }

    @Override
    public Contract findById(Integer id) {
        return null;
    }

    @Override
    public void save(Contract contract) {

    }

    @Override
    public List<Contract> findAllByStartDateBeforeAndEndDateAfter(String currentDate) {
        return null;
    }

    @Override
    public List<Contract> findAllByStartDateBeforeAndEndDateAfterAndCustomer_Name(String currentDate, String name) {
        return null;
    }
}
