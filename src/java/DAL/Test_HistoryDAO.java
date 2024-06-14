/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Test_History;
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
public class Test_HistoryDAO {
        
    private Connection con;
    private Vector<Test_History> test;
    private String status = "ok";

    public Vector<Test_History> getTest_History() {
        return test;
    }
    public static Test_HistoryDAO INS=new Test_HistoryDAO();

    public Test_HistoryDAO() {
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

    public void setTest_History(Vector<Test_History> test) {
        this.test = test;
    }

    public static Test_HistoryDAO getINS() {
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
    

    public Test_HistoryDAO(Vector<Test_History> test) {
        this.test = test;
    }
    
    public void loadTest_History(){
            String sql = """
                   Select * from TestHistory""";
        test = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                int testId=rs.getInt(2);
                Date time = rs.getDate(3);
                String  result = rs.getString(4);
                test.add(new Test_History(id, testId, time, result));
            }
        } catch (SQLException e) {
            System.out.println("Error at load TestHistory" + e.getMessage());
        }
    }
    
    public void updateTest_History(Test_History th){
        String sql = """
                                        Update TestHistory   SET [TimeTake] = ?   ,[Result]=?
                                                                    WHERE [Pid] = ?,[TestId]=?;""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(3, th.getpId());
            ps.setInt(4, th.getTestId());
            ps.setDate(1, th.getTimeTake());
            ps.setString(2, th.getResult());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at Update TestHistory" + e.getMessage());
        }
    }
    public void deleteTest_History(int testId,String pid){
        String sql="Delete from TestHistory where [TestId]=?,[Pid]=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, testId);
            ps.setString(2, pid);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at Delete TestHistory" + e.getMessage());
        }
    }
    public void insertTest(Test_History th){
        String sql="Insert into TestHistory values (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, th.getpId());
            ps.setInt(2, th.getTestId());
            ps.setDate(3, th.getTimeTake());
            ps.setString(4, th.getResult());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at insert TestHistory" + e.getMessage());
        }
    }
}
