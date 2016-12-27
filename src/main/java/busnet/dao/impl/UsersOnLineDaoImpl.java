package busnet.dao.impl;

import busnet.dao.UsersOnLineDao;
import busnet.entity.UsersOnLine;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UsersOnLineDaoImpl implements UsersOnLineDao{

    @Autowired
    private SessionFactory session;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(UsersOnLine usersOnLine) {
        session.getCurrentSession().save(usersOnLine);
    }

    @Override
    public void edit(UsersOnLine usersOnLine) {
        session.getCurrentSession().update(usersOnLine);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getUsers(id));
    }

    @Override
    public UsersOnLine getUsers(int id) {
        return (UsersOnLine) session.getCurrentSession().get(UsersOnLine.class, id);
    }

    @Override
    public boolean getBoolean(String date, int runnumber, String username) {
        return jdbcTemplate.query("SELECT * FROM UsersOnLine WHERE date=? AND runnumber =? AND username=?", rowMapper, date, runnumber, username).isEmpty();
    }

    private RowMapper<UsersOnLine> rowMapper = new RowMapper<UsersOnLine>() {
        @Override
        public UsersOnLine mapRow(ResultSet rs, int rowNum) throws SQLException {
            UsersOnLine usersOnLine = new UsersOnLine();
            usersOnLine.setId(rs.getInt("id"));
            usersOnLine.setUserName(rs.getString("username"));
            usersOnLine.setDate(rs.getString("date"));
            usersOnLine.setRunnumber(rs.getInt("runnumber"));
            return usersOnLine;
        }
    };
}
