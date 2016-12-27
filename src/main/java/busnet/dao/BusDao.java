package busnet.dao;

import busnet.entity.Bus;

import java.util.List;

public interface BusDao {
    public void add(Bus bus);

    public void edit(Bus bus);

    public void delete(int id);

    public Bus getBus(int id);

    public List getAllBuses();

    public Bus chooseRunNumber(String date, int runnumber);
}
