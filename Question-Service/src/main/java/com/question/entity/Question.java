package com.question.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int questionId;

	private String questionTopic;

	private String questionLevel;

	private String option1;

	private String option2;
	
	private String option3;
	
	private String option4;
	
	private String questionPrompt;
	
	private String questionAns;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTopic() {
		return questionTopic;
	}

	public void setQuestionTopic(String questionTopic) {
		this.questionTopic = questionTopic;
	}

	public String getQuestionLevel() {
		return questionLevel;
	}

	public void setQuestionLevel(String questionLevel) {
		this.questionLevel = questionLevel;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getQuestionPromt() {
		return questionPrompt;
	}

	public void setQuestionPromt(String questionPromt) {
		this.questionPrompt = questionPromt;
	}

	public String getQuestionAns() {
		return questionAns;
	}

	public void setQuestionAns(String questionAns) {
		this.questionAns = questionAns;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionTopic=" + questionTopic + ", questionLevel="
				+ questionLevel + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3
				+ ", option4=" + option4 + ", questionPromt=" + questionPrompt + ", questionAns=" + questionAns + "]";
	}

}
