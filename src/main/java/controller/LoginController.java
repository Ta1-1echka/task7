package controller;

import database.UserLoginDAO;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tanya on 07.11.2016.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView checkUser(ModelAndView modelAndView, @RequestParam("login") String login,
                                  @RequestParam("password") String password) {

        User user = new UserLoginDAO().verifyUser(login, password);
        if (user != null)
            modelAndView.addObject("message", user.getFirstname() + " " + user.getLastname());
        else modelAndView.addObject("message", "false");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
