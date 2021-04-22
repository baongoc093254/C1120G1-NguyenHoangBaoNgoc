package com.example.service.contract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    List<Contract> findAll ();
    Page<Contract> findAll(Pageable pageable);

    Contract findById(Integer id);

    void save(Contract contract);

    List<Contract> findAllByStartDateBeforeAndEndDateAfter(String currentDate);

    List<Contract> findAllByStartDateBeforeAndEndDateAfterAndCustomerName(String currentDate, String name);

}
