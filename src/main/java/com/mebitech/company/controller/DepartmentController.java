package com.mebitech.company.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mebitech.company.entity.Department;
import com.mebitech.company.service.IDepartmentService;
import com.mebitech.company.viewModel.DepartmentEditViewModel;
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
    public String departmentList() {
        return "departmentList";
    }



    @GetMapping("/departmentListRest")
    @ResponseBody
    public String departmentListRest(Model md) throws Exception{
        List<Department> departments = departmentService.getAll();
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(departments);

        return jsonData;
    }


    @PostMapping("/save-department")
    @ResponseBody
    public String saveDepartment(@RequestBody DepartmentEditViewModel departmentViewModel){

        Department department = new Department();
        department.setId(departmentViewModel.getId());
        department.setName(departmentViewModel.getName());
        department.setDescription(departmentViewModel.getDescription());


        departmentService.saveOrUpdate(department);
        return Integer.toString(department.getId());
    }


    @GetMapping("/edit-department/{department_id}")
    public String editDepartment(@PathVariable(value="department_id") Integer department_id, Model md){
        md.addAttribute("department_id",department_id);
        return "editDepartment";
    }



    @GetMapping("/editDepartmentRest/{department_id}")
    @ResponseBody
    public String editDepartmentRest(@PathVariable(value="department_id") Integer department_id) throws Exception{
        Department d = departmentService.get(department_id);
        DepartmentEditViewModel departmentEdit  =new DepartmentEditViewModel();
        String title;
        if(department_id==0) title="Add New Department";
        else title="Edit Department";

        departmentEdit.setDescription(d.getDescription());
        departmentEdit.setName(d.getName());
        departmentEdit.setId(d.getId());

        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(departmentEdit);

        return jsonData;
    }



    @PostMapping("/delete-department/{department_id}")
    @ResponseBody
    public String deleteEmployee(@PathVariable(value="department_id") Integer department_id){
        departmentService.deleteById(department_id);
        return "deleted";
    }
}
