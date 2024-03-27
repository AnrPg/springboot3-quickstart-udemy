package com.devtiro.quickstart;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    @GetMapping(path = "/")
    public String helloWorld() {
        return "Hi!";
    }

    @GetMapping(path = "/workout")
    public String getDailyWorkout() {
        return "Run a hard 5km!";
    }

    @GetMapping(path = "/fortune")
    public String getDailyFortune(@RequestParam String date) {
        DateFormat dateString = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMANY);
        try {
            return "<h1>Your lucky day will be " + dateString.parse(date).toString() + "!!!</h1>";
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            System.err.println(date);
            return "Error parsing the date ;(";
        }
    }
    
}
