package com.codygym.controller;

import com.codygym.model.dto.ContractDetailDto;
import com.codygym.model.dto.ContractDto;
import com.codygym.model.entity.contract.AttachService;
import com.codygym.model.entity.contract.Contract;
import com.codygym.model.entity.contract.ContractDetail;
import com.codygym.model.service.IContractDetailService;
import com.codygym.model.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/contract_details")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IContractService contractService;

    @ModelAttribute("attachServices")
    public List<AttachService> attachServices(){
        return contractDetailService.listAttachService();
    }
    @ModelAttribute(value = "contracts")
    public List<Contract> contractList(){
        return contractService.findAllContract();
    }
    @GetMapping(value = "create")
    public String showCreateContractDetail(Model model) {

        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "/contractDetail/create";
    }

    @PostMapping(value = "save")
    public String saveService(@Valid @ModelAttribute("contractDetailDto") ContractDetailDto contractDetailDto,
                              BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "contractDetail/create";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        this.contractDetailService.save(contractDetail);
        model.addAttribute("msg", "Create Successfully");
        return "contractDetail/create";

    }

}
