package com.site.uclass.util;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.stream.IntStream;

import org.springframework.ui.Model;

public class CustomCalendar {
    private LocalDate date;

    public CustomCalendar() {
        date = LocalDate.now();
    }

    private int getCurrentDayAsInt() {
        return date.getDayOfMonth();
    }

    private DayOfWeek getCurrentDayAsString() {
        return date.getDayOfWeek();
    }

    private Month getCurrentMonth() {
        return date.getMonth();
    }

    private int getCurrentYear() {
        return date.getYear();
    }

    private String getFullDate() {
        return String.format("%d %s %d", 
            date.getDayOfMonth(), date.withMonth(9).getMonth().toString(), date.getYear());
    }

    private int[] getMonthCallendar() {
        YearMonth monthOfYear = YearMonth.of(date.getYear(), date.getMonth());

        int firstDayOfMonth = LocalDate.now().withDayOfMonth(1).getDayOfWeek().getValue();
        
        return IntStream.range(-firstDayOfMonth + 2, monthOfYear.lengthOfMonth() + 1).toArray();
    }

    public void addCalendarInfo(Model model) {
        model.addAttribute("intDay", this.getCurrentDayAsInt());
        model.addAttribute("stringDay", this.getCurrentDayAsString());
        model.addAttribute("month", this.getCurrentMonth());
        model.addAttribute("year", this.getCurrentYear());
        model.addAttribute("numberOfMonthDays", this.getMonthCallendar());
        model.addAttribute("fullDate", this.getFullDate());
    }
}
