package com.example.model.contract;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attach_service_id")
    private AttachService  attachService;

    @Column(name = "quantity")
    private Integer quantity;

    public ContractDetail() {
    }

    public ContractDetail( Contract contract, AttachService attachService, Integer quantity) {

        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public ContractDetail(AttachService attachService, Integer quantity) {
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
