package com.example.repository;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAll(Pageable pageable);
    Page<Contract> findContractByEmployeeContaining(String name,Pageable pageable);
    List<Contract> findContractByEmployeeContaining(String name);

    List<Contract> findAllByStartDateBeforeAndEndDateAfter(String startDate, String endDate);


    List<Contract> findAllByStartDateBeforeAndEndDateAfterAndCustomerName(String startDate, String endDate, String name);
}
