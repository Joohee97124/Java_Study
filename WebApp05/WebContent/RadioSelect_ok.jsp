<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 한글깨짐 방지
	request.setCharacterEncoding("UTF-8");
	
	// 데이터 받아오기
	String name = request.getParameter("name");		 //-- 텍스트박스... 단일값 수신
	String gender = request.getParameter("gender");	//-- 라디오버튼... 단일값 수신
	String subject = request.getParameter("major");	//-- 선택상자.... 단일값 수신 (multiple 옵션 지정X)
	String[] hobby = request.getParameterValues("hobby");	//-- 
	//-- 다중 선택이 가능한 선택상자일 경우... 배열 형태로 수신
	
	String genderStr = "";
	if (gender != null)
	{
		if (gender.equals("M"))
			genderStr = "남자";
		else if(gender.equals("F"))
			genderStr = "여자";
		else
			genderStr = "확인불가";
	}
	else
		genderStr = "확인불가";
	// url에서 지정해서 넘겼을 때 (RadioSelect.jsp를 사용하지 않았을 때) 문제가 생기지 않게 
	// 지정해서 null → 확인불가로 만들어주기
		
	
	String hobbyStr ="";
	if (hobby != null)
	{
		for(String item : hobby)
		{
			hobbyStr += "[" + item + "]";
		}
	}

	

	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RadioSelect_ok.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<div>
	<h1>JSP 데이터 송수신 실습</h1>
	<hr>
	<p>RadioSelect.jsp → RadioSelect_ok.jsp● </p>
</div>

<div>
	<h2>radio, select 데이터 수신</h2>
	
	<div>
		<h3>수신한 데이터 </h3>
		
		<!-- <p> 이름 : 박나현 </p> -->
		<p> 이름 : <%=name %><br> </p>
		
		<!-- <p> 성별 : F(여자) </p> -->
		<p> 성별 : <%=gender %>(<%=genderStr %>)<br> </p>
		
		<!-- <p> 전공 : 국문학 </p> -->
		<p> 전공 : <%=subject %><br> </p>
		
		<!-- <p> 취미 : [음악감상] [산악등반] </p> -->
		<p> 취미 : <%=hobbyStr %><br> </p>
	</div>
	
</div>

</body>
</html>