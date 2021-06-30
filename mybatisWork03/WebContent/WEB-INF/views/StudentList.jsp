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
<title>StudentList.jsp</title>
</head>
<body>

<div>
	<h1>학생 명단</h1>
	<hr>
</div>

<div>
	<!-- 추가버튼 -->
</div>

<div>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
		</tr>
		
		<c:forEach var="student" items="${list }">
			<tr>
				<td>${student.sid }</td>
				<td>${student.name }</td>
				<td>${student.tel }</td>
				<td>
			</tr>
		</c:forEach>
		
	</table>
</div>

</body>
</html>