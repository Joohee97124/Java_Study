<%@ page contentType="text/html; charset=UTF-8"%>
<%

	// 이전 페이지(Send05.html)로 부터 데이터 수신
	String danStr = request.getParameter("dan");
	int dan = 0;
	String result ="";
	
	try
	{
		dan = Integer.parseInt(danStr);
		for(int i=1; i<=9; i++)
			result += String.format("%d * %d = %d<br>", dan, i, (dan*i));
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
<title>Receive05.jsp</title>
<!-- <link rel="stylesheet" type="text/css" href="css/main.css">  -->

<style type="text/css">

.btn
{
 	display: inline-block;
  	padding: 10px 20px;
	font-size: 15px;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	outline: none;
	color: #fff;
	background-color: #4CAF50;
	border: none;
	border-radius: 15px;
	box-shadow: 0 9px #999;
}

.btn:hover {background-color: #3e8e41}

.btn:active 
{
	background-color: #3e8e41;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}

</style>

</head>
<body>

 <div>
 	<h1>데이터 송수신 실습 05</h1>
 	<hr>
 </div>

<div>
	<h2>구구단 실행 결과</h2>
	
	<%=	result%>
	
	
</div>

<br>

<div>
	<form action="Send05.html">
		<button type="submit" class="btn">뒤로가기</button>
	</form>
</div>


</body>
</html>