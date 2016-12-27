package busnet.service.impl;

import busnet.dao.StationDao;
import busnet.entity.Stations;
import busnet.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StationServiceImpl implements StationService{

    @Autowired
    private StationDao stationDao;

    @Transactional
    public void add(Stations stations) {
        stationDao.add(stations);
    }

    @Transactional
    public void edit(Stations stations) {
        stationDao.edit(stations);
    }

    @Transactional
    public void delete(int id) {
        stationDao.delete(id);
    }

    @Transactional
    public List<Stations> getAll() {
        return stationDao.getAll();
    }

    @Transactional
    public Stations getStation(int id) {
        return stationDao.getStation(id);
    }

    @Transactional
    public Stations getName(String name) {
        return stationDao.getName(name);
    }

    @Transactional
    public List<Stations> getAllStations(){
        return stationDao.getAllStations();
    }

    @Transactional
    public List getAllStationWithId(){
        return stationDao.getAllStationWithId();
    }

    @Transactional
    public void inputValues() {
        stationDao.inputValues();
    }

    @Transactional
    public List getStations(String a, String b){
        return stationDao.getStations(a, b);
    }
}
