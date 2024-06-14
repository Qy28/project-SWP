/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Question;
import Models.Question_Answer_Detail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class Question_AnswerDAO {
            private Connection con;
    private Vector<Question_Answer_Detail> quesAns;
    private String status = "ok";
    public static Question_AnswerDAO INS=new Question_AnswerDAO();

    public Connection getCon() {
        return con;
    }
    
    
    public Question_AnswerDAO() {
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

    public Vector<Question_Answer_Detail> getQues() {
        return quesAns;
    }

    public void setTest(Vector<Question_Answer_Detail> ques) {
        this.quesAns = ques;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Question_AnswerDAO(Connection con, Vector<Question_Answer_Detail> ques) {
        this.con = con;
        this.quesAns = ques;
    }    
    public static Question_AnswerDAO getINS() {
        return INS;
    }

    public static void setINS(Question_AnswerDAO INS) {
        Question_AnswerDAO.INS = INS;
    }
        public void loadQues(){
            String sql = """
                   Select * from QuestionAnswerDetail""";
        quesAns = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String questionAnswer=rs.getString(2);
                boolean questionState=rs.getBoolean(3);
                quesAns.add(new Question_Answer_Detail(id, questionAnswer, questionState));
            }
        } catch (SQLException e) {
            System.out.println("Error at load Question Answer Detail" + e.getMessage());
        }
    }
    
    public void updateTest(Question_Answer_Detail qad){
        String sql = """
                                        Update QuestionAnswerDetail [QuestionAnswer] = ?,[QuestionState]=?   WHERE [QuestionId] =?;""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, qad.getQuestionId());
            ps.setString(2, qad.getQuestionAnswer());
            ps.setBoolean(3, qad.getQuestionState());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at load Update QuestionAnswerDetail" + e.getMessage());
        }
    }
    public void deleteTest(Question_Answer_Detail Question_Answer){
        String sql="Delete from QuestionAnswerDetail where [QuestionId]=?,[QuestionAnswer]=?,[QuestionState]=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Question_Answer.getQuestionId());
            ps.setString(2, Question_Answer.getQuestionAnswer());
            ps.setBoolean(3, Question_Answer.getQuestionState());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at load Delete from QuestionAnswerDetail" + e.getMessage());
        }
    }
    public void insertTest(Question_Answer_Detail qad){
        String sql="Insert into QuestionAnswerDetail values (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, qad.getQuestionId());
            ps.setString(2, qad.getQuestionAnswer());
            ps.setBoolean(3, qad.getQuestionState());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at load Customer" + e.getMessage());
        }
    }
}
