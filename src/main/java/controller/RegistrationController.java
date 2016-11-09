package controller;

import database.UserLoginDAO;
import database.UserRegistrateDAO;
import entity.User;
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
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("database.xml");
        UserRegistrateDAO userRegistrateDAO = (UserRegistrateDAO) ctx.getBean("userRegistrateDAO");
        User user = userRegistrateDAO.findUserByLogin(login);
        if (user == null) {
            userRegistrateDAO.addUser(login, password, firstname, lastname, email);
            user = userRegistrateDAO.findUserByLogin(login);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("welcome");

        } else {
            modelAndView.addObject("message", "Пользователь с данным login уже сушествует");
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }
}
