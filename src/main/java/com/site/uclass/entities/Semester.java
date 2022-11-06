package com.site.uclass.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "semesters")
public class Semester {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(
        cascade = CascadeType.ALL,
        mappedBy = "semester"
    )
    private List<Course> courses;

    public Semester() {}

    public Semester(List<Course> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

}
