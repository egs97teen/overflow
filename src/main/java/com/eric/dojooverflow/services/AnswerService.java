package com.eric.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.eric.dojooverflow.models.Answer;
import com.eric.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);
	}
}
