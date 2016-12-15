package busnet.service.impl;

import busnet.dao.RegistrationDao;
import busnet.entity.Users;
import busnet.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationDao registrationDao;

    @Transactional
    public void add(Users users) {
        registrationDao.add(users);
    }

    @Transactional
    public void edit(Users users) {
        registrationDao.edit(users);
    }

    @Transactional
    public void delete(int id) {
        registrationDao.delete(id);
    }

    @Transactional
    public Users getUser(int id) {
        return registrationDao.getUser(id);
    }

    @Transactional
    public List getAllUsers() {
        return registrationDao.getAllUsers();
    }

    @Transactional
    public String getUserName(String name) {
        return  registrationDao.getUserName(name);
    }
}
