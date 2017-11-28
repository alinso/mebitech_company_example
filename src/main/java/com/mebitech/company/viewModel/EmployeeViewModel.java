package com.mebitech.company.viewModel;

import com.mebitech.company.entity.Department;
import com.mebitech.company.entity.Employee;

import java.util.List;

public class EmployeeViewModel {
   private Employee employee;
  private Integer departmentId;



    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
