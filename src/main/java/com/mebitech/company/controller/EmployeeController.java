package com.mebitech.company.controller;


import com.mebitech.company.entity.Department;
import com.mebitech.company.entity.Employee;
import com.mebitech.company.service.EmployeeService;
import com.mebitech.company.service.IDepartmentService;
import com.mebitech.company.service.IEmployeeService;
import com.mebitech.company.viewModel.EmployeeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IDepartmentService departmentService;



@GetMapping("/employee-list")
    public String employeeList(Model md){
    List<Employee> employees = employeeService.getAll();
    md.addAttribute("employees", employees);
    md.addAttribute("title","List Of Employees");
    return "employee-list";
}


    @GetMapping("/edit-employee/{employee_id}")
    public String editEmployee(@PathVariable(value="employee_id") Integer employee_id, Model md){
        Employee e = employeeService.get(employee_id);
        List<Department> departments  = departmentService.getAll();
        EmployeeViewModel eViewModel = new EmployeeViewModel();

        eViewModel.setEmployee(e);
        eViewModel.setDepartmentId(e.getDepartment().getId());

        String title;
        if(employee_id==0) title="Add New Employee";
        else title="Edit Employee";

        md.addAttribute("title",title);
        md.addAttribute("eViewModel",eViewModel);
        md.addAttribute("departments",departments);
        return "edit-employee";

    }

}
