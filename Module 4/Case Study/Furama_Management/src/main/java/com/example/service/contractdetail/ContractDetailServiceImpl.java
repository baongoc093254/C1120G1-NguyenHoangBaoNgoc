package com.example.service.contractdetail;

import com.example.model.contract.Contract;
import com.example.service.contract.ContractService;

import java.util.List;

public class ContractDetailServiceImpl  implements ContractService {
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
