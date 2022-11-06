package com.site.uclass.services.interfaces;

import com.site.uclass.entities.Student;

public interface IStudentService {

    public Student getStudent(long studentId);
    
    public Student getStudent(String name);

    public Student getStudentByAccountId(long accountId);

    public boolean hasStudentRegisteredForCourse(long studentId, long courseId);
}
