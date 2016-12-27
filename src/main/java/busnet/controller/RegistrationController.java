package busnet.controller;

import busnet.entity.Users;
import busnet.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/reg")
    public String setupForm(Map<String, Object> map) {
        Users users = new Users();
        map.put("users", users);
        map.put("usersList", registrationService.getAllUsers());
        return "registration";
    }

    @RequestMapping(value = "/users.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Users users, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Users usersResult = new Users();
        switch (action.toLowerCase()) {
            case "зарегистрироваться":
                registrationService.add(users);
                usersResult = users;
                break;
        }

        map.put("users", usersResult);
        map.put("usersList", registrationService.getAllUsers());
        return "regOk";
    }
}
