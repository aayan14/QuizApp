package com.quiz.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.QuestionWrapper;
import com.quiz.entity.QuizDto;
import com.quiz.entity.Response;
import com.quiz.service.QuizService;


@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService service;
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
		
		
		return service.createQuiz(quizDto.getCategory(), quizDto.getNumQ(), quizDto.getTitle());
	}
	
	@RequestMapping("/getquiz/{quizid}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable int quizid){
		
		return service.getQuizQuestions(quizid);
	}
	
	@RequestMapping(path = "/submit/{quizid}", method = RequestMethod.POST)
	public ResponseEntity<Integer> submitQuiz(@PathVariable int quizid, @RequestBody List<Response> response){
		
		return service.calculateResult(quizid, response);
		
	}
}
