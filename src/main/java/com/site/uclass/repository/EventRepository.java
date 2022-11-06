package com.site.uclass.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
    
    public List<Event> findByDateBetween(LocalDate currentDay, LocalDate lastDayOfMonth);
}