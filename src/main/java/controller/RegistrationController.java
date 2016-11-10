package controller;

import database.UserDAO;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tanya on 07.11.2016.
 */
@Controller
@RequestMapping("/registration")
@SessionAttributes("user")
public class RegistrationController {

    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView registration(ModelAndView modelAndView, @RequestParam("login") String login,
                                     @RequestParam("password") String password,
                                     @RequestParam("firstname") String firstname,
                                     @RequestParam("lastname") String lastname,
                                     @RequestParam("email") String email) {
        User user = userDAO.findUserByLogin(login);
        if (user == null) {
            userDAO.addUser(login, password, firstname, lastname, email);
            user = userDAO.findUserByLogin(login);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("welcome");

        } else {
            modelAndView.addObject("message", "Пользователь с данным login уже сушествует");
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }
}
