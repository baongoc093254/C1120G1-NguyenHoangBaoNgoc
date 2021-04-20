package com.example.repository;

import com.example.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailRepository  extends JpaRepository<ContractDetail, Integer> {
}
