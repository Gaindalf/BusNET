package busnet.controller;

import busnet.entity.Stations;
import busnet.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping("/addStation")
    public String setupForm(Map<String, Object> map) {
        Stations stations = new Stations();
        map.put("stations", stations);
        map.put("stationsList", stationService.getAllStationWithId());

        return "addStation";
    }

    @RequestMapping(value = "/addStation.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Stations stations, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Stations stationResult = new Stations();
        switch (action.toLowerCase()) {
            case "add":
                stationService.add(stations);
                stationResult = stations;
                break;
            case "edit":
                stationService.edit(stations);
                stationResult = stations;
                break;
            case "delete":
                stationService.delete(stations.getId());
                stationResult = new Stations();
                break;
            case "search":
                Stations searchedStation = stationService.getStation(stations.getId());
                stationResult = searchedStation != null ? searchedStation : new Stations();
                break;
        }
        map.put("stations", stationResult);
        map.put("stationsList", stationService.getAllStationWithId());
        return "addStation";
    }
}
