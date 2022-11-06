package com.site.uclass.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToOne(
        optional = false
    )
    @JoinColumn(
        name = "professor_id",
        nullable = false
    )
    private Professor professor;

    @ManyToOne(
        optional = false
    )
    @JoinColumn(
        name = "semester_id",
        nullable = false
    )
    private Semester semester;

    @OneToMany(
        cascade = CascadeType.ALL,
        mappedBy = "course"
    )
    private List<RegisteredCourse> registeredCourses;

    @OneToMany(
        cascade = CascadeType.ALL,
        mappedBy = "course"
    )
    private List<PassedCourse> passedCourses;

    public Course() {}

    public Course(String name, Professor professor, Semester semester) {
        this.name = name;
        this.professor = professor;
        this.semester = semester;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Professor professor) {
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public Semester getSemester() {
        return this.semester;
    }

    public List<RegisteredCourse> getStudents() {
        return this.registeredCourses;
    }
}
