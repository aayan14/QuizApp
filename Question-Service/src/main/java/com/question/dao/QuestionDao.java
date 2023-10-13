package com.question.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.question.entity.Question;



@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

	List<Question> findByQuestionTopic(String question_topic);
	Question findByQuestionId(int questionid);
	
	@Query(value = "SELECT q.question_id FROM questions q WHERE q.question_topic=:category ORDER BY RAND() LIMIT :numQ ", nativeQuery = true)
	List<Integer> findRamdomQuestionsByCategory(String category, int numQ);

	
}
