<%@page import="com.test.MemberScoreDTO"%>
<%@page import="com.test.MemberScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");	
	
	//4 이전 페이지(MemberScoreUpdateForm.jsp) 로부터 데이터 수신
	// → sid, kor, eng, mat
	String sid = request.getParameter("sid");
	String kor = request.getParameter("kor");
	String eng = request.getParameter("eng");
	String mat = request.getParameter("mat");
	
	// MemberScoreDAO 인스턴스 생성
	MemberScoreDAO dao = new MemberScoreDAO();
	
	
	
	//2 새로운 페이지(MemberScoreSelect.jsp) 요청할 수 있도록 안내
	
	try
	{
		dao.connection();
		
		//3 MemberScoreDTO 구성
		MemberScoreDTO dto = new MemberScoreDTO();
		
		int kor2 = Integer.parseInt(kor);
		int eng2 = Integer.parseInt(eng);
		int mat2 = Integer.parseInt(mat);
		
		dto.setSid(sid);
		dto.setKor(kor2);
		dto.setEng(eng2);
		dto.setMat(mat2);
		
		//1 update 쿼리문 수행 
		// → MemberScoreDAO의 modify() 메소드 호출 
		// → MemberScoreDTO 매개변수로 전달
		dao.modify(dto);
		
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
	
	response.sendRedirect("MemberScoreSelect.jsp");
%>