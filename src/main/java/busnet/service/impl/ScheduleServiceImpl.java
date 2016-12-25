package busnet.service.impl;

import busnet.dao.ScheduleDao;
import busnet.entity.Schedule;
import busnet.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
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

    @Transactional
    public List<Schedule> getAll() {
        return scheduleDao.getAll();
    }

    @Transactional
    public Schedule getById(Integer id) {
        return scheduleDao.getById(id);
    }

    @Transactional
    public List<Schedule> getAllByStation(String station) {
        return scheduleDao.getAllByStation(station);
    }

    @Transactional
    public List<Schedule> getAllStation(){
        return scheduleDao.getAllStation();
    }

    @Transactional
    public List<Schedule> getAllByOne(){
        return scheduleDao.getAllByOne();
    }

    @Transactional
    public List<Schedule> getDirectionByStation(String station){
        return scheduleDao.getDirectionByStation(station);
    }

    @Transactional
    public Schedule getIdByName(String station){
        return scheduleDao.getIdByName(station);
    }

    @Transactional
    public int getStationNumber(String station){
        return scheduleDao.getStationNumber(station);
    }

    @Transactional
    public List getStationByStationAndDirection(int a, int b, boolean direction){
        return scheduleDao.getStationByStationAndDirection(a,b, direction);
    }

    @Transactional
    public int chooseRunNumber(String station, String time, boolean direction){
        return scheduleDao.chooseRunNumber(station, time, direction);
    }
}
