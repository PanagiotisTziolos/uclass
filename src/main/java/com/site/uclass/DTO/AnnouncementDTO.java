package com.site.uclass.DTO;

import java.sql.Date;
import java.time.LocalDate;

import com.site.uclass.entities.Announcement;
import com.site.uclass.entities.Event;
import com.site.uclass.entities.Professor;

public class AnnouncementDTO {

    private String title;

    private String content;

    private LocalDate date;

    private Professor professor;

    private Event event;

    public AnnouncementDTO() {}

    public AnnouncementDTO(String title, String content, LocalDate date, Professor professor) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.professor = professor;
    }

    public Announcement toEntity() {
        Announcement announcement = new Announcement();

        announcement.setTitle(title);
        announcement.setContent(content);
        announcement.setDate(Date.valueOf(date));
        announcement.setProfessor(professor);

        return announcement;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return this.event;
    }
}
