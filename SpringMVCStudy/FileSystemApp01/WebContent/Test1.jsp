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
<title>Test1.jsp</title>
</head>
<body>

 
	<form action="Test2.jsp" method="post">
		이름 : <input type="text" name="name"><br>
		파일 : <input type="file" name="upload"><br>
		<input type="submit" name="전송"><br>
	</form> 

	
	<!-- 파일 자체가 전달된 것 (X)
	 파일 이름만 전달된 것 (O) -->
	 
	 

</body>
</html>