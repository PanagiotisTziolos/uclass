package com.site.uclass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.uclass.entities.Answer;
import com.site.uclass.entities.Question;

import com.site.uclass.repository.AnswerRepository;
import com.site.uclass.repository.QuestionRepository;

import com.site.uclass.services.interfaces.IQuestionAnswerService;

@Service
public class QuestionAnswerService implements IQuestionAnswerService {

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private AnswerRepository answerRepo;
    
    @Override
    public Iterable<Question> getQuestions() {
        return questionRepo.findAll();
    }

    @Override
    public Iterable<Answer> getAnswers() {
        return answerRepo.findAll();
    }
    
}
