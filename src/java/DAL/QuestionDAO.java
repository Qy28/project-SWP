/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Question;
import java.sql.Connection;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class QuestionDAO {
        private Connection con;
    private Vector<Question> test;
    private String status = "ok";
    public static QuestionDAO INS=new QuestionDAO();

    public Connection getCon() {
        return con;
    }
    
    
    public QuestionDAO() {
        if (INS == null)
        try {
            con = new DBContext().connection;
        } catch (Exception e) {
            status = "Error at con " + e.getMessage();
        } else if (con == null) {
            con = new DBContext().connection;
        } else {
            INS = this;
        }
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Vector<Question> getTest() {
        return test;
    }

    public void setTest(Vector<Question> test) {
        this.test = test;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public QuestionDAO(Connection con, Vector<Question> test) {
        this.con = con;
        this.test = test;
    }    
    


    public static QuestionDAO getINS() {
        return INS;
    }

    public static void setINS(QuestionDAO INS) {
        QuestionDAO.INS = INS;
    }
    

}
