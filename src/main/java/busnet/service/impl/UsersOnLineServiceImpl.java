package busnet.service.impl;

import busnet.dao.UsersOnLineDao;
import busnet.entity.UsersOnLine;
import busnet.service.UsersOnLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersOnLineServiceImpl implements UsersOnLineService{

    @Autowired
    private UsersOnLineDao usersOnLineDao;

    @Transactional
    public void add(UsersOnLine usersOnLine) {
        usersOnLineDao.add(usersOnLine);
    }

    @Transactional
    public void edit(UsersOnLine usersOnLine) {
        usersOnLineDao.edit(usersOnLine);
    }

    @Transactional
    public void delete(int id) {
        usersOnLineDao.delete(id);
    }

    @Transactional
    public UsersOnLine getUsers(int id) {
        return usersOnLineDao.getUsers(id);
    }

    @Transactional
    public boolean getBoolean(String date, int runnumber, String username){
        return usersOnLineDao.getBoolean(date, runnumber ,username);
    }
}
