/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Question_Type;
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
public class Question_TypeDAO {
        
    private Connection con;
    private Vector<Question_Type> ques;
    private String status = "ok";

    public Vector<Question_Type> getQues() {
        return ques;
    }
    public static Question_TypeDAO INS=new Question_TypeDAO();

    public Question_TypeDAO() {
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

    public void setQues(Vector<Question_Type> ques) {
        this.ques = ques;
    }

    public static Question_TypeDAO getINS() {
        return INS;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public Question_TypeDAO(Vector<Question_Type> ques) {
        this.ques = ques;
    }
    
    public void loadQuestion_Type(){
            String sql = """
                   Select * from QuestionType""";
        ques = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String typeName = rs.getString(2);
                ques.add(new Question_Type(id, typeName));
            }
        } catch (SQLException e) {
            System.out.println("Error at load QuestionType" + e.getMessage());
        }
    }
    
    public void updateQuestion_Type(Question_Type q){
        String sql = """
                                        Update QuestionType   SET [TypeName] = ? 
                                                                    WHERE [QuestionTypeId] =?;""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, q.getTypeName());
            ps.setInt(2, q.getQuestionTypeId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at Update QuestionType" + e.getMessage());
        }
    }
    public void deleteQuestion_Type(int QuestionTypeId){
        String sql="Delete from QuestionType where [QuestionTypeId]=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, QuestionTypeId);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at delete QuestionTypeId" + e.getMessage());
        }
    }
    public void insertQuestion_Type(Question_Type q){
        String sql="Insert into QuestionType values (?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, q.getTypeName());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at Insert into QuestionType" + e.getMessage());
        }
    }
}
