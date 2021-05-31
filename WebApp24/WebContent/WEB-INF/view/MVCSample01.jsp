<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath();    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVCBegin.jsp</title>
</head>
<body>
	
<div>
	<h1>MVC 실습 2</h1>
	<hr>
</div>

<div>
	<!-- 컨트롤러로부터 수신한 결과 -->
	<ul>
		<c:forEach var="i" items="${lists }">
			<li>${i }</li>
		</c:forEach>
	</ul>
	<%-- ${lists } 이렇게는 보여지지 않는다! --%>
</div>
	
</body>
</html>