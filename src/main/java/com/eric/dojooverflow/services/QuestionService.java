package com.eric.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eric.dojooverflow.models.Question;
import com.eric.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public void addQuestion(Question question) {
		questionRepository.save(question);
	}
	
	public List<Question> allQuestions() {
		return (List<Question>) questionRepository.findAll();
	}
	
	public Question findQuestionById(Long id) {
		return questionRepository.findOne(id);
	}
	
	public void updateQuestion(Question question) {
		questionRepository.save(question);
	}
}
