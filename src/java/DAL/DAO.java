/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class DAO {
    
    private Connection con;
    private String status = "ok";
    
    public Connection getCon() {
        return con;
    }
    
    public static DAO INS = new DAO();


    public DAO() {
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
        public static DAO getINS() {
        return INS;
    }

    public static void setINS(DAO INS) {
        DAO.INS = INS;
    }
        public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
