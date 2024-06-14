<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up Page</title>
    <link rel="stylesheet" type="text/css" href="/SproutEnglish/Views/css/signup.css">
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
                <h2>Sign Up</h2>
                <form action="/SproutEnglish/SignUp" method="post" class="form">
                    <div class="inputBox">
                        <input type="text" id="Pid" name="Pid" required>
                        <i>User ID</i>
                    </div>
                    <div class="inputBox">
                        <input type="text" id="name" name="name" required>
                        <i>Username</i>
                    </div>
                    <div class="inputBox">
                        <input type="password" id="password" name="password" required>
                        <i>Password</i>
                    </div>
                    <div class="inputBox">
                        <input type="date" id="dob" name="dob" required>
                        <i>Date of Birth</i>
                    </div>
                    <div class="inputBox">
                        <input type="text" id="phoneNumber" name="phoneNumber" required>
                        <i>Phone Number</i>
                    </div>
                    <div class="inputBox">
                        <input type="submit" value="Sign Up">
                    </div>
                </form>
                <div class="links">
                <a href="/SproutEnglish/Views/Login.jsp">Login</a>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
