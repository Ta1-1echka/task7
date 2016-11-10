package controller;

import database.UserDAO;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tanya on 08.11.2016.
 */
@Controller
@RequestMapping("/edit")
@SessionAttributes("user")
public class EditUserController {

    @Autowired
    @Qualifier("userDAO")
    UserDAO userDAO;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView redirectEditPage(@SessionAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("editUser");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveUserEdition(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        User userFind = null, userBase = null;
        userBase = userDAO.findUserById(user.getIduser());
        if (!user.getLogin().equals(userBase.getLogin())) {
            userFind = userDAO.findUserByLogin(user.getLogin());
        }

        if (userFind == null) {
            userDAO.editUser(user);
            modelAndView.addObject("user", user);
            modelAndView.addObject("message", "Данные пользователя успешно изменены");
        } else {
            modelAndView.addObject("user", userBase);
            modelAndView.addObject("message", "Пользователь с данным login=" + user.getLogin() + " уже существует");
        }
        modelAndView.setViewName("editUser");
        return modelAndView;
    }
}
