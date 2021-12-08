package de.htwberlin.webtech.webtech.controllers;

import de.htwberlin.webtech.webtech.web.api.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping(path = "/cms")
    public String adminHome() {
        return "cms";
    }

    @GetMapping(path = "/cms/categories")
    public String getCategory() {
        return "category";
    }

    @GetMapping(path = "/cms/categories/add")
    public String getCategoryAdd() {
        return "categoryAdd";
    }


}
