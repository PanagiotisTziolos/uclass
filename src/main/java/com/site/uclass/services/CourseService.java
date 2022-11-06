package com.site.uclass.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.uclass.entities.Course;
import com.site.uclass.entities.Professor;
import com.site.uclass.repository.CourseRepository;
import com.site.uclass.services.interfaces.ICourseService;

@Service
public class CourseService implements ICourseService{

    @Autowired
    private CourseRepository repository;
    
    @Override
    public Iterable<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return repository.findById(courseId).get();
    }

    @Override
    public Course getCourseByName(String name) {
        return repository.findByName(name).get();
    }

    @Override
    public Professor getProfessorFromCourse(String name) {
        return repository.findByName(name).get().getProfessor();
    }

    @Override
    public Optional<Course> searchForCourse(String text) {
        return repository.findByName(text);
    }
}
