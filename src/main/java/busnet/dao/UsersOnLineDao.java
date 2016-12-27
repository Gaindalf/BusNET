package busnet.dao;

import busnet.entity.UsersOnLine;

public interface UsersOnLineDao {
    public void add(UsersOnLine usersOnLine);

    public void edit(UsersOnLine usersOnLine);

    public void delete(int id);

    public UsersOnLine getUsers(int id);

    public boolean getBoolean(String date, int runnumber, String username);
}
