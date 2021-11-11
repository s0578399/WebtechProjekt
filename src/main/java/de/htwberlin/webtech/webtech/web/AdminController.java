package de.htwberlin.webtech.webtech.web;

import de.htwberlin.webtech.webtech.web.api.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping(path = "/cms")
    public ModelAndView getCms() {return new ModelAndView("cms");
    }

    @GetMapping(path = "/cms/category")
    public ModelAndView getCategory() {return new ModelAndView("category");
    }

    @GetMapping(path = "/cms/product")
    public ModelAndView getProduct() {return new ModelAndView("product");
    }


}
