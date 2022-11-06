package com.site.uclass.services.interfaces;

import java.util.List;

import com.site.uclass.entities.RegisteredCourse;

public interface IRegisteredCourseService {

    public List<RegisteredCourse> getStudentsRegisteredCourses(long studentId);
    
    public void registerStudentForCourse(long studentId, long courseId);

    public void unregisterStudentFromCourse(RegisteredCourse registeredCourse);

    public RegisteredCourse getRegisteredCourse(long courseId, long studentId);
}
