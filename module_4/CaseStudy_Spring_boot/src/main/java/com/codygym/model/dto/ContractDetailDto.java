package com.codygym.model.dto;

import com.codygym.model.entity.contract.AttachService;
import com.codygym.model.entity.contract.Contract;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractDetailDto {
    private Long contractDetailId;

    private String quantity;
    private AttachService attachService;
    private Contract contract;

    public ContractDetailDto() {
    }
}
