package controller;

import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserDAO;

@Controller
@RequestMapping("users")
public class UserController {
    private static UserDAO userDAO = new UserDAO();
    @GetMapping("")
    public ModelAndView showFormLogin(){
        ModelAndView modelAndView = new ModelAndView("home","login",new Login());
        return modelAndView;
    }
    @PostMapping("")
    public ModelAndView login(@ModelAttribute Login login){
        ModelAndView modelAndView = new ModelAndView("home");
        User user = userDAO.checkLogin(login);
        if (user == null) return new ModelAndView("error");
        else return new ModelAndView("detail","user",user);
    }
}
