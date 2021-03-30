package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;
@Controller
public class TimeZoneController {

    @GetMapping("/")
    public String getTimeByTimezone(ModelMap modelMap, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // Get current time at local
        Date date = new Date();

        // get timezone by the local
        TimeZone timeZone = TimeZone.getDefault();

        // get timezone by the specified city
        TimeZone locale = TimeZone.getTimeZone(city);

        //calculate the current time in the specified ciry
      long locale_time = date.getTime() + (locale.getRawOffset() - locale.getRawOffset());

         //reset the date by locale_time
        date.setTime(locale_time);

        // set the data sent to the view

        modelMap.addAttribute("city",city);
        modelMap.addAttribute("date",date);
        return "index";
    }



}
