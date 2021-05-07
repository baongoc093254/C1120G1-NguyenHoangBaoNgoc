package com.example.demo.service;

import com.example.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    List<Contract> findAll ();
    Page<Contract> findAll(Pageable pageable);

    Contract findById(Integer id);

    void save(Contract contract);

    Page<Contract> getCustomerUsing(String date, Pageable pageable);


    String getCurrentDay();
    Double getTotalMoney(Contract contract);
    Page<Contract> findByDateBuy(String fromDate, String toDate, Pageable pageable);
    List<Contract> findByLimit(Integer limitNumber);
}
