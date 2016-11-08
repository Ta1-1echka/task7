package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tanya on 08.11.2016.
 */
@Controller
@RequestMapping("/edit")
public class EditUserController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView redirectEditPage(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("editUser");
        return modelAndView;
    }
}
