<%@page import="com.test.ScoreDTO"%>
<%@page import="com.test.ScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String userName = request.getParameter("name");
	String uKor = request.getParameter("kor");
	String uEng = request.getParameter("eng");
	String uMat = request.getParameter("mat");
	
	
	ScoreDAO dao = null;
	
	try
	{
		dao = new ScoreDAO();
		
		ScoreDTO dto = new ScoreDTO();
		dto.setName(userName);
		dto.setKor(uKor);
		dto.setEng(uEng);
		dto.setMat(uMat);
		
		dao.insert(dto);
		
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
	
	response.sendRedirect("ScoreList.jsp");
	
%>