package com.mebitech.company.controller;


import com.mebitech.company.entity.Department;
import com.mebitech.company.entity.Employee;
import com.mebitech.company.service.IDepartmentService;
import com.mebitech.company.service.IEmployeeService;
import com.mebitech.company.viewModel.EmployeeFormViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

@PostMapping("/save-employee")
@ResponseBody
public String saveEmployee(@RequestBody EmployeeFormViewModel employeeFormViewModel){

        Employee employee = new Employee();
        Department department = departmentService.get(employeeFormViewModel.getDepartmentId());
        employee.setId(employeeFormViewModel.getId());
        employee.setName(employeeFormViewModel.getName());
        employee.setDepartment(department);
        employee.setSurname(employeeFormViewModel.getSurname());
        employee.setSalary(employeeFormViewModel.getSalary());

        employeeService.saveOrUpdate(employee);
        return "{\"result\":\"1\"}";
}


    @GetMapping("/edit-employee/{employee_id}")
    public String editEmployee(@PathVariable(value="employee_id") Integer employee_id, Model md){
        Employee e = employeeService.get(employee_id);
        List<Department> departments  = departmentService.getAll();


        EmployeeFormViewModel eViewModel  =new EmployeeFormViewModel();
        eViewModel.setId(e.getId());


        eViewModel.setDepartmentId(e.getDepartment().getId());
        eViewModel.setSalary(e.getSalary());
        eViewModel.setName(e.getName());
        eViewModel.setSurname(e.getSurname());

        String title;
        if(employee_id==0) title="Add New Employee";
        else title="Edit Employee";

        md.addAttribute("title",title);
        md.addAttribute("eViewModel",eViewModel);
        md.addAttribute("departments",departments);
        return "edit-employee";
    }



    @PostMapping("/delete-employee/{employee_id}")
    public String deleteEmployee(@PathVariable(value="employee_id") Integer employee_id){
        employeeService.deleteById(employee_id);
        return "{\"result\":\"1\"}";
    }

}
