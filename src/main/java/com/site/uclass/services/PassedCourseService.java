package com.site.uclass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.uclass.entities.PassedCourse;
import com.site.uclass.repository.PassedCoursesRepository;
import com.site.uclass.services.interfaces.IPassedCourseService;

@Service
public class PassedCourseService implements IPassedCourseService {

    @Autowired
    private PassedCoursesRepository repository;
    
    @Override
    public Iterable<PassedCourse> getStudentsPassedCourses(long studentId) {
        return repository.findByStudentId(studentId);
    }
    
}
