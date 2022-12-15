<%@page import="com.test.BoardDTO"%>
<%@page import="com.test.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath();
%>

<jsp:useBean id="dto" class="com.test.BoardDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>

<%
   String pageNum = request.getParameter("pageNum");
   // num은 dto에 있는데 pageNum은 없다! 받아와야 해

   Connection conn = DBConn.getConnection();
   BoardDAO dao = new BoardDAO(conn);
   
    int result = dao.updateData(dto);
    // result 값에 따른 분기 처리 가능
    
   DBConn.close();
    
   response.sendRedirect(cp + "/Article.jsp?pageNum=" + pageNum + "&num=" + dto.getNum());    
      
%>