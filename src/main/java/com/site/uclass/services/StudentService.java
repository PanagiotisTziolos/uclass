package com.site.uclass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.uclass.entities.Student;
import com.site.uclass.repository.StudentAccountRepository;
import com.site.uclass.repository.StudentRepository;
import com.site.uclass.services.interfaces.IStudentService;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private StudentAccountRepository studentAccountRepository;

    @Override
    public Student getStudent(long studentId) {
        return studentRepo.findById(studentId).get();
    }

    @Override
    public Student getStudent(String name) {
        return studentRepo.findByName(name);
    }

    @Override
    public Student getStudentByAccountId(long accountId) {
        return studentAccountRepository.findByAccountId(accountId).getStudent();
    }

    @Override
    public boolean hasStudentRegisteredForCourse(long studentId, long courseId) {
        Student student = studentRepo.findById(studentId).get();
        
        if (student.getRegisteredCourses().stream().filter(rc -> rc.getCourse().getId() == courseId).findFirst().isPresent()) {
            return true;
        }

        return false;
    }
    
}
