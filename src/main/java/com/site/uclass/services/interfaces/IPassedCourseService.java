package com.site.uclass.services.interfaces;

import com.site.uclass.entities.PassedCourse;

public interface IPassedCourseService {
    
    public Iterable<PassedCourse> getStudentsPassedCourses(long studentId);
}
