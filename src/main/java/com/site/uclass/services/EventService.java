package com.site.uclass.services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.uclass.entities.Event;
import com.site.uclass.repository.EventRepository;
import com.site.uclass.services.interfaces.IEventService;

@Service
public class EventService implements IEventService {
    
    @Autowired
    private EventRepository eventRepository;

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Map<Integer, List<Event>> getMonthsEventsFromCurrentDay() {

        LocalDate currentDay = LocalDate.now();

        YearMonth yearMonth = YearMonth.of(currentDay.getYear(), currentDay.getMonth());

        LocalDate lastDayOfMonth = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), yearMonth.lengthOfMonth());

        List<Event> events = eventRepository.findByDateBetween(currentDay, lastDayOfMonth);

        return events.stream().collect(Collectors.groupingBy(e -> e.getDate().getDayOfMonth()));
    }
}
