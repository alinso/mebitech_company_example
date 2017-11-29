package com.mebitech.company.service;

import com.mebitech.company.entity.Meeting;

import java.util.List;

public interface IMeetingService {

     Meeting get(Integer id);

    List<Meeting> getAll();



    void saveOrUpdate(Meeting e);

    void deleteById(Integer id);
}

