package com.mebitech.company.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mebitech.company.entity.Department;
import com.mebitech.company.entity.Meeting;
import com.mebitech.company.service.IDepartmentService;
import com.mebitech.company.service.IMeetingService;
import com.mebitech.company.viewModel.MeetingDepartmentFormViewModel;
import com.mebitech.company.viewModel.MeetingEditViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class MeetingController {

    @Autowired
    IMeetingService meetingService;

    @Autowired
    IDepartmentService departmentService;




    @PostMapping("/add-department-to-meeting")
    public String  addDepartmentToMeeting(@RequestBody MeetingDepartmentFormViewModel mViewModel){
        Meeting meeting = meetingService.get(mViewModel.getMeetingId());
        if(meeting==null)
            meeting= new Meeting();
        Department newDepartment = departmentService.get(mViewModel.getDepartmentId());

        Set<Department>departments =  meeting.getDepartments();
        departments.add(newDepartment);

        meeting.setDepartments(departments);
        meetingService.saveOrUpdate(meeting);
        return null;
    }

    @PostMapping("/remove-department-from-meeting")
    public String  removeDepartmentFromMeeting(@RequestBody MeetingDepartmentFormViewModel mViewModel){
        Meeting meeting = meetingService.get(mViewModel.getMeetingId());
        Department theDepartment=null;

        Set<Department>departments =  meeting.getDepartments();

        for (Department d:departments) {
            if(d.getId() == mViewModel.getDepartmentId()){
                theDepartment  =d;
                break;
            }
        }
        departments.remove(theDepartment);

        meeting.setDepartments(departments);
        meetingService.saveOrUpdate(meeting);
        return null;
    }



    @GetMapping("/show-attendants/{meeting_id}")
    public String showAttendants(@PathVariable(value="meeting_id") Integer meeting_id, Model md){
        Meeting m = meetingService.get(meeting_id);
        Set<Department> enrolledDepartments = m.getDepartments();
        List<Department> allDepartments = departmentService.getAll();
        MeetingDepartmentFormViewModel meetingDepartment  =new MeetingDepartmentFormViewModel();

        md.addAttribute("meeting",m);
        md.addAttribute("meetingDepartment",meetingDepartment);
        md.addAttribute("enrolledDepartments",enrolledDepartments);
        md.addAttribute("allDepartments",allDepartments);

        return "show-attendants";
    }

    @GetMapping("/meetingListRest")
    @ResponseBody
    public String meetingListRest(Model md) throws Exception{
        List<Meeting> meetings = meetingService.getAll();
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(meetings);
        return jsonData;
    }


    @GetMapping("/meeting-list")
    public String meetingList(){
        return "meetingList";
    }


    @GetMapping("/editMeetingRest/{meeting_id}")
    @ResponseBody
    public String editMeetingRest(@PathVariable(value="meeting_id") Integer meeting_id) throws Exception{
        Meeting m = meetingService.get(meeting_id);

        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(m);
        return jsonData;
    }


    @GetMapping("/edit-meeting/{meeting_id}")
    public String editDepartment(@PathVariable(value="meeting_id") Integer meeting_id, Model md){
        md.addAttribute("meeting_id",meeting_id);
        return "editMeeting";
    }


    @PostMapping("/save-meeting")
    @ResponseBody
    public String saveMeeting(@RequestBody MeetingEditViewModel meetingEditViewModel){

        Meeting meeting = new Meeting();
        meeting.setId(meetingEditViewModel.getId());
        meeting.setName(meetingEditViewModel.getName());
        meeting.setDescription(meetingEditViewModel.getDescription());

        meetingService.saveOrUpdate(meeting);
        return Integer.toString(meeting.getId());
    }




    @PostMapping("/delete-meeting/{meeting_id}")
    @ResponseBody
    public String deleteEmployee(@PathVariable(value="meeting_id") Integer meeting_id){
        meetingService.deleteById(meeting_id);
        return "deleted";
    }

}
