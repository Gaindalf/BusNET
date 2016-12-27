package busnet.service.impl;

import busnet.dao.BusDao;
import busnet.entity.Bus;
import busnet.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusDao busDao;

    @Transactional
    public void add(Bus bus) {
        busDao.add(bus);
    }

    @Transactional
    public void edit(Bus bus) {
        busDao.edit(bus);
    }

    @Transactional
    public void delete(int id) {
        busDao.delete(id);
    }

    @Transactional
    public Bus getBus(int id) {
        return busDao.getBus(id);
    }

    @Transactional
    public List getAllBuses() {
        return busDao.getAllBuses();
    }

    @Transactional
    public Bus chooseRunNumber(String date, int runnumber){
        return busDao.chooseRunNumber(date, runnumber);
    }
}
