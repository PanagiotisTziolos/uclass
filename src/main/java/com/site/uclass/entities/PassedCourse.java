package com.site.uclass.entities;

import javax.persistence.*;

@Entity
@Table(name = "passed_courses")
public class PassedCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(
        optional = false
    )
    @JoinColumn(
        name = "student_id",
        nullable = false
    )
    private Student student;

    @ManyToOne(
        optional = false
    )
    @JoinColumn(
        name = "course_id",
        nullable = false
    )
    private Course course;

    public PassedCourse() {}

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return this.course;
    }
}
