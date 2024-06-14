/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Question_Answer_Detail;
import Models.Question_History;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class Question_HistoryDAO {
                private Connection con;
    private Vector<Question_History> quesHis;
    private String status = "ok";
    public static Question_HistoryDAO INS=new Question_HistoryDAO();

    public Connection getCon() {
        return con;
    }
    
    
    public Question_HistoryDAO() {
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

    public Vector<Question_History> getQues() {
        return quesHis;
    }

    public void setTest(Vector<Question_History> ques) {
        this.quesHis = ques;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Question_HistoryDAO(Connection con, Vector<Question_History> ques) {
        this.con = con;
        this.quesHis = ques;
    }    
    public static Question_HistoryDAO getINS() {
        return INS;
    }

    public static void setINS(Question_HistoryDAO INS) {
        Question_HistoryDAO.INS = INS;
    }
        public void loadQuestion_History(){
            String sql = """
                   Select * from QuestionHistory""";
        quesHis = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id=rs.getString(1);
                int qId=rs.getInt(2);
                String text=rs.getString(3);
                quesHis.add(new Question_History(id, qId, text));
            }
        } catch (SQLException e) {
            System.out.println("Error at load QuestionHistory" + e.getMessage());
        }
    }
    
    public void updateQuestion_History(Question_History qad){
        String sql = """
                                        Update QuestionHistory [Result] = ?  WHERE [QuestionId] =?,[Pid] =?;""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, qad.getpId());
            ps.setInt(2, qad.getQuestionId());
            ps.setString(3, qad.getResult());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at load Update QuestionHistory" + e.getMessage());
        }
    }
    public void deleteQuestion_History(int Question_Answer_Id,String pid){
        String sql="Delete from QuestionHistory where [Pid]=?,[QuestionId]=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            ps.setInt(2, Question_Answer_Id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at load Delete from deleteQuestion_History" + e.getMessage());
        }
    }
    public void insertQuestion_History(Question_History qad){
        String sql="Insert into QuestionHistory values (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, qad.getpId());
            ps.setInt(2, qad.getQuestionId());
            ps.setString(3, qad.getResult());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at insert QuestionHistory" + e.getMessage());
        }
    }
}
