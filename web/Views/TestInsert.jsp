<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <c:forEach items="${dao.test}" var ="st">
                <c:if test="${st.testId==testId}">
                    <c:set var="stU" value="${st}"/>
                </c:if>
            </c:forEach>
        <c:if test="${Test!=null}">
                    <c:set var="stU" value="${Test}"/>
            </c:if>
            <form style=" width:200%;
                    height: 200%" action='TestInsert' method='post'>
            <table>
                
                <c:if test="${type!=3}">
                <tr>
                    <td>Test Id</td>
                    <td><input type='text' name=id value='${stU.testId}' readonly> </td>
                </tr>
                </c:if>
                <tr>
                    <td>Title</td>
                    <td><input type='text' name=name value='${stU.title}' required> </td>
                </tr>
                <tr>
                    <td>Author Id</td>
                    <td><input type='text' name=pId value='${stU.pId}'></td>
                </tr>
                <tr>
                    <td>Difficulty</td>
                    <td><input type='number' name=level value='${stU.level}' required> </td>
                </tr>
                <tr>
                    <td>Date Created</td>
                    <td><input type='date' name=dateCreated value='${stU.dateCreated}'> </td>
                </tr>
                <c:if test="${type==3}">
                <tr>
                    <td>Question Number</td>
                    <td><input type='number' name=quesN value="40" max="255"> </td>
                </tr>
                
                </c:if>
            </table>
            <input type='submit' name='type${type}' value='Submit'>
            <a href="TestMenu">Return</a>
        </form>

    </body>
</html>
