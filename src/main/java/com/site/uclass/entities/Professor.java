package com.site.uclass.entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="professors")
public class Professor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private long phone;

    @Column(name="section")
    private String section;

    @Column(name="office")
    private String office;

    @OneToMany(
        cascade = CascadeType.ALL,
        mappedBy = "professor")
    private List<Course> courses;

    @OneToMany(
        cascade = CascadeType.ALL,
        mappedBy = "professor")
    private List<Announcement> announcements;

    public Professor() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(List<Course> courses) {
        this.courses = courses;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public String getEmail() {
        return this.email;
    }

    public long getPhone() {
        return this.phone;
    }

    public String getSection() {
        return this.section;
    }

    public String getOffice() {
        return this.office;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }
}
