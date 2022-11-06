package com.site.uclass.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long>{
    public Optional<Professor> findByName(String name);
}
