<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	// JsonTest01_ok.jsp
	
	String name = request.getParameter("name");
	String content = request.getParameter("content");
	
	String result = "";
	
	
	// JSON 데이터
	// {"이름1 : 값1" , "이름2 : 값2"}
	// 한땀한땀 문자열로 json 형식을 만들어주었다! 
	
	StringBuffer sb = new StringBuffer();
	
	/* 따옴표 구성에 유의~!!! */
	sb.append("{\"num\":\"" + 1 + "\"");
	sb.append(", \"name\":\"" + name + "\"");
	sb.append(",\"content\":\"" + content + "\"}");
	
	result = sb.toString();
	// toString() : 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴
	
	out.println(result);
	// 표현식을 이렇게 해주기
	
	
	
%>
