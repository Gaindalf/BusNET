package busnet.dao;

import busnet.entity.Schedule;

import java.util.List;

public interface ScheduleDao {
    public void add(Schedule schedule);
    public void edit(Schedule schedule);
    public void delete(int id);
    public Schedule getSchedule(int id);
    public List getAllSchedule();
    public Schedule getById(Integer id);
    public List<Schedule> getAll();
    public List<Schedule> getAllByStation(String station);
    public List<Schedule> getAllStation();
    public List<Schedule> getAllByOne();
    public List<Schedule> getDirectionByStation(String station);
    public Schedule getIdByName(String station);
    public int getStationNumber(String station);
    public List getStationByStationAndDirection(int a, int b, boolean direction);
    public int chooseRunNumber(String station, String time, boolean direction);

}
