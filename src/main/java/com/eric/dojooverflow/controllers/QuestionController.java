package com.eric.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eric.dojooverflow.models.Answer;
import com.eric.dojooverflow.models.Question;
import com.eric.dojooverflow.models.Tag;
import com.eric.dojooverflow.services.QuestionService;
import com.eric.dojooverflow.services.TagService;

@Controller
public class QuestionController {
	private QuestionService questionService;
	private TagService tagService;
	
	public QuestionController(QuestionService questionService, TagService tagService) {
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	@RequestMapping("/questions")
	public String showQuestions(Model model) {
		List<Question> questions = questionService.allQuestions();
		model.addAttribute("questions", questions);
		return "showQuestions";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("Question") Question question) {
		return "newQuestion";
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("Question") Question question, BindingResult result, @RequestParam(value="tagList") String tagList, RedirectAttributes redirectAttributes) {
		List<Tag> tagCheck = tagService.checkTags(tagList);
		if (result.hasErrors()) {
			if (tagCheck == null) {
				redirectAttributes.addFlashAttribute("error", "You can only add up to 3 tags!");
			}
			return "redirect:/questions/new";
		} else {
			if (tagCheck == null) {
				redirectAttributes.addFlashAttribute("error", "You can only add up to 3 tags!");
				return "redirect:/questions/new";
			} else {
				question.setTags(tagCheck);
				questionService.addQuestion(question);
				return "redirect:/questions/" + question.getId();
			}
		}
	}
	
	@RequestMapping("/questions/{id}")
	public String showQuestion(@ModelAttribute("Answer") Answer answer, @PathVariable("id") Long id, Model model) {
		Question question = questionService.findQuestionById(id);
		if (question != null) {
			model.addAttribute("question", question);
			return "showQuestion";
		} else {
			return "redirect:/questions";
		}
	}
	
}
