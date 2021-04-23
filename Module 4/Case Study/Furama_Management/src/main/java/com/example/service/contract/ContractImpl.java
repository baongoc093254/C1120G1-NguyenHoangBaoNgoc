package com.example.service.contract;

import com.example.model.contract.Contract;
import com.example.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractImpl implements ContractService {
    @Autowired
    private  ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
            contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAllByStartDateBeforeAndEndDateAfter(String currentDate) {
        return contractRepository.findAllByStartDateBeforeAndEndDateAfter(currentDate, currentDate);
    }

    @Override
    public List<Contract> findAllByStartDateBeforeAndEndDateAfterAndCustomerName(String currentDate, String name) {
        return contractRepository.findAllByStartDateBeforeAndEndDateAfterAndCustomerName(currentDate,currentDate,name);
    }
}
