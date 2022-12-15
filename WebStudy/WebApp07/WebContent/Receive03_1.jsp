<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 이전 페이지(Send03.html)로 부터 데이터 수신 
	String str1 = request.getParameter("su1");
	String str2 = request.getParameter("su2");
	
	// 연산자
	String op = request.getParameter("sel");
	
	// 두개의 정수
	int su1,su2;
	su1=su2=0;
	// 연산자 숫자 형태로 변환
	int select=0;
	// 결과값
	int res=0;
	
	try
	{
		su1 = Integer.parseInt(str1);
		su2 = Integer.parseInt(str2);
				
		select = Integer.parseInt(op);
		
		switch (select)
		{
			case 1 : res = su1 + su2; break;
			case 2 : res = su1 - su2; break;
			case 3 : res = su1 * su2; break;
			case 4 : res = su1 / su2; break;
		}
		
			
		
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Receive03.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

<style type="text/css">
	span { color: blue; font-weight: bold; }
</style> 

</head>
<body>

<div>
	<h1>데이터 송수신 실습03</h1>
	<hr>
</div>


<div>
	<h2>두 개의 정수 연산 결과</h2>
	
	<p>
	입력하신 <span><%= su1 %></span>와 <span><%= su2 %></span>의
	연산결과는  <span><%= res %></span> 입니다.
	</p>
	
</div>


</body>
</html>