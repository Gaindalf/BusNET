package busnet.dao.impl;

import busnet.dao.RolesDao;
import busnet.entity.Roles;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RolesDaoImpl implements RolesDao{

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Roles roles) {
        session.getCurrentSession().save(roles);
    }

    @Override
    public void edit(Roles roles) {
        session.getCurrentSession().update(roles);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete((id));
    }

    @Override
    public Roles getRole(int id) {
        return (Roles)session.getCurrentSession().get(Roles.class, id);
    }

    @Override
    public List getAllRoles() {
        return session.getCurrentSession().createQuery("FROM roles").list();
    }

    @Override
    public String getRoleName(int id) {
        String queryFromDB = "SELECT role_name FROM roles WHERE id = '" + id + "'";
        return session.getCurrentSession().createQuery(queryFromDB).toString();
    }
}
