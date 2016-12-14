package busnet.dao.impl;

import busnet.dao.RegistrationDao;
import busnet.entity.Users;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistrationDaoImpl implements RegistrationDao{

    @Autowired
    private SessionFactory session;


    @Override
    public void add(Users users) {
        session.getCurrentSession().save(users);
    }

    @Override
    public void edit(Users users) {
        session.getCurrentSession().update(users);
    }

    @Override
    public void delete(int id) {
        session.getCurrentSession().delete(getUser(id));
    }

    @Override
    public Users getUser(int id) {
        return (Users)session.getCurrentSession().get(Users.class, id);
    }

    @Override
    public List getAllUsers() {
        return session.getCurrentSession().createQuery("FROM Users").list();
    }

//    public String getUserName() {
//        return session.getCurrentSession().createQuery("SELECT Name FROM Users WHERE ").toString();
//    }
}
