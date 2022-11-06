package com.site.uclass.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.uclass.entities.Course;
import com.site.uclass.entities.Professor;
import com.site.uclass.services.interfaces.ICourseService;
import com.site.uclass.services.interfaces.IProfessorService;

@Controller
public class SearchController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IProfessorService professorService;
    
    @PostMapping(value = "search")
    public String search(@RequestParam String text) {

        Optional<Course> courseResult = courseService.searchForCourse(text);

        if(courseResult.isPresent())
            return "redirect:/courses/" + courseResult.get().getName();
            
        Optional<Professor> profesorResult = professorService.searchForProfessor(text);

        if(profesorResult.isPresent())
            return "redirect:/professors/" + profesorResult.get().getName();

        return "redirect:/home";
    }
}
