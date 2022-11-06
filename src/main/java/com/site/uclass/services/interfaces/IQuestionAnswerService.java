package com.site.uclass.services.interfaces;

import com.site.uclass.entities.Answer;
import com.site.uclass.entities.Question;

public interface IQuestionAnswerService {

    public Iterable<Question> getQuestions();

    public Iterable<Answer> getAnswers();
}
