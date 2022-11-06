package com.site.uclass.DTO;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.site.uclass.entities.Event;

public class EventDTO {
    
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private LocalDate date;

    private String description;

    private AnnouncementDTO announcementDTO;

    public EventDTO(LocalDate date, String description, AnnouncementDTO announcementDTO) {
        this.date = date;
        this.description = description;
        this.announcementDTO = announcementDTO;
    }

    public Event toEntity() {
        Event event = new Event();
        
        event.setDate(date);
        event.setDescription(description);
        event.setAnnouncement(announcementDTO.toEntity());

        return event;
    }
}
