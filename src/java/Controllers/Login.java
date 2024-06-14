package Controllers;

import DAL.PersonDAO;
import Models.Person;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        if (username == null || password == null) {
            request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
            return;
        }

        PersonDAO userDao = new PersonDAO();
        Person user = userDao.getUser(username, password);

        if (user == null || user.getName() == null) {
            request.setAttribute("invalidUser", "Username or Password are wrong");
            request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10000); 
            session.setAttribute("acc", user);

            response.sendRedirect(request.getContextPath() + "/Views/homepage.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
