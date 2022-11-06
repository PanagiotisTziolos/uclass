package com.site.uclass.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "announcements")
public class Announcement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title" )
    private String title;

    @Column(name = "content", columnDefinition="LONGTEXT" )
    private String content;

    @Column(name = "date" )
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date date;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "professor_id",
        nullable = false
    )
    private Professor professor;

    @OneToOne(
        mappedBy = "announcement", 
        cascade = CascadeType.ALL, 
        fetch = FetchType.LAZY
    )
    private Event event;

    public Announcement() {}
    
    public long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        return dateFormat.format(date);
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return this.event;
    }
}
