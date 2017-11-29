package com.mebitech.company.dao;

import com.mebitech.company.entity.Meeting;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MeetingDAO implements IMeetingDAO {

    @Autowired
    SessionFactory sessionFactory;


    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void saveOrUpdate(Meeting m) {
        getCurrentSession().saveOrUpdate(m);
    }

    @Transactional
    public Meeting get(Integer id) {

        Meeting m =   getCurrentSession().get( Meeting.class, id );
        if(m==null)
            m = new Meeting();
        return m;

    }

    @Transactional
    public List<Meeting> getAll() {
        return getCurrentSession().createQuery( "from Meeting" ).list();
    }

    @Transactional
    public void delete(Integer id) {
        Meeting m  =get(id);
        getCurrentSession().delete(m);

    }
}
