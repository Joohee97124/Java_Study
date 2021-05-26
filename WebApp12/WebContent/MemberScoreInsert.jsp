<%@page import="com.test.MemberScoreDTO"%>
<%@page import="com.test.MemberScoreDAO"%>
<%@page import="com.test.MemberDTO"%>
<%@page import="com.test.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 1 MemberScoreInsert.jsp
	
	//5 이전 페이지(MemberScoreInsertForm.jsp) 로부터 데이터 수신
	// → sid, kor, eng, mat
	//   -----
	// MemberScoreInsertForm에서는 다른데에서 sid를 받아와서 표현하기만 했음
	// → 여기서 받아올 수가 없어 → hidden태그 , get방식 둘 중 하나 해줘야해! 
	
	String sid = request.getParameter("sid");
	String korStr = request.getParameter("kor");
	String engStr = request.getParameter("eng");
	String matStr = request.getParameter("mat");
	
	//6 MemberScoreDAO 인스턴스 생성
	MemberScoreDAO dao = new MemberScoreDAO();
	
	
	try
	{		
		dao.connection();
		
		//4 MemberScoreDTO 구성 ( SID, KOR, ENG, MAT ) → 수신된 데이터로 구성
		MemberScoreDTO dto = new MemberScoreDTO();
		
		dto.setSid(sid);
		dto.setKor(Integer.parseInt(korStr));
		dto.setEng(Integer.parseInt(engStr));
		dto.setMat(Integer.parseInt(matStr));		
		
		//2 add() 메소드 호출 → SID, KOR, ENG, MAT 만 채우면 실행 가능
		// → 데이터 입력 (insert 수행)
		dao.add(dto);
		
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


	//3 MemberScoreSelect.jsp 안내 ← 새로운 페이지 요청할 수 있도록 처리
	response.sendRedirect("MemberScoreSelect.jsp");
%>