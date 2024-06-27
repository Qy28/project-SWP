/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers;

import DAL.QuestionDAO;
import DAL.Question_AnswerDAO;
import DAL.TestDAO;
import Models.Question;
import Models.Question_Answer_Detail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class QuestionInsert extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("TestMenu").forward(request, response);
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
        int nums= Integer.parseInt(request.getParameter("numQues"));
        HttpSession ses=request.getSession();
        Models.Test tst= (Models.Test)ses.getAttribute("Test");
        TestDAO.INS.insertTest(tst);
        for(int i=1;i<=nums;i++){
            String a=i+"";
            int testId= tst.getTestId();
            int typeId=  Integer.parseInt(request.getParameter("type"+a));
            String details=request.getParameter("question"+a);
            String ansDetail=request.getParameter("ans"+a);
            byte numsQues=1;
            if(request.getParameter("numsQues"+a)!=null &&!request.getParameter("numsQues"+a).equals("") ){
                numsQues=Byte.parseByte(request.getParameter("numsQues"+a));
            }
            Question tempQues=new Question(0,testId,typeId,details,ansDetail,false,numsQues);
            QuestionDAO.INS.insertQuestion(tempQues);
            int right=Integer.parseInt(request.getParameter("rightChoice"+a));
            for(int j=1;j<=4;j++){
                String b=j+"";
                String choiceDetail=request.getParameter("choice"+b+":question"+a);
                Question_AnswerDAO.INS.insertQuestionAnswerDetail(new Question_Answer_Detail(tempQues.getQuestionId(),choiceDetail,(right==j)));
            }
        }
        response.sendRedirect("TestMenu");
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
