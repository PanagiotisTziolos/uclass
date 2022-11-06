package com.site.uclass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.uclass.entities.Semester;
import com.site.uclass.repository.SemesterRepository;
import com.site.uclass.services.interfaces.ISemesterService;

@Service
public class SemesterService implements ISemesterService {

    @Autowired
    private SemesterRepository repository;
    
    @Override
    public Iterable<Semester> getAllSemesters() {
        return repository.findAll();
    }
}
