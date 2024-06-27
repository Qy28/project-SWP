/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Question;
import Models.Test;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class QuestionDAO {
        private Connection con;
    private Vector<Question> ques;
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

    public Vector<Question> getQues() {
        return ques;
    }

    public void setTest(Vector<Question> ques) {
        this.ques = ques;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public QuestionDAO(Connection con, Vector<Question> ques) {
        this.con = con;
        this.ques = ques;
    }    
    public static QuestionDAO getINS() {
        return INS;
    }

    public static void setINS(QuestionDAO INS) {
        QuestionDAO.INS = INS;
    }
        public void loadQues(){
            String sql = """
                   Select * from Question""";
        ques = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int testId=rs.getInt(2);
                int questionTypeId=rs.getInt(3);
                String detail=rs.getString(4);
                String answerDescipt=rs.getString(5);
                boolean state=rs.getBoolean(6);
                byte nums=rs.getByte(7);
                ques.add(new Question(id, testId, questionTypeId, detail, answerDescipt, state,nums));
            }
        } catch (SQLException e) {
            System.out.println("Error at load Question" + e.getMessage());
        }
    }
    
    public void updateQuestion(Question q){
        String sql = """
                                        Update Question   SET [TestId] = ?   ,[QuestionTypeId] = ?,[Detail]=?,[AnswerDescription]=?,[State]=?,[NumsOfQues]=?
                                                                    WHERE [QuestionId] =?;""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(7, q.getQuestionId());
            ps.setInt(1, q.getTestId());
            ps.setInt(2, q.getQuestionTypeId());
            ps.setString(3, q.getDetail());
            ps.setString(4, q.getAnswerDescipt());
            ps.setBoolean(5, q.getState());
            ps.setByte(6, q.getNumsOfQ());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at Update Question" + e.getMessage());
        }
    }
    public void deleteQuestion(int Question){
        String sql="Delete from Question where [QuestionId]=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Question);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at delete Question" + e.getMessage());
        }
    }
    public void insertQuestion(Question q){
        String sql="Insert into Question values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, q.getTestId());
            ps.setInt(2, q.getQuestionTypeId());
            ps.setString(3, q.getDetail());
            ps.setString(4, q.getAnswerDescipt());
            ps.setBoolean(5, q.getState());
            ps.setByte(6, q.getNumsOfQ());
            ps.execute();
                        int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating test failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    q.setQuestionId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating test failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error at insert Question" + e.getMessage());
        }
    }

}
