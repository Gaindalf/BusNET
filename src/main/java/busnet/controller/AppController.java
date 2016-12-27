package busnet.controller;

import busnet.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/")
    public String hello(Model model) {
        if(!SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().equals("[ROLE_ANONYMOUS]")) {
            model.addAttribute("Login", ", " + SecurityContextHolder.getContext().getAuthentication().getName() + ".");
            model.addAttribute("Exit", "Выход");
            model.addAttribute("Station", "Покупка билета");
            if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().equals("[ROLE_ADMIN]")){
                model.addAttribute("Schedule", "Редактировать расписание и автобусы");
                model.addAttribute("addStation", "<a href=\"/addStation\">Редактировать Станции</a><br>");
            }
        } else{
            model.addAttribute("Login", ", Гость.");
            model.addAttribute("Registration", "Регистрация");
            model.addAttribute("Enter", "<a href=\"/login\">Войти<a/>");
        }
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return "hello";
    }

    @RequestMapping("/confidential/page")
    public String secureTable(Model model){
        model.addAttribute("secure", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("secure1", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return "secure";
    }

    @RequestMapping(value = {"hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("encode");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        return modelAndView;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
