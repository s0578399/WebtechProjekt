package de.htwberlin.webtech.webtech.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping(path = {"/", "/home"})
    public ModelAndView shop() {return new ModelAndView("shop");
    }

}
