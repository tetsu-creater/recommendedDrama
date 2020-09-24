package la.bean;

import java.io.Serializable;

public class QuestionPointBean implements Serializable{
	private String question;
	private int nowPoint;

	public QuestionPointBean() {

	}

	public QuestionPointBean(String question, int nowPoint) {
		this.question = question;
		this.nowPoint = nowPoint;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getNowPoint() {
		return nowPoint;
	}
	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}
}
