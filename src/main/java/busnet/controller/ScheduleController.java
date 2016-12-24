package busnet.controller;

import busnet.entity.Roles;
import busnet.entity.Schedule;
import busnet.entity.Stations;
import busnet.service.RolesService;
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

    @Autowired
    private RolesService rolesService;

    @RequestMapping("/schedule")
    public String setupForm(Map<String, Object> map) {
        Schedule schedule = new Schedule();
        map.put("schedule", schedule);
        map.put("scheduleList", scheduleService.getAllSchedule());
        map.put("scheduleList2", scheduleService.getAllByStation("St. James's Park"));
        map.put("stationList", stationService.getAllStations());

        return "schedule";
    }

    @RequestMapping(value = "/schedule.do", method = RequestMethod.POST)
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
//        map.put("stationList", scheduleService.getAllByOne());
        map.put("stationList", stationService.getAllStationWithId());

        return "station";
    }

    @RequestMapping(value = "stationFrom.do", method = RequestMethod.GET)
    public String whowStation(@RequestParam String name, Map<String, Object> map) {
        String[] splitNames = name.split(",");
        Stations stations = new Stations();
        System.out.println(splitNames[0]);
        System.out.println(splitNames[1]);
        System.out.println(scheduleService.getStationNumber(splitNames[0]));
        System.out.println(scheduleService.getStationNumber(splitNames[1]));
        int a = scheduleService.getStationNumber(splitNames[0]);
        int b = scheduleService.getStationNumber(splitNames[1]);
        if(a < b){
            map.put("Message", "Маршрут:");
            map.put("directionList", scheduleService.getStationByStationAndDirection(a, b, true));
        } else if (a > b){
            map.put("Message", "Маршрут:");
            map.put("directionList", scheduleService.getStationByStationAndDirection(b, a, false));
        }else{
            map.put("Message", "Вы выбрали одинаковые станции");
        }
        map.put("station", stations);
        map.put("nameOfTheDepartureStation", splitNames[0]);
        map.put("scheduleList3", scheduleService.getAllByStation(splitNames[0]));
        map.put("scheduleList4", scheduleService.getAllByStation(splitNames[1]));
//        map.put("stationscheduleList", stationService.getStations())
        map.put("nameOfTheDestinationStation", splitNames[1]);



        map.put("stationList", stationService.getAllStationWithId());
        return "station";
    }

    @RequestMapping("/insertStationTable")
    public String insertStationsTable(Model model) {
        stationService.add(new Stations(1, "Sloane Square"));
        stationService.add(new Stations(2, "St. James's Park"));
        stationService.add(new Stations(3, "Westminster"));
        stationService.add(new Stations(4, "Waterloo"));
        stationService.add(new Stations(5, "Southwark"));
        stationService.add(new Stations(6, "London Bridge Station"));
        rolesService.add(new Roles(1, "ROLE_ADMIN"));
        rolesService.add(new Roles(2, "ROLE_USER"));
        scheduleService.add(new Schedule(1, "1", "Sloane Square", "9:00", 1, true));
        scheduleService.add(new Schedule(2, "1", "St. James's Park", "9:10", 2, true));
        scheduleService.add(new Schedule(3, "1", "Westminster", "9:20",  3, true));
        scheduleService.add(new Schedule(5, "1", "Waterloo", "9:40", 4, true));
        scheduleService.add(new Schedule(6, "1", "Southwark", "9:50", 5, true));
        scheduleService.add(new Schedule(7, "1", "London Bridge Station", "10:00", 6, true));
        scheduleService.add(new Schedule(8, "1", "London Bridge Station", "15:00", 6, false));
        scheduleService.add(new Schedule(9, "1", "Southwark", "15:10", 5, false));
        scheduleService.add(new Schedule(10, "1", "Waterloo", "15:20", 4, false));
        scheduleService.add(new Schedule(12, "1", "Westminster", "15:40", 3, false));
        scheduleService.add(new Schedule(13, "1", "St. James's Park", "15:50", 2, false));
        scheduleService.add(new Schedule(14, "1", "Sloane Square", "16:00", 1, false));
        return "create";
    }
}
