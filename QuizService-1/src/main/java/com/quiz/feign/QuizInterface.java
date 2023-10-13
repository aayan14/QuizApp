package com.quiz.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.entity.QuestionWrapper;
import com.quiz.entity.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

	// create quiz
		@RequestMapping("question/createquiz")
		public  ResponseEntity<List<Integer>>getQuestionsForQuiz(@RequestParam String category, @RequestParam int numQ);
		
		// getQuestions (question id)
		@RequestMapping(path="question/getquestions", method = RequestMethod.POST)
		public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds);
		
		// getScore
		@RequestMapping(path="question/getscore", method=RequestMethod.POST)
		public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
	
}
