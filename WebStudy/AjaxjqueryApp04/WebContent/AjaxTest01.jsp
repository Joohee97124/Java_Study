<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjaxTest01.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	$(function()
	{
		$("#sendBtn").click(function()
		{
			var params = "name=" + $.trim($("#name").val())
				+ "&content=" + $.trim($("#content").val());
			// 자바스크립트에서는 trim이 없지만 제이쿼리에서는 있다! 
			
			// jQuery 의 ajax() 함수 사용 (호출)
			$.ajax(
			{
				// 여기 순서는 바뀌어도 상관 없다! 
				type : "POST"	//"GET"			// 데이터 전송 방식
				, url : "AjaxTest01_ok.jsp"		// 요청 페이지
				, data : params					// 요청할때 넘겨줄 데이터들
				, success : function(args)		// callBack (ajax가 성공했을 때 어케 기능하도록 하겠다!) 
				{
					$("#resultDiv").html(args);
					
					$("#name").val("");
					$("#content").val("");
					$("#name").focus();
					
				}
				, beforeSend : showRequest		// 전송 전에 요청 확인 (true/false)
				, error : function(e)			// 에러 발생 시 어케 하겠다
				{
					alert(e.responseText);
				}
			});
		});
	});
	
	
	function showRequest()
	{
		if(!$.trim($("#name").val()))
		{
			alert("이름을 입력해야 합니다");
			$("#name").focus();
			return false;
		}
		
		if(!$.trim($("#content").val()))
		{
			alert("내용을 입력해야 합니다");
			$("#content").focus();
			return false;
		}
		
		return true;
	}

</script>

</head>
<body>

<div>
	<h1>jQuery 의 ajax() 메소드 실습 </h1>
	<hr>
</div>

<div>
	이름 : <input type="text" id="name" class="txt"><br>
	내용 
	<textarea rows="3" cols="50" id="content"></textarea>
	<br><br>
	
	<input type="button" value="등록하기" id="sendBtn" class="btn">	
</div>
<br><br>

<div id="resultDiv">
</div>


</body>
</html>