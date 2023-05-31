package com.speakingclock.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time-converter")
public class TimeConverterController {
    @GetMapping("/{time}")
    public String convertTimeToWords(@PathVariable String time) {
        if (time.equalsIgnoreCase("midday")) {
            return "It's Midday";
        } else if (time.equalsIgnoreCase("midnight")) {
            return "It's Midnight";
        }

        String timeInWords = TimeConverter.convertTimeToWords(time);
        return timeInWords;
    }
}