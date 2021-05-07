package com.example.demo.repository;

import com.example.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ContractRepository  extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract " +
            "where contract_date_buy " +
            "between ?1 and ?2", nativeQuery = true)
    Page<Contract> findByDateBuy(String fromDate, String toDate, Pageable pageable);

    @Query(value = "select * from contract " +
            "order by quantity desc " +
            "limit ?1", nativeQuery = true)
    List<Contract> findByLimit(Integer limitNumber);
}
