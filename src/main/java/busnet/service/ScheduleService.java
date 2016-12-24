package busnet.service;

import busnet.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    public void add(Schedule schedule);
    public void edit(Schedule schedule);
    public void delete(int id);
    public Schedule getSchedule(int id);
    public List getAllSchedule();
    public List<Schedule> getAll();
    public Schedule getById(Integer id);
    public List<Schedule> getAllByStation(String station);
    public List<Schedule> getAllStation();
    public List<Schedule> getAllByOne();
    public List<Schedule> getDirectionByStation(String station);
    public Schedule getIdByName(String stationnu);
    public int getStationNumber(String station);
    public List getStationByStationAndDirection(int a, int b, boolean direction);
}
