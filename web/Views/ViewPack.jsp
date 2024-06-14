<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pack Details</title>
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
        .pack-details {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin: 20px auto;
            max-width: 600px;
            text-align: center;
        }
        .pack-details h2 {
            font-size: 1.5em;
            margin-top: 0;
            margin-bottom: 10px;
        }
        .pack-details p {
            margin: 10px 0;
            line-height: 1.6;
        }
        .btn-back {
            display: inline-block;
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .btn-back:hover {
            background-color: #555;
        }
        .free {
            background-color: gray;
        }
        .gold {
            background-color: gold;
        }
        .diamond {
            background-color: aquamarine;
        }
    </style>
</head>
<body>
    <header>
        <h1>Pack Details</h1>
    </header>
    <div class="pack-details pack-card ${pack.packType.toLowerCase()}">
        <c:if test="${not empty pack}">
            <h2>${pack.packName}</h2>
            <h3>Type: ${pack.packType}</h3>
            <h3>${pack.description}</h3>
            <h3>Price: $${pack.price}</h3>
        </c:if>
        <c:if test="${empty pack}">
            <p>Pack details not found.</p>
        </c:if>
        <a href="BrowsePack" class="btn-back">Back to Packs</a>
    </div>
</body>
</html>
