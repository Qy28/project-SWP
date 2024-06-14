/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Question_History {
    private String pId;
    private int questionId;
    private String result;

    public Question_History() {
    }

    public Question_History(String pId, int questionId, String text) {
        this.pId = pId;
        this.questionId = questionId;
        this.result = text;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String text) {
        this.result = text;
    }
    
    
    
}
