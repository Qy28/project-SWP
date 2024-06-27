/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers;

import DAL.TestDAO;
import Models.Paging;
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
public class TestMenu extends HttpServlet {
   int[] nrpp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession ses=request.getSession();
        if(ses.getAttribute("Test")!=null) ses.setAttribute("Test", null);
        TestDAO.INS.loadTest();
        request.setAttribute("testDAO", TestDAO.INS);
        request.getRequestDispatcher("Views/TestMenu.jsp").forward(request, response);
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
        TestDAO.INS.loadTest();
        int index;
        try {
            index = Integer.parseInt(request.getAttribute("index") + "");
        } catch (NumberFormatException e) {
            index = 0;
        }
        int nrpps;
        try {
            nrpps = Integer.parseInt(request.getAttribute("nrpp") + "");
        } catch (NumberFormatException e) {
            nrpps = 6;
        }
        Paging p = new Paging(TestDAO.INS.getTest().size(), nrpps, index);
        p.calc();
        request.setAttribute("page", p);
        request.setAttribute("nrppArr", this.nrpp);
        processRequest(request, response);
        String s=request.getParameter("type");
        if(s.equals("1")){
            int id=Integer.parseInt(request.getParameter("id"));
            TestDAO.INS.deleteTest(id);
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
        int index = Integer.parseInt(request.getParameter("index"));
            int total = Integer.parseInt(request.getParameter("total"));
            int nrpp = Integer.parseInt(request.getParameter("nrpp"));
            if (request.getParameter("btnHome") != null) {
                index = 0;
            }
            if (request.getParameter("btnEnd") != null) {
                index = total - 1;
            }
            if (request.getParameter("btnPre") != null) {
                index -= 1;
            }
            if (request.getParameter("btnNext") != null) {
                index += 1;
            }
            for (int i = 0; i < total; i++) {
                if (request.getParameter("btn" + i) != null) {
                    index = i;
                }
            }
            request.setAttribute("index", index);
            request.setAttribute("nrpp", nrpp);
        doGet(request, response);
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
