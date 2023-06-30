package com.glarimy.assessments.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private int qid;
	private String description;
	private String optionOne;
	private String optionTwo;
	private String optionThree;
	private String optionFour;
	private int answer;
	private String subject;
	private String topic;
	private String author;
	private Date creationTime;
	private int level;

	public Question() {
	}

	public Question(String description, String optionOne, String optionTwo, String optionThree, String optionFour,
			int answer, String subject, String topic, int level, String author) {
		this.description = description;
		this.optionOne = optionOne;
		this.optionTwo = optionTwo;
		this.optionThree = optionThree;
		this.optionFour = optionFour;
		this.answer = answer;
		this.subject = subject;
		this.topic = topic;
		this.level = level;
		this.author = author;
		this.creationTime = new Date();
	}

	public int getQid() {
		return qid;
	}

	public String getDescription() {
		return description;
	}

	public String getOptionOne() {
		return optionOne;
	}

	public String getOptionTwo() {
		return optionTwo;
	}

	public String getOptionThree() {
		return optionThree;
	}

	public String getOptionFour() {
		return optionFour;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setOptionOne(String optionOne) {
		this.optionOne = optionOne;
	}

	public void setOptionTwo(String optionTwo) {
		this.optionTwo = optionTwo;
	}

	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}

	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", description=" + description + ", optionOne=" + optionOne + ", optionTwo="
				+ optionTwo + ", optionThree=" + optionThree + ", optionFour=" + optionFour + ", answer=" + answer
				+ ", subject=" + subject + ", topic=" + topic + "]";
	}

}