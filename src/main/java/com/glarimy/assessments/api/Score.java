package com.glarimy.assessments.api;

public class Score {
	private int total;
	private int right;

	public Score(int total, int right) {
		super();
		this.total = total;
		this.right = right;
	}

	public int getTotal() {
		return total;
	}

	public int getRight() {
		return right;
	}

	@Override
	public String toString() {
		return "Score [total=" + total + ", right=" + right + "]";
	}

}
