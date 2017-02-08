package com.codeup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nedwaldie on 2/7/17.
 */
@Controller
public class HelloWorld {

    @GetMapping("/home")
    public String homePage() {
        return "home"; // home.html
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return formatGreeting(name);
    }

    private String formatGreeting(String name) {
        return "<h1>Hello " + name + " from Spring!!!!</>";
    }

    @GetMapping("/default")
    public String showDeault(Model model) {
        List<String> names = new ArrayList<>();

        names.add("John");
        names.add("Jane");
        names.add("Bob");
        names.add("Ned");

        model.addAttribute("names", names);
        return "default";
    }



}

