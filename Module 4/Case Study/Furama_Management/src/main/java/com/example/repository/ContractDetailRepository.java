package com.example.repository;

import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractDetailRepository  extends JpaRepository<ContractDetail, Integer> {
    Page<ContractDetail> findAll(Pageable pageable);
    Page<ContractDetail> findByAttachServiceContaining(String name,Pageable pageable);
    List<ContractDetail> findByAttachServiceContaining(String name);
}
