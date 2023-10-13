package com.question.entity;

public class QuestionWrapper {

	private int questionId;

	private String option1;

	private String option2;
	
	private String option3;
	
	private String option4;
	
	private String questionPrompt;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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
	
	

	public String getQuestionPrompt() {
		return questionPrompt;
	}

	public void setQuestionPrompt(String questionPrompt) {
		this.questionPrompt = questionPrompt;
	}

	public QuestionWrapper(int questionId, String questionPrompt, String option1, String option2, String option3,
			String option4) {
		super();
		this.questionId = questionId;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.questionPrompt = questionPrompt;
	}

	public QuestionWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
