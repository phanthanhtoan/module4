package com.case_study.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractDetailId;
    private int quantity;

    @ManyToOne(targetEntity = Contract.class, cascade = CascadeType.ALL)
    private Contract contract;

    @ManyToOne(targetEntity = AttachService.class)
    private AttachService attachService;

    public ContractDetail() {
    }

    public ContractDetail(Long contractDetailId, int quantity, Contract contract, AttachService attachService) {
        this.contractDetailId = contractDetailId;
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
