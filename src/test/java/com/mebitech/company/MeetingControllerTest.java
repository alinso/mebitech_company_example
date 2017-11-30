package com.mebitech.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mebitech.company.entity.Department;
import com.mebitech.company.entity.Meeting;
import com.mebitech.company.service.DepartmentService;
import com.mebitech.company.service.MeetingService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class MeetingControllerTest extends CompanyApplicationTests{
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    MeetingService meetingService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/meeting-list"))
                .andExpect(status().isOk())
                .andExpect(view().name("meetingList"));
    }

    @Test
    public void insertAndDelete() throws Exception{
       Meeting m = new Meeting();
        m.setName("testd");
        m.setDescription("test d");

        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(m);

        MvcResult res = mockMvc.perform(
                post("/save-meeting")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonData)
        ).andExpect(status().isOk()).andReturn();

        String meetingId = res.getResponse().getContentAsString();

        mockMvc.perform(
                post("/delete-meeting/"+meetingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string("deleted")).andReturn();
    }


    @Test public void update() throws Exception{
        Meeting m = new Meeting();
        m.setName("update1");
        m.setDescription("update1 m");

        meetingService.saveOrUpdate(m);

        m.setName("update2");
        m.setDescription("update2 d");

        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(m);

        mockMvc.perform(
                post("/save-meeting")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonData)
        ).andExpect(status().isOk());

    }
}
