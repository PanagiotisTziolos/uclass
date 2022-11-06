package com.site.uclass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.site.uclass.entities.Account;
import com.site.uclass.entities.Course;
import com.site.uclass.entities.Student;

import com.site.uclass.services.interfaces.ICourseService;
import com.site.uclass.services.interfaces.IRegisteredCourseService;
import com.site.uclass.services.interfaces.ISemesterService;
import com.site.uclass.services.interfaces.IStudentService;

@Controller
public class CourseController {
    
    @Autowired
    private ICourseService courseService;

    @Autowired
    private ISemesterService semesterService;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IRegisteredCourseService registeredCourseService;

    @GetMapping("/courses")
    public String coursesView(Model model) {
        model.addAttribute("semesters", semesterService.getAllSemesters());

        return "courses";
    }

    @GetMapping("/courses/{course_name}")
    public String courseView(Model model, @PathVariable String course_name, Authentication authentication) {

        Account account = (Account) authentication.getPrincipal();
        
        Course course = courseService.getCourseByName(course_name);

        model.addAttribute("course", course);

        if (account.hasRole("ROLE_STUDENT")) 
            model.addAttribute("registeredForCourse", 
                studentService.hasStudentRegisteredForCourse(
                    loggedStudent(authentication).getId(),
                    course.getId()
                )
            );

        return "course_info";
    }

    @PostMapping("/register")
    public String register(@RequestParam Long courseId, Model model, RedirectAttributes  attributes, Authentication authentication) {
        
        registeredCourseService.registerStudentForCourse(
            loggedStudent(authentication).getId(),
            courseId
        );

        attributes.addFlashAttribute("message", "You have successfully registered for " + getCourseName(courseId));

        return redirectToCourseString(courseId);
    }

    @PostMapping("/unregister")
    public String unregister(@RequestParam Long courseId, Model model, RedirectAttributes  attributes, Authentication authentication) {

        registeredCourseService.unregisterStudentFromCourse(
            registeredCourseService.getRegisteredCourse(
                courseId,
                loggedStudent(authentication).getId()
            )
        );

        attributes.addFlashAttribute("message", "You have successfully unregistered from " + getCourseName(courseId));

        return redirectToCourseString(courseId);
    }

    private String redirectToCourseString(long courseId) {
        String courseName = courseService.getCourseById(courseId).getName();
        
        return "redirect:/courses/" + courseName;
    }

    private String getCourseName(long courseId) {
        return courseService.getCourseById(courseId).getName();
    }

    private Student loggedStudent(Authentication authentication) {
        Account account = (Account) authentication.getPrincipal();

        return studentService.getStudentByAccountId(account.getId());
    }
}
