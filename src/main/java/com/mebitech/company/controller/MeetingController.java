package com.mebitech.company.controller;

import com.mebitech.company.entity.Department;
import com.mebitech.company.entity.Meeting;
import com.mebitech.company.service.IDepartmentService;
import com.mebitech.company.service.IMeetingService;
import com.mebitech.company.viewModel.MeetingDepartmentFormViewModel;
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
        return Integer.toString(meeting.getId());
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
    @ResponseBody
    public String deleteEmployee(@PathVariable(value="meeting_id") Integer meeting_id){
        meetingService.deleteById(meeting_id);
        return "deleted";
    }

}
