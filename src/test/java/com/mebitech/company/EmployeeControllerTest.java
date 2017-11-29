package com.mebitech.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mebitech.company.entity.Department;
import com.mebitech.company.entity.Employee;
import com.mebitech.company.service.DepartmentService;
import com.mebitech.company.service.EmployeeService;
import com.mebitech.company.viewModel.EmployeeFormViewModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class EmployeeControllerTest extends CompanyApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    EmployeeService employeeService;

    @Autowired DepartmentService departmentService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/employee-list"))
                .andExpect(status().isOk())
                .andExpect(view().name("employee-list"));
    }



    @Test
    public void insertAndDelete() throws Exception{
        EmployeeFormViewModel e = new EmployeeFormViewModel();
        Department d = departmentService.getFirst();

        e.setName("teste");
        e.setSurname("test s");
        e.setSalary(1000);
        e.setDepartmentId(d.getId());



        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(e);

        MvcResult res = mockMvc.perform(
                post("/save-employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonData)
        ).andExpect(status().isOk()).andReturn();

        String eId = res.getResponse().getContentAsString();

        mockMvc.perform(
                post("/delete-employee/"+eId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string("deleted"));
    }



    @Test public void update() throws Exception{
        Employee e = new Employee();
        Department d = departmentService.getFirst();

        e.setName("test1");
        e.setSurname("test1  s");
        e.setSalary(1000);
        e.setDepartment(d);

        employeeService.saveOrUpdate(e);

        EmployeeFormViewModel eViewModel = new EmployeeFormViewModel();
        eViewModel.setId(e.getId());
        eViewModel.setName("test2");
        eViewModel.setSurname("test2 s");
        eViewModel.setSalary(2000);
        eViewModel.setDepartmentId(d.getId());

        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(eViewModel);

        mockMvc.perform(
                post("/save-employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonData)
        ).andExpect(status().isOk());

    }

}
