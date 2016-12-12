package busnet.dao;

import busnet.entity.Schedule;

import java.util.List;

public interface ScheduleDao {
    public void add(Schedule schedule);
    public void edit(Schedule schedule);
    public void delete(int id);
    public Schedule getSchedule(int id);
    public List getAllSchedule();

}
