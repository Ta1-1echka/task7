package controller;

import database.UserLoginDAO;
import entity.User;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tanya on 07.11.2016.
 */
@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView checkUser(ModelAndView modelAndView, @RequestParam("login") String login,
                                  @RequestParam("password") String password) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("database.xml");
        UserLoginDAO userLoginDAO = (UserLoginDAO) ctx.getBean("userLoginDAO");
        User user = userLoginDAO.verifyUser(login, password);
        if (user != null) {
            modelAndView.addObject("user", user);
            modelAndView.setViewName("welcome");
        } else {
            modelAndView.addObject("message", "Неверно введен логин или пароль");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
