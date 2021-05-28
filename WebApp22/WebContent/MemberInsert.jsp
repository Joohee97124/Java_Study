<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.test.core.*"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<%-- 내 풀이
<%
	String[] name = request.getParameterValues("name");
	String[] tel = request.getParameterValues("tel");
	String[] addr = request.getParameterValues("addr");
	
	MemberDTO dto = null;
	
	List<MemberDTO> lists = new ArrayList<MemberDTO>();
	
	for(int i=0; i<name.length; i++)
	{
		dto = new MemberDTO(name[i], tel[i], addr[i]);
		lists.add(dto);
	}
	
	request.setAttribute("lists", lists);

%> 
--%>

<%
	List<MemberDTO> lists= new ArrayList<MemberDTO>();
	
	for(int i=1; i<=5; i++)
	{
		MemberDTO ob = new MemberDTO(
				request.getParameter("name"+i), 
				request.getParameter("tel"+i), 
				request.getParameter("addr"+i));
		
		lists.add(ob);
	}
	
	request.setAttribute("lists", lists);


%>
<!-- 포워딩까지~~!  -->
<jsp:forward page="MemberList.jsp"></jsp:forward>

