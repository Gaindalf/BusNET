package busnet.controller;

import busnet.entity.Bus;
import busnet.entity.Roles;
import busnet.entity.Schedule;
import busnet.entity.Stations;
import busnet.service.BusService;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class ScheduleController {

    String[] splitNames;
    String newDate;
    String NewTime;
    boolean direction;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private BusService busService;

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
        Bus bus = new Bus();
        map.put("bus", bus);
        map.put("station", stations);
//        map.put("stationList", scheduleService.getAllByOne());
        map.put("stationList", stationService.getAllStationWithId());
        return "station";
    }

    @RequestMapping(value = "stationFrom.do", method = RequestMethod.GET)
    public String showStation(@RequestParam String name, Map<String, Object> map) {
        splitNames = name.split(",");
        Stations stations = new Stations();
        Bus bus = new Bus();
        System.out.println(splitNames[0]);
        System.out.println(splitNames[1]);
        System.out.println(scheduleService.getStationNumber(splitNames[0]));
        System.out.println(scheduleService.getStationNumber(splitNames[1]));
        int a = scheduleService.getStationNumber(splitNames[0]);
        int b = scheduleService.getStationNumber(splitNames[1]);
        if (a < b) {
            map.put("Message", "Маршрут:");
            map.put("directionList", scheduleService.getStationByStationAndDirection(a, b, true));
        } else if (a > b) {
            map.put("Message", "Маршрут:");
            map.put("directionList", scheduleService.getStationByStationAndDirection(b, a, false));
        } else {
            map.put("Message", "Вы выбрали одинаковые станции");
        }
        Date today = new Date();
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
        Date tomorrow = new Date(today.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_1 = new Date(tomorrow.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_2 = new Date(tomorrow_1.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_3 = new Date(tomorrow_2.getTime() + (24 * 60 * 60 * 1000));
        map.put("bus", bus);
        map.put("ButtonDate", "<input type=\"submit\" name=\"action\" value=\"Выбрать\"/>");
        map.put("station", stations);
        map.put("today", format2.format(today));
        map.put("tomorrow", format2.format(tomorrow));
        map.put("tomorrow_1", format2.format(tomorrow_1));
        map.put("tomorrow_2", format2.format(tomorrow_2));
        map.put("tomorrow_3", format2.format(tomorrow_3));
        map.put("nameOfTheDepartureStation", splitNames[0]);
        map.put("scheduleList3", scheduleService.getAllByStation(splitNames[0]));
        map.put("scheduleList4", scheduleService.getAllByStation(splitNames[1]));
//        map.put("stationscheduleList", stationService.getStations())
        map.put("nameOfTheDestinationStation", splitNames[1]);


        map.put("stationList", stationService.getAllStationWithId());
        return "station";
    }

    @RequestMapping(value = "stationDate.do", method = RequestMethod.GET)
    public String chooseDate(@RequestParam String date, Map<String, Object> map) {
        Stations stations = new Stations();
        Bus bus = new Bus();
        int a = scheduleService.getStationNumber(splitNames[0]);
        int b = scheduleService.getStationNumber(splitNames[1]);
        if (a < b) {
            map.put("Message", "Маршрут:");
            map.put("directionList", scheduleService.getStationByStationAndDirection(a, b, true));
            map.put("TimeList", scheduleService.getStationByStationAndDirection(a, a, true));
            direction = true;
        } else if (a > b) {
            map.put("Message", "Маршрут:");
            map.put("directionList", scheduleService.getStationByStationAndDirection(b, a, false));
            map.put("TimeList", scheduleService.getStationByStationAndDirection(a, a, false));
            direction = false;
        } else {
            map.put("Message", "Вы выбрали одинаковые станции");
        }
        Date today = new Date();
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
        Date tomorrow = new Date(today.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_1 = new Date(tomorrow.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_2 = new Date(tomorrow_1.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_3 = new Date(tomorrow_2.getTime() + (24 * 60 * 60 * 1000));
        map.put("ButtonTime", "<input type=\"submit\" name=\"action\" value=\"Выбрать\"/>");
        map.put("ButtonDate", "<input type=\"submit\" name=\"action\" value=\"Выбрать\"/>");
        map.put("bus", bus);
        map.put("station", stations);
        map.put("today", format2.format(today));
        map.put("tomorrow", format2.format(tomorrow));
        map.put("tomorrow_1", format2.format(tomorrow_1));
        map.put("tomorrow_2", format2.format(tomorrow_2));
        map.put("tomorrow_3", format2.format(tomorrow_3));
        System.out.println("Дата здесь : " + date);
        newDate = date;
        map.put("YourChoiceDate", "Вы выбрали: <br>" + date);
        map.put("nameOfTheDepartureStation", splitNames[0]);
        map.put("scheduleList3", scheduleService.getAllByStation(splitNames[0]));
        map.put("scheduleList4", scheduleService.getAllByStation(splitNames[1]));
        map.put("nameOfTheDestinationStation", splitNames[1]);
        map.put("bus", bus);
        map.put("station", stations);
        map.put("stationList", stationService.getAllStationWithId());
        return "station";
    }

    @RequestMapping(value = "stationTime.do", method = RequestMethod.GET)
    public String chooseTime(@RequestParam String time, Map<String, Object> map) {
        Stations stations = new Stations();
        Bus bus = new Bus();
        System.out.println(scheduleService.getStationNumber(splitNames[0]));
        System.out.println(scheduleService.getStationNumber(splitNames[1]));
        int a = scheduleService.getStationNumber(splitNames[0]);
        int b = scheduleService.getStationNumber(splitNames[1]);
        if (a < b) {
            map.put("Message", "Маршрут:");
            map.put("directionList", scheduleService.getStationByStationAndDirection(a, b, true));
            map.put("TimeList", scheduleService.getStationByStationAndDirection(a, a, true));
        } else if (a > b) {
            map.put("Message", "Маршрут:");
            map.put("directionList", scheduleService.getStationByStationAndDirection(b, a, false));
            map.put("TimeList", scheduleService.getStationByStationAndDirection(a, a, false));
        } else {
            map.put("Message", "Вы выбрали одинаковые станции");
        }
        Date today = new Date();
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
        Date tomorrow = new Date(today.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_1 = new Date(tomorrow.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_2 = new Date(tomorrow_1.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_3 = new Date(tomorrow_2.getTime() + (24 * 60 * 60 * 1000));
        map.put("ButtonTime", "<input type=\"submit\" name=\"action\" value=\"Выбрать\"/>");
        map.put("ButtonDate", "<input type=\"submit\" name=\"action\" value=\"Выбрать\"/>");
        map.put("bus", bus);
        map.put("station", stations);
        map.put("today", format2.format(today));
        map.put("tomorrow", format2.format(tomorrow));
        map.put("tomorrow_1", format2.format(tomorrow_1));
        map.put("tomorrow_2", format2.format(tomorrow_2));
        map.put("tomorrow_3", format2.format(tomorrow_3));
        System.out.println("Дата здесь : " + newDate);
        System.out.println("Время здесь : " + time);
        NewTime = time;
        map.put("YourChoiceDate", "Вы выбрали: <br>" + newDate);
        map.put("YourChoiceTime", "Вы выбрали: <br>" + time);
        map.put("BuyTicket", "<input type=\"submit\" name=\"action\" value=\"Оформить\"/>");
        map.put("Buy", "Покупка:");
        map.put("nameOfTheDepartureStation", splitNames[0]);
        map.put("scheduleList3", scheduleService.getAllByStation(splitNames[0]));
        map.put("scheduleList4", scheduleService.getAllByStation(splitNames[1]));
        map.put("nameOfTheDestinationStation", splitNames[1]);
        map.put("bus", bus);
        map.put("station", stations);
        map.put("stationList", stationService.getAllStationWithId());
        return "station";
    }

    @RequestMapping(value = "stationBuy.do", method = RequestMethod.GET)
    public String chooseBuy(Map<String, Object> map) {
        map.put("nameOfTheDepartureStation", splitNames[0]);
        map.put("nameOfTheDestinationStation", splitNames[1]);
        map.put("Date", newDate);
        map.put("Time", NewTime);
        map.put("BuyTicket", "<input type=\"submit\" name=\"action\" value=\"Купить\"/>");
        return "buy";

    }

    @RequestMapping(value = "Buy.do", method = RequestMethod.GET)
    public String Buy(Map<String, Object> map) {
        int runNumber = scheduleService.chooseRunNumber(splitNames[0], NewTime, direction);
        int a = scheduleService.getStationNumber(splitNames[0]);
        int b = scheduleService.getStationNumber(splitNames[1]);
        int one = busService.chooseRunNumber(newDate, runNumber).getOne();
        int two = busService.chooseRunNumber(newDate, runNumber).getTwo();
        int three = busService.chooseRunNumber(newDate, runNumber).getThree();
        int four = busService.chooseRunNumber(newDate, runNumber).getFour();
        int five = busService.chooseRunNumber(newDate, runNumber).getFive();
        int six = busService.chooseRunNumber(newDate, runNumber).getSix();
        int id = busService.chooseRunNumber(newDate, runNumber).getId();
        String selectdate = busService.chooseRunNumber(newDate, runNumber).getDate();
        String selecttime = busService.chooseRunNumber(newDate, runNumber).getTime();
        int selectRunNumber = busService.chooseRunNumber(newDate, runNumber).getRunnumber();
        if (one < 30 && two < 30 && three < 30 && four < 30 && five < 30 && six < 30) {
            if (a < b) {
                for (int i = a; i < b; i++) {
                    if (i == 1) {
                        if (one < 30) {
                            one++;
                        }

                    } else if (i == 2) {
                        if (two < 30) {
                            two++;
                        }
                    } else if (i == 3) {
                        if (three < 30) {
                            three++;
                        }
                    } else if (i == 4) {
                        if (four < 30) {
                            four++;
                        }
                    } else if (i == 5) {
                        if (five < 30) {
                            five++;
                        }
                    } else if (i == 6) {
                        if (six < 30) {
                            six++;
                        }
                    }
                    busService.edit(new Bus(id, selectdate, selecttime, selectRunNumber, one, two, three, four, five, six));
                    map.put("OK", "Вы купили билет");
                }
            } else if (a > b) {
                for (int i = a; i > b; i--) {
                    if (i == 1) {
                        if (one < 30) {
                            one++;
                        }
                    } else if (i == 2) {
                        if (two < 30) {
                            two++;
                        }
                    } else if (i == 3) {
                        if (three < 30) {
                            three++;
                        }
                    } else if (i == 4) {
                        if (four < 30) {
                            four++;
                        }
                    } else if (i == 5) {
                        if (five < 30) {
                            five++;
                        }
                    } else if (i == 6) {
                        if (six < 30) {
                            six++;
                        }
                    }
                }
                busService.edit(new Bus(id, selectdate, selecttime, selectRunNumber, one, two, three, four, five, six));
                map.put("OK", "Вы купили билет");
            }
        }else{
            map.put("OK", "билетов на данный маршрут больше нет");
        }

        map.put("nameOfTheDepartureStation", splitNames[0]);
        map.put("nameOfTheDestinationStation", splitNames[1]);
        map.put("Date", newDate);
        map.put("Time", NewTime);
        return "buy";
    }

    @RequestMapping("/insertStationTable")
    public String insertStationsTable(Model model) {
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_1 = new Date(tomorrow.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_2 = new Date(tomorrow_1.getTime() + (24 * 60 * 60 * 1000));
        Date tomorrow_3 = new Date(tomorrow_2.getTime() + (24 * 60 * 60 * 1000));
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        stationService.add(new Stations(1, "Sloane Square"));
        stationService.add(new Stations(2, "St. James's Park"));
        stationService.add(new Stations(3, "Westminster"));
        stationService.add(new Stations(4, "Waterloo"));
        stationService.add(new Stations(5, "Southwark"));
        stationService.add(new Stations(6, "London Bridge Station"));
        rolesService.add(new Roles(1, "ROLE_ADMIN"));
        rolesService.add(new Roles(2, "ROLE_USER"));
        busService.add(new Bus(1, "" + format.format(today) + "", "9:00", 1, 0, 0, 30, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(today) + "", "15:00", 2, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(today) + "", "12:00", 3, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(today) + "", "18:00", 4, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow) + "", "9:00", 1, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow) + "", "15:00", 2, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow) + "", "12:00", 3, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow) + "", "18:00", 4, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_1) + "", "9:00", 1, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_1) + "", "15:00", 2, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_1) + "", "12:00", 3, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_1) + "", "18:00", 4, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_2) + "", "9:00", 1, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_2) + "", "15:00", 2, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_2) + "", "12:00", 3, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_2) + "", "18:00", 4, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_3) + "", "9:00", 1, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_3) + "", "15:00", 2, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_3) + "", "12:00", 3, 0, 0, 0, 0, 0, 0));
        busService.add(new Bus(1, "" + format.format(tomorrow_3) + "", "18:00", 4, 0, 0, 0, 0, 0, 0));
        scheduleService.add(new Schedule(1, "1", "Sloane Square", "9:00", 1, true, 1));
        scheduleService.add(new Schedule(2, "1", "St. James's Park", "9:10", 2, true, 1));
        scheduleService.add(new Schedule(3, "1", "Westminster", "9:20", 3, true, 1));
        scheduleService.add(new Schedule(5, "1", "Waterloo", "9:40", 4, true, 1));
        scheduleService.add(new Schedule(6, "1", "Southwark", "9:50", 5, true, 1));
        scheduleService.add(new Schedule(7, "1", "London Bridge Station", "10:00", 6, true, 1));
        scheduleService.add(new Schedule(8, "1", "London Bridge Station", "15:00", 6, false, 2));
        scheduleService.add(new Schedule(9, "1", "Southwark", "15:10", 5, false, 2));
        scheduleService.add(new Schedule(10, "1", "Waterloo", "15:20", 4, false, 2));
        scheduleService.add(new Schedule(12, "1", "Westminster", "15:40", 3, false, 2));
        scheduleService.add(new Schedule(13, "1", "St. James's Park", "15:50", 2, false, 2));
        scheduleService.add(new Schedule(14, "1", "Sloane Square", "16:00", 1, false, 2));
        scheduleService.add(new Schedule(15, "1", "Sloane Square", "12:00", 1, true, 3));
        scheduleService.add(new Schedule(16, "1", "St. James's Park", "12:10", 2, true, 3));
        scheduleService.add(new Schedule(17, "1", "Westminster", "12:20", 3, true, 3));
        scheduleService.add(new Schedule(18, "1", "Waterloo", "12:40", 4, true, 3));
        scheduleService.add(new Schedule(19, "1", "Southwark", "12:50", 5, true, 3));
        scheduleService.add(new Schedule(20, "1", "London Bridge Station", "13:00", 6, true, 3));
        scheduleService.add(new Schedule(21, "1", "London Bridge Station", "18:00", 6, false, 4));
        scheduleService.add(new Schedule(22, "1", "Southwark", "18:10", 5, false, 4));
        scheduleService.add(new Schedule(23, "1", "Waterloo", "18:20", 4, false, 4));
        scheduleService.add(new Schedule(24, "1", "Westminster", "18:40", 3, false, 4));
        scheduleService.add(new Schedule(25, "1", "St. James's Park", "18:50", 2, false, 4));
        scheduleService.add(new Schedule(26, "1", "Sloane Square", "19:00", 1, false, 4));
        return "create";
    }
}