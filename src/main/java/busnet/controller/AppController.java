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
        if(SecurityContextHolder.getContext().getAuthentication().getName().toString() != "anonymousUser") {
            model.addAttribute("Name", ", " + SecurityContextHolder.getContext().getAuthentication().getName() + ".");
            model.addAttribute("Exit", "Выход");
            model.addAttribute("usersList", registrationService.getUsername());

        } else{
            model.addAttribute("Name", ", Гость.");
            model.addAttribute("Registration", "Регистрация");
            model.addAttribute("Enter", "<a href=\"/login\">Войти<a/>");
        }
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

//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//    }

//    @RequestMapping("/insert")
//    public String insert(Model model) {
//
//        return "register";
//    }

//    @RequestMapping(value = "/station/new", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String addNewStation(String json) {
//        Station sender = new Station();
//        sender.setStationName(SecurityContextHolder.getContext().getAuthentication().getName());
//        return "hello";
//    }
}
