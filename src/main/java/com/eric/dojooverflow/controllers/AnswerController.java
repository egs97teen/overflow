package com.eric.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eric.dojooverflow.models.Answer;
import com.eric.dojooverflow.models.Question;
import com.eric.dojooverflow.services.AnswerService;
import com.eric.dojooverflow.services.QuestionService;

@Controller
public class AnswerController {
	private QuestionService questionService;
	private AnswerService answerService;
	
	public AnswerController(QuestionService questionService, AnswerService answerService) {
		this.questionService = questionService;
		this.answerService = answerService;
	}
	
	@PostMapping("/answers/add/{question_id}")
	public String addAnswer(@Valid @ModelAttribute("Answer") Answer answer, BindingResult result, @PathVariable("question_id") Long id, Model model) {
		if (result.hasErrors()) {
			return "redirect:/questions/" + id;
		} else {
			Question question = questionService.findQuestionById(id);
			answer.setQuestion(question);
			answerService.addAnswer(answer);
			return "redirect:/questions/" + id;
		}
	}
}
