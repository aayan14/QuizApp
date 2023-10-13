package com.question.service;

import java.util.ArrayList;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.question.dao.QuestionDao;
import com.question.entity.Question;
import com.question.entity.QuestionWrapper;
import com.question.entity.Response;





@Service
public class QuestionService {

	@Autowired
	com.question.dao.QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByTopic(String topic) {
		try {
		return new ResponseEntity<>(questionDao.findByQuestionTopic(topic), HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
	}

	public ResponseEntity<String> addQuestion(Question question) {

		
		try {
			questionDao.save(question);
			return new ResponseEntity<>("success", HttpStatus.CREATED);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
		

	}

	public ResponseEntity<String> deleteQuestion(int questionid) {

		try {
			questionDao.deleteById(questionid);
			return new ResponseEntity<>("deleted", HttpStatus.OK);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> updateQuestion(int questionid, Question question) {
		try {
		Question questionToUpdate = questionDao.findByQuestionId(questionid);
		
		questionToUpdate.setQuestionTopic(question.getQuestionTopic()); 
		questionToUpdate.setQuestionLevel(question.getQuestionLevel()); 
		questionToUpdate.setOption1(question.getOption1()); 
		questionToUpdate.setOption2(question.getOption2()); 
		questionToUpdate.setOption3(question.getOption3()); 
		questionToUpdate.setOption4(question.getOption4()); 
		questionToUpdate.setQuestionPromt(question.getQuestionPromt()); 
		questionToUpdate.setQuestionAns(question.getQuestionAns()); 
		
		questionDao.save(questionToUpdate);
		return new ResponseEntity<>("updated", HttpStatus.OK);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Integer>> getQuestionForQuiz(String category, int numQ) {
		
		
		List<Integer> questions = questionDao.findRamdomQuestionsByCategory(category, numQ);
		
		
		return new ResponseEntity<>(questions, HttpStatus.CREATED);
		
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		
		List<QuestionWrapper> wrappers = new ArrayList<>();
		
		for(Integer i: questionIds) {
			QuestionWrapper q = new QuestionWrapper();
			q.setQuestionId(questionDao.findById(i).get().getQuestionId());
			q.setQuestionPrompt(questionDao.findById(i).get().getQuestionPromt());
			q.setOption1(questionDao.findById(i).get().getOption1());
			q.setOption2(questionDao.findById(i).get().getOption2());
			q.setOption3(questionDao.findById(i).get().getOption3());
			q.setOption4(questionDao.findById(i).get().getOption4());
			
			wrappers.add(q);
			
		}
		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		
		Question question;
		int right = 0;
		String rightAns;
		for(Response r: responses) {
			question = questionDao.findById(r.getId()).get();
			rightAns = question.getQuestionAns();
			if(r.getResponse().equals(rightAns)){
				
				right++;
			}
			
		
	}
		return new ResponseEntity<Integer>(right, HttpStatus.OK);

}
}
