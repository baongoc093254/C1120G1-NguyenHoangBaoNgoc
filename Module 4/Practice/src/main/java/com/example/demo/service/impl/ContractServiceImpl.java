package com.example.demo.service.impl;

import com.example.demo.model.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;
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
            contract.setTotal(getTotalMoney(contract));
            contractRepository.save(contract);
    }

    @Override
    public Page<Contract> getCustomerUsing(String date, Pageable pageable) {
        return null;
    }

    @Override
    public String getCurrentDay() {
        return null;
    }

    @Override
    public Double getTotalMoney(Contract contract) {
        return Integer.parseInt(contract.getQuantity())*contract.getProduct().getCost();

    }

    @Override
    public Page<Contract> findByDateBuy(String fromDate, String toDate, Pageable pageable) {
        return contractRepository.findByDateBuy(fromDate, toDate, pageable);
    }

    @Override
    public List<Contract> findByLimit(Integer limitNumber) {
        return contractRepository.findByLimit(limitNumber);
    }


}
