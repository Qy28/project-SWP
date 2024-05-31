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
    private String answer;
    private String answerDescipt;

    public Question() {
    }

    public Question(int questionId, int testId, int questionTypeId, String detail, String answer, String answerDescipt) {
        this.questionId = questionId;
        this.testId = testId;
        this.questionTypeId = questionTypeId;
        this.detail = detail;
        this.answer = answer;
        this.answerDescipt = answerDescipt;
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

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerDescipt() {
        return answerDescipt;
    }

    public void setAnswerDescipt(String answerDescipt) {
        this.answerDescipt = answerDescipt;
    }
    
    
}
