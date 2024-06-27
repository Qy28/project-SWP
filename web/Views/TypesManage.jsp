<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <table>
            <tr>
                <th>Type Id</th>
                <th>Name</th>
            </tr>
            <c:forEach items="${daoType.ques}" var="tst" >
            <tr>
                <td>${tst.questionTypeId}</td>
                <td>${tst.typeName}</td>
            </tr>
            </c:forEach>
        </table>
        <form style=" width:200%;
                    height: 200%" action='TypesManage' method='post'>
                <label for="name"> Add Types: </label>
                <input type='text' id=name name="name" value='${stU.testId}' >
                <input type='submit' name='type${type}' value='Submit'>
            <a href="TestMenu">Return</a>
        </form>
    </body>
</html>
