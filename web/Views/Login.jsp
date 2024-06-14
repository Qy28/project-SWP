<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="/SproutEnglish/Views/css/signin.css">
</head>
<body>
    <section>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <div class="signin">
            <div class="content">
                <h2>Login</h2>
                <form action="Login" method="post" class="form">
                    <div class="inputBox">
                        <input type="text" id="user" name="user" required>
                        <i>Username</i>
                    </div>
                    <div class="inputBox">
                        <input type="password" id="pass" name="pass" required>
                        <i>Password</i>
                    </div>
                    <div class="inputBox">
                        <input type="submit" value="Login">
                    </div>
                </form>
                <div class="links">
                <a href="/SproutEnglish/Views/SignUp.jsp">SignUp</a>
                </div>
                <%
                    String invalidUser = (String) request.getAttribute("invalidUser");
                    if (invalidUser != null) {
                %>
                <p style="color:red;"><%= invalidUser %></p>
                <%
                    }
                %>
            </div>
        </div>
    </section>
</body>
</html>
