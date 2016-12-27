package busnet.dao.impl;

import busnet.dao.BusDao;
import busnet.entity.Bus;
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
public class BusDaoImpl implements BusDao {

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
    public void add(Bus bus) {
        session.getCurrentSession().save(bus);
    }

    @Override
    public void edit(Bus bus) {
        session.getCurrentSession().update(bus);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getBus(id));
    }

    @Override
    public Bus getBus(int id) {
        return (Bus) session.getCurrentSession().get(Bus.class, id);
    }

    @Override
    public List getAllBuses() {
        return session.getCurrentSession().createQuery("FROM Bus").list();
    }

    private RowMapper<Bus> rowMapperBus = new RowMapper<Bus>() {
        @Override
        public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bus bus = new Bus();
            bus.setId(rs.getInt("id"));
            bus.setDate(rs.getString("date"));
            bus.setTime(rs.getString("time"));
            bus.setRunnumber(rs.getInt("runnumber"));
            bus.setNumberOfPassengers(rs.getInt("numberofpassengers"));
            return bus;
        }
    };

    @Override
    public Bus chooseRunNumber(String date, int runnumber){
        return jdbcTemplate.queryForObject("SELECT * FROM Bus WHERE runnumber =? AND date =?", rowMapperBus, runnumber, date);
    }
}