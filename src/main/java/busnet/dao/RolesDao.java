package busnet.dao;

import busnet.entity.Roles;

import java.util.List;

public interface RolesDao {
    public void add(Roles roles);

    public void edit(Roles roles);

    public void delete(int id);

    public Roles getRole(int id);

    public List getAllRoles();

    public String getRoleName(int id);
}
