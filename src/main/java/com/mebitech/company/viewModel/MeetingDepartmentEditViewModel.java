package com.mebitech.company.viewModel;

import com.mebitech.company.entity.Department;
import com.mebitech.company.entity.Meeting;

import java.util.List;
import java.util.Set;

public class MeetingDepartmentEditViewModel {
    private Meeting meeting;
    private List<Department> allDepartments;
    private  Set<Department> meetimgDepartments;
    private  MeetingDepartmentFormViewModel meetingDepartmentFormViewModel;

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public List<Department> getAllDepartments() {
        return allDepartments;
    }

    public void setAllDepartments(List<Department> allDepartments) {
        this.allDepartments = allDepartments;
    }

    public Set<Department> getMeetimgDepartments() {
        return meetimgDepartments;
    }

    public void setMeetimgDepartments(Set<Department> meetimgDepartments) {
        this.meetimgDepartments = meetimgDepartments;
    }

    public MeetingDepartmentFormViewModel getMeetingDepartmentFormViewModel() {
        return meetingDepartmentFormViewModel;
    }

    public void setMeetingDepartmentFormViewModel(MeetingDepartmentFormViewModel meetingDepartmentFormViewModel) {
        this.meetingDepartmentFormViewModel = meetingDepartmentFormViewModel;
    }
}
