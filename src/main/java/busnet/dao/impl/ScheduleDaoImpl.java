package busnet.dao.impl;

import busnet.dao.ScheduleDao;
import busnet.entity.Schedule;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDaoImpl implements ScheduleDao{

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Schedule schedule) {
        session.getCurrentSession().save(schedule);
    }

    @Override
    public void edit(Schedule schedule) {
        session.getCurrentSession().update(schedule);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getSchedule(id));
    }

    @Override
    public Schedule getSchedule(int id) {
        return (Schedule)session.getCurrentSession().get(Schedule.class, id);
    }

    @Override
    public List getAllSchedule() {
        return session.getCurrentSession().createQuery("FROM Schedule").list();
    }
}
