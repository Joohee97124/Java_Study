<%@page import="com.test.Calc"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:useBean id="ob" class="com.test.Calc" scope="page" />
<!-- scope는 명시하지 않더라도 디폴트가 page -->

<jsp:setProperty property="*" name="ob" />
<!-- 다~~~~~~너가 알아서해! 어쨌든 프로퍼티 값을 다 채워놔라!  -->

<!-- <jsp:setProperty property="su1" name="ob" /> -->
<!-- request.getP 형변환 값 넘기기 다 너가 해줘 !! -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cal_ok3.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<div>
	<h1>세 번째 방법 처리 결과</h1>
	<hr>
</div>
	
<div>
	<h2><%=ob.result() %></h2> 
</div>


</body>
</html>