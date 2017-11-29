package com.mebitech.company.controller;

import com.mebitech.company.entity.Department;
import com.mebitech.company.entity.Meeting;
import com.mebitech.company.service.IDepartmentService;
import com.mebitech.company.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MeetingController {

    @Autowired
    IMeetingService meetingService;

    @Autowired
    IDepartmentService departmentService;

    @GetMapping("/meeting-list")
    public String meetingList(Model md){
        List<Meeting> meetings = meetingService.getAll();
        md.addAttribute("meetings", meetings);
        md.addAttribute("title","List Of Meetings");
        return "meeting-list";
    }


    @PostMapping("/save-meeting")
    @ResponseBody
    public String saveMeeting(@RequestBody Meeting meetingForm){

        Meeting meeting = new Meeting();
        meeting.setId(meetingForm.getId());
        meeting.setName(meetingForm.getName());
        meeting.setDescription(meetingForm.getDescription());

        meetingService.saveOrUpdate(meeting);
        return "{\"result\":\"1\"}";
    }


    @GetMapping("/edit-meeting/{meeting_id}")
    public String editEmployee(@PathVariable(value="meeting_id") Integer meeting_id, Model md){
        Meeting m = meetingService.get(meeting_id);


        String title;
        if(meeting_id==0) title="Add New Meeting";
        else title="Edit Meeting";

        md.addAttribute("title",title);
        md.addAttribute("meeting",m);
        return "edit-meeting";
    }

    @PostMapping("/delete-meeting/{meeting_id}")
    public String deleteEmployee(@PathVariable(value="meeting_id") Integer meeting_id){
        meetingService.deleteById(meeting_id);
        return "{\"result\":\"1\"}";
    }

}
