package controller;

import database.UserDAO;
import entity.User;
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

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView redirectEditPage(@SessionAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("editUser");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveUserEdition(@ModelAttribute("user") User user, @SessionAttribute("user") User sessionUser,
                                        ModelAndView modelAndView) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("database.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        User userFind = null;
        if (!user.getLogin().equals(sessionUser.getLogin()))
            userFind = userDAO.findUserByLogin(user.getLogin());
        if (userFind == null) {
            userDAO.editUser(user);
            user = userDAO.findUserByLogin(sessionUser.getLogin());
            modelAndView.addObject("user", user);
            modelAndView.addObject("message", "Данные пользователя успешно изменены");
        } else {
            modelAndView.addObject("user", sessionUser);
            modelAndView.addObject("message", "Пользователь с данным login=" + user.getLogin() + " уже существует");
        }
        modelAndView.setViewName("editUser");
        return modelAndView;
    }
}
