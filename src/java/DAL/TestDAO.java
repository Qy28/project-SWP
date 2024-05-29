/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Test;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TestDAO extends DAO{
    
    private List<Test> test;

    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }

    public static DAO getINS() {
        return INS;
    }

    public static void setINS(DAO INS) {
        DAO.INS = INS;
    }

    public TestDAO() {
    }

    public TestDAO(List<Test> test) {
        this.test = test;
    }
    
    
}
