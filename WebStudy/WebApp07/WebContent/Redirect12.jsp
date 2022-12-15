<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// Redirect12.jsp
	
	// 데이터 수신
	String num1Str = request.getParameter("num1");
	String num2Str = request.getParameter("num2");
	String op = request.getParameter("calResult");
	
	int num1, num2;
	num1 = num2 = 0;
	
	String str = "";
	
	try
	{
		num1 = Integer.parseInt(num1Str);
		num2 = Integer.parseInt(num2Str);
		
		if(op.equals("1"))
			str = String.format("%d", (num1+num2));
		else if(op.equals("2"))
			str = String.format("%d", (num1-num2));
		else if(op.equals("3"))
			str = String.format("%d", (num1*num2));
		else if(op.equals("4"))
			str = String.format("%.1f", (num1/(double)num2));
		
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
	
	
	// request.setAttribute("resultSet",result);
	// 보내도 소용이 없다,.
	// Receive12에서 만날 request는 여기와 다른 새로운 request
	
	
	// check~!!!
	// 결과 데이터 재전송!!! → sendRedirect() 메소드 사용
	// ※ response 객체의 주요 메소드 중 하나인
	// 『sendRedirect(String location)』
	// : 지정된 URL(location)로 요청을 재전송한다
	response.sendRedirect("Receive12.jsp?num1="+num1+"&num2="+num2+"&op="+op+"&str="+str);

	// 너 여기로 다시 가겠니?
	
	
%>
