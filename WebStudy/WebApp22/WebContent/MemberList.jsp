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
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">

<style type="text/css">
	td {test-align: center;}
</style>

</head>
<body>

<div>
   <h1>JSTL 코어(Core) 문제</h1>
   <h2>회원 명단</h2>
   <hr>
</div>



<div>
	<table class="table">
		<tr>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
		<tr>
		
		<!-- dto들이 들어있는 자료구조 받아오기 → items 잊지말기! -->
		<c:forEach var="dto" items="${lists }" >
		<tr>
			<td>${dto.name }</td>
			<!-- 프로퍼티에 접근하면 getter 알아서 호출해줌~!! -->
			<td>${dto.tel }</td>
			<td>${dto.addr }</td>
		</tr>
		</c:forEach>
		
	</table>
</div>

</body>
</html>