<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String userId = (String)session.getAttribute("userId");
	
	if(userId==null)
		response.sendRedirect("TestSession01.jsp");
	// userId가 없으면 첫화면으로 돌아가! 
	// 여기는 userId가 있는 사람들만 들어올 수 있어!
	
	
	// 세션 아이디
	String sid = session.getId();
	int t = session.getMaxInactiveInterval();
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestSession02.jsp</title>
</head>
<body>

<div>
	<h1>세션 처리 내용 확인</h1>
	<hr>
</div>

<div>
	<h2>여기는 일정관리 페이지</h2>
	<h3>내부적으로 처리되는 세션 식별자(세션 아이디) : <%=sid %> </h3>
	<h3>현재 세션의 유지되는 시간으로 설정된 값 : <%=t %></h3>
</div>

</body>
</html>