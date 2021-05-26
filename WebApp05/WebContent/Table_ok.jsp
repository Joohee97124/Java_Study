<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 가로세로 데이터 수신
	String su1 = request.getParameter("su1");
	String su2 = request.getParameter("su2");
	
	int n1=0;
	int n2=0;
	
	// 테이블 안에서 1씩 증가시켜 나갈 변수 선언 및 초기화
	int n = 0;	
	
	try
	{
		// 수신된 데이터 형 변환
		n1 = Integer.parseInt(su1);
		n2 = Integer.parseInt(su2);
		
		
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
<title>Table_ok.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<div>
	<h1>JSP 데이터 송수신 실습</h1>
	<hr>
	<p>Table.jsp → Table_ok.jsp● </p>
</div>

<div>
	<table border="1">
		<%
		for (int i=0; i<n2; i++)
		{
		%>
			<tr>
			<%
			for(int j=0; j<n1; j++)
			{
			%>
					<td style="width:30px;" ><%=++n %></td>
			<%
			}
			%>
			</tr>
		<%
		}
		%>
	</table>
</div>

</body>
</html>