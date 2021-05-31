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
<title>MemberList.jsp</title>
</head>
<body>

<div>
	<table>
		<th>ID</th>
		<th>PW</th>
		<th>Name</th>
		<th>Tel</th>
		<th>Email</th>
	</table>
</div>

<div>
	<c:forEach var="i" items="${lists }">
		${i.id }
		${i.pw }
		${i.name }
		${i.tel }
		${i.email }
	</c:forEach>
</div>

<div>
	<form action="memberinsertform" method="post">
	<button type="button">등록하기</button>
	</form>
</div>

</body>
</html>