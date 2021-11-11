package de.htwberlin.webtech.webtech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping(path = "/cms")
    public ModelAndView cms() {return new ModelAndView("cms");
    }

}
