package com.site.uclass.services.interfaces;

import java.util.Optional;

import com.site.uclass.entities.Course;
import com.site.uclass.entities.Professor;

public interface ICourseService {
    
    public Iterable<Course> getAllCourses();

    public Course getCourseById(Long courseId);

    public Course getCourseByName(String name);
    
    public Professor getProfessorFromCourse(String name);

    public Optional<Course> searchForCourse(String text);
}
