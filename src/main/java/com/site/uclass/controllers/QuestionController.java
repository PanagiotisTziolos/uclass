package com.site.uclass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.site.uclass.services.interfaces.IQuestionAnswerService;

import org.springframework.ui.Model;


@Controller
public class QuestionController {
    
    @Autowired
    private IQuestionAnswerService questionAnswerService;

    @GetMapping("/questions")
    public String questionsView(Model model) {
        model.addAttribute("questions", questionAnswerService.getQuestions());

        model.addAttribute("answers", questionAnswerService.getAnswers());

        return "questions";
    }
}
