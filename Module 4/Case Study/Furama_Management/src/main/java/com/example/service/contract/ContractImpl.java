package com.example.service.contract;

import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
            contract.setTotal(getTotalMoney(contract)+"");
            contractRepository.save(contract);
    }

    @Override
    public Page<Contract> getCustomerUsing(String date, Pageable pageable) {
        return contractRepository.getCustomerUsing(date, pageable);
    }

    @Override
    public String getCurrentDay() {
        return new SimpleDateFormat("YYYY-MM-dd").format(new Date());
    }

    @Override
    public double getTotalMoney(Contract contract) {
         int totalDay = 0;
        double totalMoney = 0;
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getStartDate());
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getEndDate());

            totalDay = (int) TimeUnit.DAYS.convert((end.getTime() - start.getTime()), TimeUnit.MILLISECONDS);
            if (totalDay == 0) {
                totalDay = 1; // neu startDate = endDate thi hop dong ton tai it nhat 1 ngay
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double cost = Double.parseDouble(contract.getService().getCost());
        totalMoney += cost * totalDay;

        if (contract.getId() != null){
            Set<ContractDetail> detailSet = contract.getContractDetails();
            if (!detailSet.isEmpty()){
                for(ContractDetail detail : detailSet){
                    totalMoney += Double.parseDouble(detail.getAttachService().getCost())*Integer.parseInt(detail.getQuantity());
                }
            }
        }

        return totalMoney;
    }


}
