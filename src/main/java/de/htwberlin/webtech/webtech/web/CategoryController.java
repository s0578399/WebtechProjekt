package de.htwberlin.webtech.webtech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class CategoryController {

    @Controller
    public class CategoriesController {

        @GetMapping(path = "/categories")
        public ModelAndView categories() {
            return new ModelAndView("categories");
        }

    }
}
