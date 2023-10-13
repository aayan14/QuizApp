package com.question.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.entity.QuestionWrapper;
import com.question.entity.Response;
import com.question.service.QuestionService;



@RestController
@RequestMapping("/question")
public class QuestionsController {

	@Autowired
	QuestionService service;
	
	@Autowired
	Environment env;
	
	@RequestMapping("/allquestions")
	public ResponseEntity<List<Question>> getAllQuestions() {

		return service.getAllQuestions();
	}

	@RequestMapping("/category/{topic}")
	public ResponseEntity<List<Question>> getQuestionsByTopic(@PathVariable String topic) {

		return service.getQuestionsByTopic(topic);
	}

	@RequestMapping(path = "/addquestion", method = RequestMethod.POST)
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return service.addQuestion(question);
	}

	@RequestMapping("delete/{questionid}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int questionid) {
		return service.deleteQuestion(questionid);
	}
	
	@RequestMapping(path="update/{questionid}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateQuestion(@PathVariable int questionid, @RequestBody Question question) {
		return service.updateQuestion(questionid, question);
	}
	
	// create quiz
	@RequestMapping("/createquiz")
	public  ResponseEntity<List<Integer>>getQuestionsForQuiz(@RequestParam String category, @RequestParam int numQ){
		return service.getQuestionForQuiz(category, numQ);
		
	}
	
	// getQuestions (question id)
	@RequestMapping(path="/getquestions", method = RequestMethod.POST)
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds){
		
		System.out.println(env.getProperty("local.server.port"));
		return service.getQuestionsFromId(questionIds);
		
	}
	
	// getScore
	@RequestMapping(path="/getscore", method=RequestMethod.POST)
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		
		return service.getScore(responses);
	}

}