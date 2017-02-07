package com.codeup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nedwaldie on 2/7/17.
 */
@Controller
public class HelloWorld {

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return formatGreeting(name);
    }

    private String formatGreeting(String name) {
        return "<h1>Hello " + name + " from Spring!!!!</>";
    }



}

