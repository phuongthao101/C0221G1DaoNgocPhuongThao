package com.codygym.controller;

import com.codygym.model.dto.ServiceDto;
import com.codygym.model.entity.service.RentType;
import com.codygym.model.entity.service.ServiceType;
import com.codygym.model.entity.service.Services;
import com.codygym.model.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/services")

public class ServiceController {
    @Autowired
    IServiceService serviceService;

    @ModelAttribute("serviceTypes")
    public List<ServiceType> serviceTypeList() {
        return serviceService.findAllServiceType();
    }
    @ModelAttribute("rentTypes")
    public List<RentType> rentTypeList() {
        return serviceService.findAllRentType();
    }

    @GetMapping(value = "create")
    public String showCreateService(Model model){
        model.addAttribute("serviceDto", new ServiceDto());
        return "/service/create";
    }
    @PostMapping(value = "save")
    public String saveService(@Valid @ModelAttribute( "serviceDto") ServiceDto serviceDto,
                                BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "service/create";
        }
        Services services = new Services();
        BeanUtils.copyProperties(serviceDto, services);
        this.serviceService.save(services);
        return "service/create";

    }

}
