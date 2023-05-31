package com.speakingclock.demo;

import com.speakingclock.demo.controller.TimeConverter;
import com.speakingclock.demo.controller.TimeConverterController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeConverterTest {

    @Test
    public void testConvertTimeToWords_PositiveScenarios() {
        // Positive scenarios for time-to-words conversion
        Assertions.assertEquals("Eight half", TimeConverter.convertTimeToWords("08:30"));
        Assertions.assertEquals("Midday", TimeConverter.convertTimeToWords("12:00"));
        Assertions.assertEquals("Two", TimeConverter.convertTimeToWords("02:00"));
        Assertions.assertEquals("Midday quarter", TimeConverter.convertTimeToWords("12:15"));
        Assertions.assertEquals("One", TimeConverter.convertTimeToWords("25:00"));
    }

    @Test
    public void testConvertTimeToWords_NegativeScenarios() {
        // Negative scenarios for time-to-words conversion
        Assertions.assertEquals("Invalid time format.", TimeConverter.convertTimeToWords("3"));
        Assertions.assertEquals("Invalid time format.", TimeConverter.convertTimeToWords("12"));
        Assertions.assertEquals("Invalid time format.", TimeConverter.convertTimeToWords("xyz"));
    }

    @Test
    public void testTimeConverterController_PositiveScenarios() {
        // Positive scenarios for the controller handling user input
        TimeConverterController controller = new TimeConverterController();

        Assertions.assertEquals("It's Midday", controller.convertTimeToWords("midday"));
        Assertions.assertEquals("It's Midnight", controller.convertTimeToWords("midnight"));
        Assertions.assertEquals("Eight half", controller.convertTimeToWords("08:30"));
    }

    @Test
    public void testTimeConverterController_NegativeScenarios() {
        // Negative scenarios for the controller handling user input
        TimeConverterController controller = new TimeConverterController();

        Assertions.assertEquals("Invalid time format.", controller.convertTimeToWords("one"));
        Assertions.assertEquals("Invalid time format.", controller.convertTimeToWords("twelve fourty"));
        Assertions.assertEquals("Invalid time format.", controller.convertTimeToWords("xyz"));
    }
}