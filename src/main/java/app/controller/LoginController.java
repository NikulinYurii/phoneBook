
package app.controller;

import app.dto.LoginDTO;
import app.dto.UserDTO;
import app.repository.UserRepository;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String showLoginForm(WebRequest request, Model model) {
        LoginDTO loginDTO = new LoginDTO();
        model.addAttribute("loginDTO", loginDTO);
        return "login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginDTO") LoginDTO loginDTO) {
        if (loginDTO != null && loginDTO.getLogin() != null && loginDTO.getPass() != null) {

            if (userService.chek(loginDTO.getLogin(), loginDTO.getPass())) {
                return "redirect:/lol";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "redirect:/user/login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "redirect:/user/login";
        }
    }
}
