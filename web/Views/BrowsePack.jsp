<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Learning Packs</title>
    <style>
        body {
            font-family: "Raleway", sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 20px 0;
            text-align: center;
        }
        h1 {
            margin: 0;
        }
        main {
            padding: 20px;
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
        }
        .pack-card {
            border: 1px solid #ddd;
            padding: 20px;
            margin: 10px;
            width: 30%;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            transition: all 0.3s ease;
            text-align: center;
            background-color: #fff;
        }
        .pack-card.free {
            background-color: gray;
        }
        .pack-card.gold {
            background-color: gold;
        }
        .pack-card.diamond {
            background-color: aquamarine;
        }
        .pack-card:hover {
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            transform: translateY(-2px);
        }
        .pack-card h2 {
            font-size: 1.5em;
            margin-top: 0;
            margin-bottom: 10px;
        }
        .pack-card p {
            margin: 10px 0;
        }
        .btn-details, .btn-signup {
            display: inline-block;
            margin-top: 10px;
            padding: 10px 20px;
            background-color: #333;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .btn-details:hover, .btn-signup:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <header>
        <h1>Learning Packs</h1>
    </header>
    <main>
        <c:forEach var="pack" items="${packs}">
            <div class="pack-card ${pack.packType.toLowerCase()}">
                <h2>${pack.packName}</h2>
                <h3>$${pack.price} per month</h3>
                <a href="ViewPack?packID=${pack.packID}" class="btn-details">Details</a>
                <a href="SignUp?packID=${pack.packID}" class="btn-signup">Sign Up</a>
            </div>
        </c:forEach>
    </main>
</body>
</html>
