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
<title>MemberInsert.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<div>
	<h1>데이터 입력 폼</h1>
	<h2>MemberInsertForm.jsp</h2>
	<hr>
</div>

<div>
	<form action="memberinsert" method="post">
	<table class="table" >
		<tr>
			<td>
				ID : <input type="text" name="id">
			</td>
		</tr>
		
		<tr>
			<td>
				PW : <input type="text" name="pw">
			</td>
		</tr>
		
		<tr>
			<td>
				Name : <input type="text" name="name">
			</td>
		</tr>
		
		<tr>
			<td>
				Tel : <input type="text" name="tel">
			</td>
		</tr>
		
		<tr>
			<td>
				Email : <input type="text" name="email">
			</td>
		</tr>
		
		<tr>
			<td>
				<button type="submit">전송하기</button>
			</td>
		</tr>
	
	</table>
	</form>
</div>

</body>
</html>