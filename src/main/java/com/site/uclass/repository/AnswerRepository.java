package com.site.uclass.repository;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
    
}
