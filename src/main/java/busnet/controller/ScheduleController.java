package busnet.controller;

import busnet.entity.Schedule;
import busnet.entity.Stations;
import busnet.service.ScheduleService;
import busnet.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private StationService stationService;

    @RequestMapping("/schedule/bus")
    public String setupForm(Map<String, Object> map) {
        Schedule schedule = new Schedule();
        map.put("schedule", schedule);
        map.put("scheduleList", scheduleService.getAllSchedule());
        map.put("scheduleList2", scheduleService.getAllByStation("St. James's Park"));
        map.put("stationList", stationService.getAllStations());

        return "schedule";
    }

    @RequestMapping(value = "/schedule/schedule.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Schedule schedule, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Schedule scheduleResult = new Schedule();
        switch (action.toLowerCase()) {
            case "add":
                scheduleService.add(schedule);
                scheduleResult = schedule;
                break;
            case "edit":
                scheduleService.edit(schedule);
                scheduleResult = schedule;
                break;
            case "delete":
                scheduleService.delete(schedule.getId());
                scheduleResult = new Schedule();
                break;
            case "search":
                Schedule searchedSchedule = scheduleService.getSchedule(schedule.getId());
                scheduleResult = searchedSchedule != null ? searchedSchedule : new Schedule();
                break;
        }

        map.put("schedule", scheduleResult);
        map.put("scheduleList", scheduleService.getAllSchedule());
        map.put("scheduleList2", scheduleService.getAllByStation("St. James's Park"));
        return "schedule";
    }

    @RequestMapping("/station")
    public String station(Map<String, Object> map) {
        Stations stations = new Stations();
        map.put("station", stations);
        map.put("stationList", stationService.getAllStationWithId());

        return "station";
    }

    @RequestMapping(value = "station.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Stations stations, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Stations stationResult = new Stations();
        switch (action.toLowerCase()) {
            case "Search":
                Stations searchedStation = stationService.getName(stations.getName());
                stationResult = searchedStation != null ? searchedStation : new Stations();
                break;
        }
        map.put("stations", stations);
        map.put("nameofstation", stationResult);
        map.put("stationList", stationService.getAllStationWithId());
        return "station";
    }

    @RequestMapping(value = "stationFrom.do", method = RequestMethod.GET)
    public String whowStation(@RequestParam String name, Map<String, Object> map) {
        String[] splitNames = name.split(",");
        Stations stations = new Stations();
        System.out.println(splitNames[0]);
        System.out.println(splitNames[1]);
        map.put("station", stations);
        map.put("nameOfTheDepartureStation", splitNames[0]);
        map.put("nameOfTheDestinationStation", splitNames[1]);
        map.put("stationList", stationService.getAllStationWithId());
        return "station";
    }

    @RequestMapping("/create")
    public String create(Model model) throws Exception {
//        stationService.inputValues();
//        Stations stations = new Stations();
        stationService.add(new Stations(1, "Sloane Square"));
        stationService.add(new Stations(2, "St. James's Park"));
        stationService.add(new Stations(3, "Westminster"));
        stationService.add(new Stations(4, "Waterloo"));
        stationService.add(new Stations(5, "Southwark"));
        stationService.add(new Stations(6, "London Bridge Station"));
        model.addAttribute("Hello", "Hello");
        return "create";
    }
}
