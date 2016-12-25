package busnet.dao.impl;

import busnet.dao.ScheduleDao;
import busnet.entity.Schedule;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ScheduleDaoImpl implements ScheduleDao{

    @Autowired
    private SessionFactory session;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

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

    private RowMapper<Schedule> rowMapper = new RowMapper<Schedule>() {
        @Override
        public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            Schedule schedule = new Schedule();
            schedule.setId(rs.getInt("id"));
            schedule.setLine(rs.getString("line"));
            schedule.setStation(rs.getString("station"));
            schedule.setTime(rs.getString("time"));
            schedule.setStationnumber(rs.getInt("stationnumber"));
            schedule.setDirection(rs.getBoolean("direction"));
            schedule.setRunnumber(rs.getInt("runnumber"));
            return schedule;
        }
    };

    private RowMapper<Schedule> rowMapperForStation = new RowMapper<Schedule>() {
        @Override
        public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            Schedule schedule = new Schedule();
            schedule.setStation(rs.getString("station"));
            return schedule;
        }
    };

    private RowMapper<Schedule> rowMapperForStationNumber = new RowMapper<Schedule>() {
        @Override
        public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            Schedule schedule = new Schedule();
            schedule.setStationnumber(rs.getInt("stationnumber"));
            return schedule;
        }
    };

    private RowMapper<Schedule> rowMapperForTime = new RowMapper<Schedule>() {
        @Override
        public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            Schedule schedule = new Schedule();
            schedule.setTime(rs.getString("time"));
            return schedule;
        }
    };

    @Override
    public List<Schedule> getAll() {
        return jdbcTemplate.query("SELECT * FROM Schedule", rowMapper);
    }

    @Override
    public List<Schedule> getAllByOne() {
        return jdbcTemplate.query("SELECT DISTINCT  station FROM Schedule", rowMapperForStation);
    }

    @Override
    public List<Schedule> getAllByStation(String station) {
        return jdbcTemplate.query("SELECT * FROM schedule WHERE station = ?", rowMapper, station);
    }

    @Override
    public List<Schedule> getDirectionByStation(String station) {
        return jdbcTemplate.query("SELECT direction FROM schedule WHERE station = ?", rowMapper, station);
    }

    @Override
    public Schedule getById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM schedule WHERE id=?", rowMapper, id);
    }

    @Override
    public Schedule getIdByName(String station) {
        return jdbcTemplate.queryForObject("SELECT * FROM schedule WHERE station=? LIMIT 1", rowMapper, station);
    }

    public int getStationNumber(String station){
        int a = getIdByName(station).getStationnumber();
        return a;
    }

    @Override
    public List<Schedule> getAllStation(){
        return jdbcTemplate.query("SELECT * FROM schedule", rowMapper);
    }

    @Override
    public List getStationByStationAndDirection(int a, int b, boolean direction){
        return session.getCurrentSession().createQuery("FROM Schedule WHERE direction = " + direction + " AND stationnumber BETWEEN " + a + " AND " + b).list();
//        return jdbcTemplate.query("SELECT time FROM schedule WHERE  direction = ? AND stationnumber BETWEEN a AND b", rowMapperForTime, a, b, direction);
    }

    @Override
    public int chooseRunNumber(String station, String time, boolean direction){
        return jdbcTemplate.queryForObject("SELECT * FROM Schedule WHERE direction =? AND station =? AND time =?", rowMapper, direction, station, time).getRunnumber();
    }
}
