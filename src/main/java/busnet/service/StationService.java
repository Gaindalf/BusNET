package busnet.service;

import busnet.entity.Stations;

import java.util.List;

public interface StationService {
    public void add(Stations stations);

    public void edit(Stations stations);

    public void delete(int id);

    public List<Stations> getAll();

    public List<Stations> getAllStations();

    public Stations getStation(int id);
    public Stations getName(String name);
    public List getAllStationWithId();
    public void inputValues();
    public List getStations(String a, String b);
}
