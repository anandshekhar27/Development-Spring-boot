package com.asnluv2code.springcoredemo.rest;

import com.asnluv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach B;
@Autowired
    public void DemoController(@Qualifier("cricketCoach") Coach theCoach) {
    System.out.println("In Constructor: " + getClass().getSimpleName());
    this.myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
