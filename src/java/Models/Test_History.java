/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Test_History {
    private String pId;
    private int testId;
    private Date timeTake;
    private String result;

    public Test_History() {
    }

    public Test_History(String pId, int testId, Date timeTake, String result) {
        this.pId = pId;
        this.testId = testId;
        this.timeTake = timeTake;
        this.result = result;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public Date getTimeTake() {
        return timeTake;
    }

    public void setTimeTake(Date timeTake) {
        this.timeTake = timeTake;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
