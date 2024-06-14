/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Question {
    private int questionId;
    private int testId;
    private int questionTypeId;
    private String detail;
    private String answerDescipt;
    private boolean state;

    public Question() {
    }

    public Question(int questionId, int testId, int questionTypeId, String detail, String answerDescipt,boolean state) {
        this.questionId = questionId;
        this.testId = testId;
        this.questionTypeId = questionTypeId;
        this.detail = detail;
        this.answerDescipt = answerDescipt;
        this.state=state;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getDetail() {
        return detail;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAnswerDescipt() {
        return answerDescipt;
    }

    public void setAnswerDescipt(String answerDescipt) {
        this.answerDescipt = answerDescipt;
    }
}
