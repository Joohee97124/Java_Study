<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String resultStr = (String)request.getAttribute("resultStr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive11.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<div>
	<h1>데이터 송수신 실습 11</h1>
	<hr>
</div>

<div>
	<h2>최종 수신 페이지 (Receive11.jsp)</h2>
	<h3>연산결과 : <%=resultStr %></h3>
</div>


</body>
</html>