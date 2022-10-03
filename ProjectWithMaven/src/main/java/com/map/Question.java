package com.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@Column(name="question_id")
	private int questionId;
	private String question;
	
	//commented part of one to one mapping.
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="a_id") private Answer answer;
	 * 
	 */
	
	@OneToMany(mappedBy = "question" ,fetch=FetchType.EAGER, cascade=CascadeType.ALL)   //mapped by use to avoid creating extra table question_answer //fetch=FetchType.EAGER for eager loading  // cascade is used to perform transaction to related entity in case of one to one when we save question then asnwer is not automatically saved we need to save answer exliclitly so using cascase this issue resolve.
	private List<Answer> answers;
	
	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	/*
	 * public Answer getAnswer() { return answer; } public void setAnswer(Answer
	 * answer) { this.answer = answer; }
	 */

	/*
	 * public Question(int questionId, String question, Answer answer) { super();
	 * this.questionId = questionId; this.question = question; this.answer = answer;
	 * }
	 */
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int questionId, String question, List<Answer> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}
	
	

}
