<%@page import="java.sql.Statement"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// ScoreInsert.jsp
	
	// 한글 인코딩 처리
	request.setCharacterEncoding("UTF-8");
	
	// 이전 페이지(ScoreList.jsp)로부터 데이터 수신(이름, 국어점수, 영어점수, 수학점수)
	// userName, scoreKor, scoreEng, 
	String uName = request.getParameter("userName");
	String uKor = request.getParameter("scoreKor");
	String uEng = request.getParameter("scoreEng");
	String uMat = request.getParameter("scoreMat");
	
	try
	{
		// 데이터베이스 연결
		Connection conn = DBConn.getConnection();
		
		// 쿼리문 준비 → insert 쿼리문
		String sql = String.format("INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT)"
					+" VALUES(SCORESEQ.NEXTVAL, '%s', %s, %s, %s)"
					, uName, uKor, uEng, uMat);
		// 이름만 문자열형태로 , 점수들은 문자열 형태로 가져오지만 오라클에서는 숫자형으로 알아서 적용된다
		
		
		// 작업객체 구성 및 쿼리문 실행 → executeUpdate → 적용된 행의 개수 반환
		// 													--------------------- 요청 페이지 분기 가능
		Statement stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		// 요청 페이지 분기 가능 if(result<1)
		
		// 작업 객체 리소스 반납
		stmt.close();

		
	}
	catch(Exception e)
	{
		// 서버 측 콘솔에서 확인
		System.out.println(e.toString());
	}
	finally
	{
		// 데이터베이스 연결 종료
		DBConn.close();
	}
	
	// 클라이언트 다시 요청해야 할 URL 전달 → sendRedirect() 메소드 활용
	// → ScoreList.jsp
	response.sendRedirect("ScoreList.jsp");
	
%>