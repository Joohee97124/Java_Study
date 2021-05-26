<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String userId = (String)session.getAttribute("userId");
	String userPwd = (String)session.getAttribute("userPwd");
	
	// hidden 태그로 넘겼을 때 이렇게 받기
	// String userName = request.getParameter("userName");
	// String userBirth = request.getParameter("userBirth");
	
	String userName = (String)session.getAttribute("userName");
	String userBirth = (String)session.getAttribute("userBirth");
	
	session.removeAttribute("userName");
	session.removeAttribute("userBirth");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestSession02.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 
</head>
<body>

<div>
	<h1>전체 출력(TestSession03.jsp)</h1>
	<hr>
</div>

<div>
	<h2>이름 : <%=userName %></h2>
	<h2>생일 : <%=userBirth %></h2>
	<h2>아이디 : <%=userId %></h2>
	<h2>비밀번호 : <%=userPwd %></h2>
</div>


</body>
</html>