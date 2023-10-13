package com.quiz.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.dao.QuizDao;

import com.quiz.entity.QuestionWrapper;
import com.quiz.entity.Quiz;
import com.quiz.entity.Response;
import com.quiz.feign.QuizInterface;



@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<String>("success", HttpStatus.CREATED) ;
		
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int quizid) {
	
		Quiz quiz = quizDao.findById(quizid).get();
		List<Integer> questionIds = quiz.getQuestions();
		List<QuestionWrapper> qw = quizInterface.getQuestionFromId(questionIds).getBody();	
		
		return new ResponseEntity<List<QuestionWrapper>>(qw, HttpStatus.OK);
		
	}
	public ResponseEntity<Integer> calculateResult(int quizid, List<Response> response) {
		
		Integer score = quizInterface.getScore(response).getBody();
		
		
		return new ResponseEntity<>(score, HttpStatus.OK);
	}

	
}
