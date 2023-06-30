package com.glarimy.assessments.api;

public class Answer {
	private int qid;
	private int option;

	public Answer(int qid, int option) {
		super();
		this.qid = qid;
		this.option = option;
	}

	public int getQid() {
		return qid;
	}

	public int getOption() {
		return option;
	}

	@Override
	public String toString() {
		return "Answer [qid=" + qid + ", option=" + option + "]";
	}

}
