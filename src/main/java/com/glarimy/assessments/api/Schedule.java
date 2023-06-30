package com.glarimy.assessments.api;

import java.util.Date;
import java.util.List;

public class Schedule {
	private Date from;
	private Date to;
	private List<Integer> students;

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public List<Integer> getStudents() {
		return students;
	}

	public void setStudents(List<Integer> students) {
		this.students = students;
	}

}
