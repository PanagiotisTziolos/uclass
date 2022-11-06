package com.site.uclass.services.interfaces;

import java.util.List;
import java.util.Map;

import com.site.uclass.entities.Event;

public interface IEventService {

    public void save(Event event);

    public Map<Integer, List<Event>> getMonthsEventsFromCurrentDay();
}
