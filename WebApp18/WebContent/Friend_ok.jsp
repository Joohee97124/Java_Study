<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 한글 인코딩
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="ob" class="com.test.FriendDTO"></jsp:useBean>
<jsp:setProperty name="ob" property="*" />

<!-- 반복문 필요 (다중선택으로 넘어온 결과값 처리) -->
<%
	String str = "";
	if(ob.getHandsome() != null)
	{
		for ( String temp : ob.getHandsome() )
			str += temp + " ";
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Friend_ok.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<div>
	<h1>데이터 출력</h1>
	<hr>
</div>

<div>
	<h3> 이름 : <%=ob.getUserName() %></h3>
	<h3> 나이 : <%=ob.getUserAge() %></h3>
	<h3> 성별 : <%=ob.getUserGender() %></h3>
	<h3> 이상형 : <%=str %></h3>
<%--
 	<h3> 이상형 : 
	<%for(String lover : ob.getHandsome())
	{
	%>
		<%=lover %>
	<%
	}
	%>
	</h3>
--%>
</div>


</body>
</html>