package busnet.service.impl;

import busnet.dao.ScheduleDao;
import busnet.entity.Schedule;
import busnet.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    @Autowired
    private ScheduleDao scheduleDao;

    @Transactional
    public void add(Schedule schedule) {
        scheduleDao.add(schedule);
    }

    @Transactional
    public void edit(Schedule schedule) {
        scheduleDao.edit(schedule);
    }

    @Transactional
    public void delete(int id) {
        scheduleDao.delete(id);
    }

    @Transactional
    public Schedule getSchedule(int id) {
        return scheduleDao.getSchedule(id);
    }

    @Transactional
    public List getAllSchedule() {
        return scheduleDao.getAllSchedule();
    }


}
