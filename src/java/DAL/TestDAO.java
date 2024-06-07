/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Date;
import Models.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class TestDAO {
    
    private Connection con;
    private Vector<Test> test;
    private String status = "ok";

    public Vector<Test> getTest() {
        return test;
    }
    public static TestDAO INS=new TestDAO();

    public TestDAO() {
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

    public void setTest(Vector<Test> test) {
        this.test = test;
    }

    public static TestDAO getINS() {
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
    

    public TestDAO(Vector<Test> test) {
        this.test = test;
    }
    
    public void loadTest(){
            String sql = """
                   Select * from Test""";
        test = new Vector<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String pid = rs.getString(3);
                Short level = rs.getShort(4);
                Date dateCreated =rs.getDate(5);
                boolean state=rs.getBoolean(6);
                test.add(new Test(id, title, pid, level, dateCreated, state));
            }
        } catch (SQLException e) {
            System.out.println("Error at load Customer" + e.getMessage());
        }
    }
    
    public void updateTest(int testId,String title,String Pid,short level,Date dateCreated,boolean State){
        String sql = """
                                        Update Test   SET [Title] = ?   ,[Pid] = ?,[Level]=?,[Date]=?,[State]=?
                                                                    WHERE [TestId] =?;""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, Pid);
            ps.setInt(3, level);
            ps.setDate(4, dateCreated);
            ps.setBoolean(5, State);
            ps.setInt(6, testId);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at load Customer" + e.getMessage());
        }
    }
    public void deleteTest(int testId){
        String sql="Delete from Test where [TestId]=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, testId);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at load Customer" + e.getMessage());
        }
    }
    public void insertTest(int testId,String title,String Pid,short level,Date dateCreated,boolean State){
        String sql="Insert into Test values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, testId);
            ps.setString(2, title);
            ps.setString(3, Pid);
            ps.setInt(4, level);
            ps.setDate(5, dateCreated);
            ps.setBoolean(6, State);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error at load Customer" + e.getMessage());
        }
    }
}
