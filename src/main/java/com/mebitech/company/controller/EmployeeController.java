package com.mebitech.company.controller;


import com.mebitech.company.entity.Employee;
import com.mebitech.company.service.EmployeeService;
import com.mebitech.company.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;


@GetMapping("/employee-list")
    public String employeeList(Model md){
    List<Employee> employees = employeeService.findAll();
    md.addAttribute("employees", employees);
    md.addAttribute("title","List Of Employees");
    return "employee-list";
}

}
