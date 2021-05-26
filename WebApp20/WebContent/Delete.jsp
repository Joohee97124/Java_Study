<%@page import="com.test.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<jsp:useBean id="dto" class="com.test.BoardDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>

<%
	// 데이터 받아오기
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	
	// DB연결 및 dao 객체 생성
	Connection conn = DBConn.getConnection();
	BoardDAO dao = new BoardDAO(conn);
		
	int result = dao.deleteData(num);
	// result 결과 값에 따라 분기 처리 가능

	// DB연결 끝
	DBConn.close();
	
	// List.jsp로 돌아가기
	response.sendRedirect("List.jsp");
	
%>