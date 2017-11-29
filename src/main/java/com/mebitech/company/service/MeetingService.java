package com.mebitech.company.service;

import com.mebitech.company.dao.IMeetingDAO;
import com.mebitech.company.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService implements IMeetingService {


    @Autowired
    IMeetingDAO dao;


    @Override
    public Meeting get(Integer id) {
        return  dao.get(id);
    }

    @Override
    public List<Meeting> getAll() {
        return dao.getAll();
    }


    @Override
    public void saveOrUpdate(Meeting m) {
        dao.saveOrUpdate(m);

    }

    @Override
    public void deleteById(Integer id) {
        dao.delete(id);
    }
}
