package com.site.uclass.entities;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate date;

    @Column(name = "content")
    private String description;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "announcement_id", referencedColumnName = "id")
    private Announcement announcement;

    public Event() {}

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    public Announcement getAnnouncement() {
        return this.announcement;
    }
}
