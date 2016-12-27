package busnet.service.impl;

import busnet.dao.RolesDao;
import busnet.entity.Roles;
import busnet.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService{

    @Autowired
    private RolesDao rolesDao;

    @Transactional
    public void add(Roles roles) {
        rolesDao.add(roles);
    }

    @Transactional
    public void edit(Roles roles) {
        rolesDao.edit(roles);
    }

    @Transactional
    public void delete(int id) {
        rolesDao.delete(id);
    }

    @Transactional
    public Roles getRole(int id) {
        return rolesDao.getRole(id);
    }

    @Transactional
    public List getAllRoles() {
        return rolesDao.getAllRoles();
    }

    @Transactional
    public String getRoleName(int id) {
        return  rolesDao.getRoleName(id);
    }
}
