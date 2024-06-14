/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Question_Answer_Detail {
    private int questionId;
    private String questionAnswer;
    private boolean questionState;

    public Question_Answer_Detail() {
    }

    public Question_Answer_Detail(int questionId, String questionAnswer, boolean questionState) {
        this.questionId = questionId;
        this.questionAnswer = questionAnswer;
        this.questionState = questionState;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public boolean getQuestionState() {
        return questionState;
    }

    public void setQuestionState(boolean questionState) {
        this.questionState = questionState;
    }
}
