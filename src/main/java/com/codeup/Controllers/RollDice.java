package com.codeup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by nedwaldie on 2/8/17.
 */
@Controller
public class RollDice {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{userNumber}")
    public String pageWithNumber(@PathVariable int userNumber, Model model) {
        Random rand = new Random();
        int diceRoll = rand.nextInt(6) + 1;

        int userGuess = userNumber;

        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("userGuess", userGuess);

        return "{userNumber}";
    }
}
