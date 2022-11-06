package com.site.uclass.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.uclass.entities.Course;
import com.site.uclass.entities.Professor;
import com.site.uclass.repository.ProfessorAccountRepository;
import com.site.uclass.repository.ProfessorRepository;
import com.site.uclass.services.interfaces.IProfessorService;

@Service
public class ProfessorService implements IProfessorService {

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private ProfessorAccountRepository professorAccountRepository;
    
    @Override
    public Iterable<Professor> getAllProfessors() {
        return repository.findAll();
    }

    @Override
    public Professor getProfessorByName(String name) {
        return repository.findByName(name).get();
    }

    @Override
    public Professor getProfessorByAccountId(long accountId) {
        return professorAccountRepository.findByAccountId(accountId).getProfessor();
    }

    @Override
    public Iterable<Course> getProfessorsCourses(String name) {
        return repository.findByName(name).get().getCourses();
    }

    @Override
    public Optional<Professor> searchForProfessor(String text) {
        return repository.findByName(text);
    }
}
