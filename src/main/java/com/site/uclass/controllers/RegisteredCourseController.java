package com.site.uclass.controllers;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.site.uclass.entities.Account;
import com.site.uclass.entities.Course;
import com.site.uclass.entities.Student;

import com.site.uclass.services.interfaces.IStudentService;

@Controller
public class RegisteredCourseController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/registeredCourses")
    public String studentView(Model model, Authentication authentication) {
        
        Account account = (Account) authentication.getPrincipal();

        Student student = studentService.getStudentByAccountId(account.getId());
            
        Map<Course, String> courseMap = new TreeMap<>((course1, course2) -> course1.getId().compareTo(course2.getId()));

        student.getRegisteredCourses().forEach(rc -> courseMap.put(rc.getCourse(), "Failed"));

        student.getPassedCourses().forEach(pc -> courseMap.put(pc.getCourse(), "Passed"));

        model.addAttribute("courses", courseMap);

        return "registered_courses";
    }
}
