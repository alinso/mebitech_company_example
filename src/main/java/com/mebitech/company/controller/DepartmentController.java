package com.mebitech.company.controller;

import com.mebitech.company.entity.Department;
import com.mebitech.company.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    IDepartmentService departmentService;

    @GetMapping("/department-list")
    public String employeeList(Model md){
        List<Department> departments = departmentService.getAll();
        md.addAttribute("departments", departments);
        md.addAttribute("title","List Of Departments");
        return "department-list";
    }


    @PostMapping("/save-department")
    @ResponseBody
    public String saveEmployee(@RequestBody Department departmentForm){

        Department department = new Department();
        department.setId(departmentForm.getId());
        department.setName(departmentForm.getName());
        department.setDescription(departmentForm.getDescription());


        departmentService.saveOrUpdate(department);
        return "{\"result\":\"1\"}";
    }


    @GetMapping("/edit-department/{department_id}")
    public String editEmployee(@PathVariable(value="department_id") Integer department_id, Model md){
        Department d = departmentService.get(department_id);

        String title;
        if(department_id==0) title="Add New Employee";
        else title="Edit Employee";

        md.addAttribute("title",title);
        md.addAttribute("department",d);
        return "edit-department";
    }


    @PostMapping("/delete-department/{department_id}")
    public String deleteEmployee(@PathVariable(value="department_id") Integer department_id){
        departmentService.deleteById(department_id);
        return "{\"result\":\"1\"}";
    }
}
