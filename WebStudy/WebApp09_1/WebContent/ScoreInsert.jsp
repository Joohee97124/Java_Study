<%@page import="java.sql.Statement"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%

	// 한글 인코딩
	request.setCharacterEncoding("UTF-8");

	// 데이터 수신
	String name = request.getParameter("userName");
	String kor = request.getParameter("userKor");
	String eng = request.getParameter("userEng");
	String mat = request.getParameter("userMat");
	
	// 데이터베이스 연결
	Connection conn = DBConn.getConnection();
	
	// 쿼리문 준비
	String sql = String.format("INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT)" 
			+ " VALUES(SCORESEQ.NEXTVAL, '%s', %s, %s, %s)", name, kor, eng, mat);
	
	// 작업객체 생성
	Statement stmt = conn.createStatement();
	int result = stmt.executeUpdate(sql);
	
	stmt.close();
	DBConn.close();
	
	
	if (result < 1)
	{
		response.sendRedirect("Error02.jsp");
	}
	else
	{
		response.sendRedirect("ScoreList.jsp");
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>