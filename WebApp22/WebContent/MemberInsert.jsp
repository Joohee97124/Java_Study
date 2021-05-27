<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.test.core.MemberDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

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
	
	
	
	
	/*
	request.setAttribute("name", name);
	request.setAttribute("tel", tel);
	request.setAttribute("addr", addr);
	*/
	
%>

<jsp:forward page="MemberList.jsp"></jsp:forward>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberInsert.jsp</title>
</head>
<body>

<%-- 
<div>
	<c:set var="url" value="MemberList.jsp"></c:set>
	<c:import url="${url }" var="List"></c:import>
	<c:out value="${List }" escapeXml="false"></c:out>
</div>
 --%>
</body>
</html>