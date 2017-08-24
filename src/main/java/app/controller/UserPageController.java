package app.controller;

import app.dto.LoginDTO;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/lol")
public class UserPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String showUserPages(Map model) {
        LoginDTO loginDTO = new LoginDTO();
        model.put("login", loginDTO);

        return "lol";
    }
}
