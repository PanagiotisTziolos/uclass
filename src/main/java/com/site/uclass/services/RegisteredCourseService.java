package com.site.uclass.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.uclass.entities.RegisteredCourse;

import com.site.uclass.repository.CourseRepository;
import com.site.uclass.repository.RegisteredCoursesRepository;
import com.site.uclass.repository.StudentRepository;
import com.site.uclass.services.interfaces.IRegisteredCourseService;

@Service
public class RegisteredCourseService implements IRegisteredCourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private RegisteredCoursesRepository registeredCoursesRepo;

    @Override
    public List<RegisteredCourse> getStudentsRegisteredCourses(long studentId) {
        List<RegisteredCourse> studentCourses = registeredCoursesRepo.findByStudentId(studentId);

        return studentCourses;
    }

    @Override
    public void registerStudentForCourse(long studentId, long courseId) {
        registeredCoursesRepo.save(
            new RegisteredCourse(
                studentRepo.findById(studentId).get(),
                courseRepo.findById(courseId).get()
            )
        );
    }

    @Override
    public void unregisterStudentFromCourse(RegisteredCourse registeredCourse) {
        registeredCoursesRepo.delete(registeredCourse);
    }

    @Override
    public RegisteredCourse getRegisteredCourse(long courseId, long studentId) {
        return registeredCoursesRepo.findByCourseIdAndStudentId(courseId, studentId);
    }    
}
