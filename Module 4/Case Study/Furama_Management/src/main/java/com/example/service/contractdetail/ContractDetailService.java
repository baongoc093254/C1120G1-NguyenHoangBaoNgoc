package com.example.service.contractdetail;

import com.example.model.contract.Contract;

import java.util.List;

public interface ContractDetailService {
    List<Contract> findAll ();

    Contract findById(Integer id);

    void save(Contract contract);

    List<Contract> findAllByStartDateBeforeAndEndDateAfter(String currentDate);

    List<Contract> findAllByStartDateBeforeAndEndDateAfterAndCustomer_Name(String currentDate, String name);

}
