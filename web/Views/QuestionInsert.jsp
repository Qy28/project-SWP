<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function yesnoCheck(that, loop) {
                if (that.value == 5) {
                    document.getElementById("nums" + loop).style.display = "block";
                } else {
                    document.getElementById("nums" + loop).style.display = "none";
                }
            }
            function checkRead(loop) {
                let n = parseInt(document.getElementById("numinp" + loop).value);
                if (n + loop >${quesN}) {
                    alert("Exceeded number of question");
                } else {
                    for (let i = loop + 1; i < loop + n; i++) {
                        document.getElementById("type" + i).value = 1;
                        document.getElementById("type" + i).disabled = true;
                    }
                }
                for(let i = loop + n; i < ${quesN}; i++)
                        document.getElementById("type" + i).disabled = false;
                        document.getElementById("type" + i).value = 1;
            }
        </script>
    </head>
    <body>       
        <h3><a href="TestInsert?type=3" >Return</a></h3>
        <form action="QuestionInsert" method="post">
            <c:forEach begin="1" end="${quesN}" varStatus="loop" >
                <table>
                    <tr>
                    <h2>Question: ${loop.index}</h2>
                    <label for="type">Test Type:</label>
                    <select required id="type${loop.index}" name="type${loop.index}" onchange="yesnoCheck(this,${loop.index})">
                        <c:forEach  items="${daoType.ques}" var="typ" >
                            <option   value="${typ.questionTypeId}">${typ.typeName}</option>
                        </c:forEach>
                    </select>
                    <label id="nums${loop.index}" style="display: none">Enter the number of question<input onkeyup="checkRead(${loop.index})" id="numinp${loop.index}" type="number" max="255"  name="numsQues${loop.index}"/></label>
                    </tr>
                    <tr>
                        <td>Question Detail:</td>
                        <td><textarea name=question${loop.index} rows="10" cols="200" required> </textarea>
                    </tr>

                </table>
                    <c:forEach begin="1" end="4" varStatus="lop">
                        <input ${lop.index==1?"required":""} required type="radio" name="rightChoice${loop.index}" value="${lop.index}" <td>${Character.valueOf(lop.index+64)}<textarea rows="3" cols="200"  name="choice${lop.index}:question${loop.index}" ></textarea>
                        <br/>
                    </c:forEach>
                        <h2>Answer Detail:</h2>
                        <textarea name=ans${loop.index} rows="10" cols="200"> </textarea>
                </c:forEach>
                        <input style="display: none;" type="number" value="${quesN}" name="numQues"/>
            <input type='submit' name='type${type}' value='Submit'>
        </form>
    </body>
</html>
