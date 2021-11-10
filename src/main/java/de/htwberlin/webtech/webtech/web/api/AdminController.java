package de.htwberlin.webtech.webtech.web.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/cms")
    public String cms() {
        return "cms";
    }
}
