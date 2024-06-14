package Controllers;

import DAL.PersonDAO;
import Models.Person;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userId = request.getParameter("Pid");
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String phoneNumber = request.getParameter("phoneNumber");

        if (userId == null || userId.isEmpty() ||
            username == null || username.isEmpty() ||
            password == null || password.isEmpty() ||
            dob == null || dob.isEmpty() ||
            phoneNumber == null || phoneNumber.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("Views/SignUp.jsp").forward(request, response);
            return;
        }

        try {
            java.sql.Date dateOfBirth = java.sql.Date.valueOf(dob);

            Person person = new Person(userId, username, password, dateOfBirth, phoneNumber, 0);

            PersonDAO personDAO = new PersonDAO();
            personDAO.insert(person);

            response.sendRedirect(request.getContextPath() + "/Views/Login.jsp?signup=success");
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred. Please try again.");
            request.getRequestDispatcher("Views/SignUp.jsp").forward(request, response);
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
}
