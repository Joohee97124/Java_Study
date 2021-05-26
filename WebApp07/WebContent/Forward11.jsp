<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String num1Str = request.getParameter("num1");
	String num2Str = request.getParameter("num2");
	String calResult = request.getParameter("calResult");
	
	int num1=0;
	int num2=0;
	String result = "";
	
	try
	{
		num1 = Integer.parseInt(num1Str);
		num2 = Integer.parseInt(num2Str);
		
		if(calResult.equals("1"))
			result = String.format("%d + %d = %d", num1, num2, (num1+num2));
		else if(calResult.equals("2"))
			result = String.format("%d - %d = %d", num1, num2, (num1-num2));
		else if(calResult.equals("3"))
			result = String.format("%d * %d = %d", num1, num2, (num1*num2));
		else if(calResult.equals("4"))
			result = String.format("%d / %d = %.1f", num1, num2, (num1/(double)num2));
		
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
	
	request.setAttribute("resultStr", result);
	// 					    객체이름, 객체 
	// Receive11.jsp에게 보내기
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SampleTest.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<div>
	<h1>데이터 송수신 실습 11</h1>
	<hr>
</div>

<div>
	<jsp:forward page = "Receive11.jsp"></jsp:forward>
</div>


</body>
</html>