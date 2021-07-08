package com.codygym.controller;

import com.codygym.model.dto.CustomerDto;
import com.codygym.model.dto.EmployeeDto;
import com.codygym.model.entity.customer.Customer;
import com.codygym.model.entity.employee.Division;
import com.codygym.model.entity.employee.EducationDegree;
import com.codygym.model.entity.employee.Employee;
import com.codygym.model.entity.employee.Position;
import com.codygym.model.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @ModelAttribute(value = "divisions")
    public List<Division> divisionList(){
        return employeeService.findAllDivision();
    }
    @ModelAttribute(value = "educationDegrees")
    public List<EducationDegree> educationDegreeList(){
        return employeeService.findAllEducationDegree();
    }
    @ModelAttribute(value = "positions")
    public List<Position> positionList(){
        return employeeService.findAllPosition();
    }

    @GetMapping(value = "/create")
    public String createEmployee(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "/employee/create";
    }

    @PostMapping(value = "/save")
    public String saveEmployee( @ModelAttribute("employeeDto") @Valid EmployeeDto employeeDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Create employee successfully");
        return "redirect:/employees";
    }

    @GetMapping(value = "")
    public String showListEmployee(Model model,
                                   @PageableDefault(size = 2) Pageable pageable,
                                   @RequestParam Optional<String> keyword) {
        Page<Employee> employees = employeeService.findByName(keyword.orElse(""), pageable);
        model.addAttribute("employees", employees);
        model.addAttribute("keyword", keyword.orElse(""));
        return "/employee/list";

    }

    @PostMapping(value = "delete")
    public String deleteEmployee(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Removed employee successfully!");
        return "redirect:/employees";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long id, Model model) {
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        return "/employee/edit";
    }

    @PostMapping("/edit")
    public String updateEmployee(@ModelAttribute EmployeeDto employeeDto,
                                 RedirectAttributes redirect) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.employeeService.save(employee);

        redirect.addFlashAttribute("success", "Updated employee information successfully!");
        return "redirect:/employees";
    }

}
