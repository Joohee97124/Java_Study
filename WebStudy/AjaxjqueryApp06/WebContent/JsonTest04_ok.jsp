<%@page import="net.sf.json.JSONObject"%>
<%@page import="net.sf.json.JSONArray"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	// JsonTest04_ok.jsp
	
	String name = request.getParameter("name");
	String content = request.getParameter("content");
	
	String result = "";
	
	
	// JSON 데이터 (배열)
	// [{"이름1" : "값1", "이름2" : "값2", "이름3" : "값3"} , {"이름4" : "값4", "이름5" : "값5", "이름6" : "값6"} ]
	// 요소는 2개
	
	// {"num":"1", "name":"조은선1", "content":"내용1"}
	// {"num":"2", "name":"조은선2", "content":"내용2"}
	// {"num":"3", "name":"조은선3", "content":"내용3"}
	// {"num":"4", "name":"조은선4", "content":"내용4"}
	// {"num":"5", "name":"조은선5", "content":"내용5"}
	
	// [{"num":"1", "name":"조은선", "content":"내용"}
	// , {"num":"2", "name":"조은선", "content":"내용"}
	// , {"num":"3", "name":"조은선", "content":"내용"}
	// , {"num":"4", "name":"조은선", "content":"내용"}
	// , {"num":"5", "name":"조은선", "content":"내용"}]
	// 이렇게 하면 배열 형태 (요소 5개) 가 된다!
	
	
	// 라이브러리 사용하기
	JSONArray jsonArray = new JSONArray();
	
	for(int n=1; n<=5; n++)	// 1 ~ 5
	{
		JSONObject jsonObject = new JSONObject();
		// JSONArray 에는 JSONObject들이 채워져있다
		
		jsonObject.put("num", n);
		jsonObject.put("name", name+n);
		jsonObject.put("content", content+n);
		
		jsonArray.add(jsonObject);
		// jsonArray에 jsonObject 추가하기! 
		
	}
	
	// 테스트
	// System.out.println(jsonArray.toString());
	
	out.println(jsonArray.toString());
	// toString() 해서 출력해주기
	// 스크립틀릿 이후에 무언가 적혀있으면 (html) 그 데이터를 json 형식으로 바인딩해올 수 없다 (표현식 사용 불가)
	// 테스트로 한 내용 뒤에 html 어쩌고가 붙어져서 나오게 되어 json포맷이 아니게된다 -> 출력할 수 없음
			
%>
