<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	// 1 쿠키 생성
	Cookie c = new Cookie("cookie_test", "studyCookie");
	// (이름, value)
	
	// 3 쿠키 설정 
	c.setMaxAge(3600);
	// c.setMaxAge(5);
	// 5초 뒤면 쿠키가 삭제 되어 그 이후에 정보설정 버튼 눌러도 쿠키가 보이지 않음
	
	// 2 쿠키 추가
	 response.addCookie(c);	
	// → 클라이언트에게 . 쿠키넘겨주기 (클라이언트 = 각각의 브라우저 에게 심어져있음)
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestSetCookie.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<div>
	<h1>쿠키 설정 및 추가</h1>
	<hr>
</div>

<div>
	<a href="TestGetCookie.jsp"><button type="button" class="btn">쿠키 정보 확인</button></a>
	<a href="TestRemoveCookie.jsp"><button type="button" class="btn">쿠키 정보 삭제</button></a>
</div>


</body>
</html>