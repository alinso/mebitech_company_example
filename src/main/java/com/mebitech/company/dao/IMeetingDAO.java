package com.mebitech.company.dao;

import com.mebitech.company.entity.Meeting;
import java.util.List;

public interface IMeetingDAO {

        public void saveOrUpdate(Meeting m);
        public Meeting get(Integer id);
        public List<Meeting> getAll();
        public void delete(Integer id);

}
