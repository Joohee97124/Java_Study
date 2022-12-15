<%@ page contentType="text/html; charset=UTF-8"%>
<%

	// 이전 페이지(Send04.html)로 부터 데이터 수신
	
	// 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("userId");
	String pwd = request.getParameter("userPwd");
	String name = request.getParameter("userName");
	String tel = request.getParameter("userTel");
	
	String gender = request.getParameter("userGender");
	String city = request.getParameter("userCity");
	
	String[] subArr = request.getParameterValues("userSubject");
	
		
	String subject="";
	if(subArr != null)
	{
		for(String item : subArr)
		{
			subject += " [" + item + "]";
		}
	}
	
	// ※ 추후에는 수신된 데이터를 ... 쿼리문을 통해 DB에 입력하는
	//	  과정 등이 포함될 것임을 염두하며 작업을 진행할 수 있도록 하자.
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive04.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

 <div>
 	<h1>데이터 송수신 실습 04</h1>
 	<hr>
 </div>
 
<div>
	<h2>가입 승인 내역</h2>
	<p>아이디 : <%= id %> </p>
	<p>패스워드 : <%= pwd %></p>
	<p>이름 : <%= name %></p>
	<p>전화번호 : <%= tel %></p>
	<p>성별 : <%= gender %></p>
	<p>지역 : <%= city %></p>
	<p>수강과목 : <%= subject %></p>
	
</div>


</body>
</html>