<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./css/TestMenu.css" rel="stylesheet" />
        <style>
            table{
                font-size: 20px;
            }
            tbody td {
  /* 1. Animate the background-color
     from transparent to white on hover */
  background-color: rgba(255,255,255,0);
  transition: all 0.2s linear; 
  transition-delay: 0.3s, 0s;
}
tbody tr:hover td {
  background-color: rgba(255,255,255,1);
  transition-delay: 0s, 0s;
  opacity: 1;
  font-size: 2em;
}

td {
  /* 3. Scale the text using transform on hover */
  transform-origin: center ;
  transition-property: transform;
  transition-duration: 0.4s;
  transition-timing-function: ease-in-out;
}
tr:hover td {
  transform: scale(1);
}
/* Codepen styling */
* { box-sizing: border-box }

table {
  width: 95%;
  margin: 0 5%;
  text-align: left;
}
th, td {
  padding: 0.5em;
}

body {
  background: hsl(232, 22%, 90%);
  color: rgba(95, 17, 232, 1);
}

body > *  {
  margin: auto;
}
        </style>
    </head>
    <body>
        
        <table>
            <tr>
                <th>Test Id</th>
                <th style="width:40%">Title</th>
                <th>Author</th>
                <th>Difficulty</th>
                <th>Day Created</th>
                <th>Justified</th>
            </tr>
            <c:forEach items="${testDAO.test}" var="tst"  begin="${page.begin}"
                                               end= "${page.end-1}">
            <tr>
                <td>${tst.testId}</td>
                <td><a href="Test?id=${tst.testId}" >${tst.title}</a></td>
                <td>${tst.pId==null?"Annonymous":tst.pId}</td>
                <td>${tst.level}</td>
                <td>${tst.dateCreated}</td>
                <td>${tst.state?"Approved":"Unapproved"}</td>
                <td><a href="TestMenu?type=1&id=${tst.testId}">Delete</a><br/><a href="TestInsert?type=2&id=${tst.testId}">Update</a></td>
            </tr>
            </c:forEach>
            
        </table><br/>
        <a style="font-size: 60px" href="TestInsert?type=3">Insert Test</a>
        <form action='TestMenu' method='post'>
                                <select name='nrpp'>
                                    <c:forEach items="${nrppArr}" var='nr'>
                                        <option value='${nr}' ${page.nrpp==nr?"selected":""}>${nr}</option>
                                    </c:forEach>
                                </select>
                                <input type='text' name='index' value='${page.index}' hidden>
                                <input type='text' name='total' value='${page.totalPage}' hidden>
                                <c:if test="${page.index!=0}">
                                    <input type='submit' name='btnHome' value='&lt;&lt;'>
                                    <input type='submit' name='btnPre' value='&lt;'>
                                </c:if>
                                <c:forEach var="p" begin='${page.pageStart}' end='${page.pageEnd-1}'>
                                    <input type='submit' name='btn${p}' value='Trang ${p+1}'>
                                </c:forEach>
                                <c:if test="${page.index!=page.totalPage-1}">
                                    <input type='submit' name='btnNext' value='&gt;'>
                                    <input type='submit' name='btnEnd' value='&gt;&gt;'>
                                </c:if>
                            </form>
    </body>
</html>
