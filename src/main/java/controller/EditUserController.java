package controller;

import entity.User;
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
    public ModelAndView saveUserEdition(@SessionAttribute("user") User user, ModelAndView modelAndView)
    {
       //TODO
        return modelAndView;
    }
}
