package com.example.service.contractdetail;


import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.repository.ContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl  implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public ContractDetail findById(Integer id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
            contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAllByContract(Contract contract) {
        return contractDetailRepository.findAllByContract(contract);
    }


}
