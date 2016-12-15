package busnet.controller;

import busnet.entity.Schedule;
import busnet.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/schedule/bus")
    public String setupForm(Map<String, Object> map) {
        Schedule schedule = new Schedule();
        map.put("schedule", schedule);
        map.put("scheduleList", scheduleService.getAllSchedule());
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
        map.put("scheduleList2", scheduleService.getAllSchedule());
        return "schedule";
    }
}
