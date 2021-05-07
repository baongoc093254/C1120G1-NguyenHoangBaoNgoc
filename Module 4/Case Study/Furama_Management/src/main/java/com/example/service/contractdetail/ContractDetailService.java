package com.example.service.contractdetail;

import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();
    Page<ContractDetail> findAll(Pageable pageable);

    ContractDetail findById(Integer id);

    void save(ContractDetail contractDetail);
    List<ContractDetail> findAllByContract(Contract contract);




}
