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
            schedule.setTransferstation(rs.getString("transferstation"));
            schedule.setStationnumber(rs.getInt("stationnumber"));
            return schedule;
        }
    };

    @Override
    public List<Schedule> getAll() {
        return jdbcTemplate.query("SELECT * FROM Schedule", rowMapper);
    }

    @Override
    public List<Schedule> getAllByStation(String station) {
        return jdbcTemplate.query("SELECT * FROM schedule WHERE station = ?", rowMapper, station);
    }

    @Override
    public Schedule getById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM schedule WHERE id=?", rowMapper, id);
    }

    @Override
    public List<Schedule> getAllStation(){
        return jdbcTemplate.query("SELECT * FROM schedule", rowMapper);
    }

}
