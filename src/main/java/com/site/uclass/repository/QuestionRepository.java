package com.site.uclass.repository;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    
}
