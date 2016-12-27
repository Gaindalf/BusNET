package busnet.dao.impl;

import busnet.dao.StationDao;
import busnet.entity.Schedule;
import busnet.entity.Stations;
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
public class StationDaoImpl implements StationDao {

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
    public void add(Stations stations) {
        session.getCurrentSession().save(stations);
    }

    @Override
    public void edit(Stations stations) {
        session.getCurrentSession().update(stations);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getStation(id));
    }

    @Override
    public Stations getStation(int id) {
        return (Stations) session.getCurrentSession().get(Stations.class, id);
    }

    @Override
    public Stations getName(String name) {
        return (Stations) session.getCurrentSession().get(Stations.class, name);
    }

    @Override
    public List<Stations> getAll() {
        return jdbcTemplate.query("SELECT * FROM Stations", rowMapper);
    }

    @Override
    public List getAllStationWithId() {
        return session.getCurrentSession().createQuery("FROM Stations").list();
    }

    @Override
    public void inputValues() {
        session.getCurrentSession().createQuery("INSERT INTO stations (id, name) VALUES (1, 'Sloane Square')");
    }

    private RowMapper<Stations> rowMapper = new RowMapper<Stations>() {
        @Override
        public Stations mapRow(ResultSet rs, int rowNum) throws SQLException {
            Stations stations = new Stations();
            stations.setId(rs.getInt("id"));
            stations.setName(rs.getString("name"));

            return stations;
        }
    };

    @Override
    public List<Stations> getAllStations() {
        return jdbcTemplate.query("SELECT name FROM Stations", rowMapperForNameOnly);
    }

    private RowMapper<Stations> rowMapperForNameOnly = new RowMapper<Stations>() {
        @Override
        public Stations mapRow(ResultSet rs, int rowNum) throws SQLException {
            Stations stations = new Stations();
            stations.setName(rs.getString("name"));

            return stations;
        }
    };

    @Override
    public List getStations(String a, String b) {
        return session.getCurrentSession().createQuery("SELECT * FROM Schedule WHERE stationnumber > '" + a + "' AND stationnumber < '" + b + "'").list();
    }
}
