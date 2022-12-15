<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 한글 인코딩 꼭 해주기!!!!
 	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="ob" class="com.test.GuestDTO"></jsp:useBean>
<!-- id는 객체 생성 시 이름을 정해주는 것처럼 편하게 이름 정해주면 된다 -->

<jsp:setProperty name="ob" property="userName" ></jsp:setProperty>
<jsp:setProperty name="ob" property="subject" ></jsp:setProperty>
<jsp:setProperty name="ob" property="content" ></jsp:setProperty>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest_ok.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<div>
	<h1>간단한 기본 방명록 작성 실습(DB 연동 없음)</h1>
	<hr>
</div>

<div>
	<h2>작성된 내용 확인</h2>
	<h3>이름 :  <%= ob.getUserName() %></h3>
	
	<h3>제목 : <%= ob.getSubject() %></h3>
	
	<h3>내용 : <%= ob.getContent().replaceAll("\n", "<br>") %> </h3>
	<!-- 개행 처리 잊지 말고 해주기! -->
	
</div>


</body>
</html>