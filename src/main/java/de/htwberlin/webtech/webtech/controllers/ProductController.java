package de.htwberlin.webtech.webtech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class ProductController {

    @Controller
    public class ProductsController {

        @GetMapping(path = "/products")
        public ModelAndView products() {
            return new ModelAndView("products");
        }
    }
}
