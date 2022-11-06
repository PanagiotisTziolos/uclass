package com.site.uclass.services.interfaces;

import java.util.Optional;

import com.site.uclass.entities.Course;
import com.site.uclass.entities.Professor;

public interface IProfessorService {
    
    public Iterable<Professor> getAllProfessors();

    public Professor getProfessorByName(String name);

    public Professor getProfessorByAccountId(long accountId);

    public Iterable<Course> getProfessorsCourses (String name);

    public Optional<Professor> searchForProfessor(String text);
}
