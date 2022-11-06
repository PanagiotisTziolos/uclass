package com.site.uclass.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(
        cascade = CascadeType.ALL,
        mappedBy = "student"
    )
    private List<RegisteredCourse> registeredCourses;

    @OneToMany(
        cascade = CascadeType.ALL,
        mappedBy = "student"
    )
    private List<PassedCourse> passedCourses;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public List<RegisteredCourse> getRegisteredCourses() {
        return this.registeredCourses;
    }

    public List<PassedCourse> getPassedCourses() {
        return this.passedCourses;
    }
}
