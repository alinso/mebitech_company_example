package com.mebitech.company;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mebitech.company.entity.Department;
import com.mebitech.company.service.DepartmentService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


public class DepartmetControllerTest extends CompanyApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    DepartmentService departmentService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/department-list"))
                .andExpect(status().isOk())
                .andExpect(view().name("departmentList"));
    }

    @Test
    public void insertAndDelete() throws Exception{
        Department d = new Department();
        d.setName("testd");
        d.setDescription("test d");

        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(d);

        MvcResult res = mockMvc.perform(
                post("/save-department")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonData)
        ).andExpect(status().isOk()).andReturn();

        String departmentId = res.getResponse().getContentAsString();

        mockMvc.perform(
                post("/delete-department/"+departmentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string("deleted")).andReturn();
    }


    @Test public void update() throws Exception{
        Department d = new Department();
        d.setName("update1");
        d.setDescription("update1 d");

        departmentService.saveOrUpdate(d);

        d.setName("update2");
        d.setDescription("update2 d");

        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(d);

        mockMvc.perform(
                post("/save-department")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonData)
        ).andExpect(status().isOk());

    }


    }





