package com.luv2de.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketeCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minutes.";
    }

}
