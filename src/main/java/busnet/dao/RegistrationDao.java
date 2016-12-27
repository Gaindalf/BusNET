package busnet.dao;

import busnet.entity.Users;

import java.util.List;

public interface RegistrationDao {
    public void add(Users users);

    public void edit(Users users);

    public void delete(int id);

    public Users getUser(int id);

    public List getAllUsers();

    public String getUserName(String name);

//    public String getUserName();
}
