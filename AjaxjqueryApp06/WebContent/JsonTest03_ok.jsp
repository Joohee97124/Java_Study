<%@page import="net.sf.json.JSONObject"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	// JsonTest03_ok.jsp
	
	String name = request.getParameter("name");
	String content = request.getParameter("content");
	
	String result = "";
	
	
	// JSON 데이터
	// {"이름1 : 값1" , "이름2 : 값2"}
	
	// 라이브러리 사용하기
	JSONObject jsonObject = new JSONObject();
	
	jsonObject.put("num", 100);
	jsonObject.put("name", name);
	jsonObject.put("content", content);
	
	result = jsonObject.toString();
	
	out.println(result);
	
	
	/*
	■■■ JSON 라이브러리 ■■■
	
	① json-lib-x.x-jdkxx.jar		 → 핵심 기본 라이브러리
	② ezmorph-x.x.x.jar			 → 의존관계 필수 라이브러리
	③ commons-beanutils-x.x.x.jar   → 의존관계 필수 라이브러리
	④ commons-collections-x.x.x.jar → 의존관계 필수 라이브러리
	⑤ commons-lang-x.x.jar			 → 의존관계 필수 라이브러리
	⑥ commons-logging-x.x.jar		 → 의존관계 필수 라이브러리
	
	※ 핵심 기본 라이브러리 (json-lib-x.x-jdkxx.jar)
	1. 『http://www.json.org』 요청 및 접근
	2. 페이지 하단의 『Java』 카테고리의 『Json-lib』 클릭
	   → 『http://json-lib.sourceforge.net/』 으로 이동
	3. 페이지 왼편의 Download 클릭
	   → 『https://sourceforge.net/projects/json-lib/files/』 으로 이동
	4. 페이지 리스트 중 『json-lib』 클릭
	   → 『https://sourceforge.net/projects/json-lib/files/json-lib』로 이동
	5. 페이지 리스트 중 『json-lib-2.4』클릭
	   → 『https://sourceforge.net/projects/json-lib/files/json-lib/json-lib-2.4/』로 이동
	6. 페이지 리스트 중 『json-lib-2.4-jdk15.jar』 클릭
	   → 『json-lib-2.4-jdk15.jar』 파일 다운로드
	   
	*/
	
	
%>
