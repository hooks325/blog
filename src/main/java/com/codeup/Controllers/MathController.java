package com.codeup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nedwaldie on 2/7/17.
 */
@Controller
public class MathController {

    @GetMapping("/add/{number1}/and/{number2}")
    @ResponseBody
    public String add(@PathVariable int number1, @PathVariable int number2){
        int total = number1 + number2;
        return "<h1>The total is " +String.valueOf(total)+ ".</h1>";
    }

    @GetMapping("/subtract/{number1}/from/{number2}")
    @ResponseBody
    public String subtract(@PathVariable int number1, @PathVariable int number2){
        int total = number2 - number1;
        return "<h1>The total is " +String.valueOf(total)+ ".</h1>";
    }

    @GetMapping("/multiply/{number1}/and/{number2}")
    @ResponseBody
    public String multiply(@PathVariable int number1, @PathVariable int number2){
        int total = number1 * number2;
        return "<h1>The total is " +String.valueOf(total)+ ".</h1>";
    }

    @GetMapping("/divide/{number1}/by/{number2}")
    @ResponseBody
    public String divide(@PathVariable int number1, @PathVariable int number2){
        int total = number1 / number2;
        return "<h1>The total is " +String.valueOf(total)+ ".</h1>";
    }
}
