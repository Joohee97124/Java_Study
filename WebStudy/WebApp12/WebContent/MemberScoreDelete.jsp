<%@page import="com.test.MemberScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// MemberScoreDelete.jsp
	// → Member 삭제가 아닌 성적 데이터만 삭제! 
	
	// 이전 페이지로 (MemberScoreSelect.jsp) 로부터 데이터 수신
	// → sid
	
	String sid = request.getParameter("sid");

	MemberScoreDAO dao = new MemberScoreDAO();
	
	try
	{
		dao.connection();
		
		dao.remove(sid);
		
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}
	finally
	{
		try
		{
			dao.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	// 변경된 URL을 다시 요청 할 수 있도록 안내
	response.sendRedirect("MemberScoreSelect.jsp");
%>