<%@page import="com.test.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<jsp:useBean id="dto" class="com.test.BoardDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto" />

<%
	Connection conn = DBConn.getConnection();
	BoardDAO dao = new BoardDAO(conn);
	
	// 데이터 번호 num 가져오기
	
	
	// 새로운 정보들 set 하기
	
	
	// 데이터베이스 액션 처리
	dao.updateData(dto);
	
	DBConn.close();
	
	// Article.jsp 요청할 수 있도록 하기
	response.sendRedirect("Article.jsp");
%>