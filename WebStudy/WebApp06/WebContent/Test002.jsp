<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test002.jsp</title>
</head>
<body>
<div>
	<h1>include 디렉티브 실습</h1>
	<hr>
</div>

<%@ include file="Test003.jsp" %>
<!-- Test003 내용을 가지고와서 보여줌 
	 002와 003이 합쳐진 상태에서 페이지를 만듬
	 → 002에 str과 name이 없는데 003과 이미 합쳐졌기에 출력 가넝
 -->
 
 <br><br>
 
 <div>
 	<%=str %><br>
	<%=name %>
</div>



</body>
</html>