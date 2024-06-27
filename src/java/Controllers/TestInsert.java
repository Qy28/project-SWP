/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers;

import DAL.*;
import Models.Question_Type;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Test;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TestInsert extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        TestDAO.INS.loadTest();
        request.setAttribute("dao", TestDAO.INS);
        request.getRequestDispatcher("Views/TestInsert.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int n=Integer.parseInt(request.getParameter("type"));
        request.setAttribute("type", n);
        if(request.getParameter("id")!=null){
        int b=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("testId", b);
        }
        processRequest(request, response);
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            String title=request.getParameter("name");
            String pId=request.getParameter("pId");
            if(pId.equals(""))  pId=null;
            short level=Short.parseShort(request.getParameter("level"));
            String s=request.getParameter("dateCreated");
            Date dateCreated=new Date();
            try {
                dateCreated=new SimpleDateFormat("yyyy-MM-dd").parse(s);
            } catch (ParseException ex) {
                Logger.getLogger(TestInsert.class.getName()).log(Level.SEVERE, null, ex);
            }
            java.sql.Date Day=new java.sql.Date(dateCreated.getTime());
            boolean b=false;

        if(request.getParameter("type2")!=null){
            int testId=Integer.parseInt(request.getParameter("id"));
            TestDAO.INS.updateTest(new Test(testId,title, pId, level, Day, b));
        }if(request.getParameter("type3")!=null){
            Test tst=new Test(0,title, pId, level, Day, b);
            HttpSession ses = request.getSession();
            int n=Integer.parseInt(request.getParameter("quesN"));
            request.setAttribute("quesN", n);
            if(ses.getAttribute("Test")==null){
            ses.setAttribute("Test", tst);
            }
            Question_TypeDAO.INS.loadQuestion_Type();
            request.setAttribute("daoType", Question_TypeDAO.INS);
            request.getRequestDispatcher("Views/QuestionInsert.jsp").forward(request, response);
            
        }
        
        TestDAO.INS.loadTest();
        request.setAttribute("dao", TestDAO.INS);
        response.sendRedirect("TestMenu");
    }
    public static void main(String[] args) {
            Question_TypeDAO.INS.loadQuestion_Type();
            List<Question_Type> lis=Question_TypeDAO.INS.getQues();
            System.out.println(lis.size());
            for(Question_Type type:  lis){
                System.out.println(type.toString());
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
