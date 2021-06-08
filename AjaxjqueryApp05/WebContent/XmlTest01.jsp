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
<title>XmlTest01.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	
	$(function()
	{4t
		$("#sendBtn").click(function()
		{
			var params = "name=" + $.trim($("#name").val())
				+ "&content=" + $.trim($("#content").val());
			
			$.ajax(
			{
				type : "POST"
				, url : "XmlTest01_ok.jsp"
				, data : params
				, datatType : "xml"			// 데이터타입 = xml 로 부여
				
				// args로 받게 되는 것 = xml 전체 (사진 전체)
				, success : function(args)
				{
					var out = "";
					out = ">> 게시물 갯수 : " + $(args).find("total_dataCount").text() + "<br>";
					// args(xml) 에서 total_dataCount의 text를 찾아라
					
					
					// check~!!!!
					$(args).find("comment").each(function()
					{
						var item = $(this);
						// this = 각각 처리되는 하나의 comment 
						
						var num = item.attr("num");
						
						var name = item.find("name").text();
						
						var content = item.find("content").text();
						
						
						out += "<br>===============================";
						out += "<br>번호 : " + num;
						out += "<br>이름 : " + name;
						out += "<br>내용 : " + content;
						out += "<br>===============================<br>";
					
					});
					// comment 는 현재 5개 있는데, 각각 처리할 때 쓰는 함수 = each()
					
					$("#resultDiv").html(out);
					// 이 결과를 resultDiv에 삽입
					
					$("#name").val("");
					$("#content").val("");
					$("#name").focus();
					
				}
				, beforeSend : showRequest	// true/false
				, error : function(e)
				{
					alert(e.responseText);	// 클라이언트 쪽에서 봄
					console.log(e);			// 서버쪽에서 봄
				}
				
			
			});
		})
	});
	
	
	function showRequest()
	{
		var flag = true;
		
		if(!$.trim($("#name").val()))
			// name의 값이 입력되어있지 않으면~ (공백도 입력안된걸로 처리)
		{
			alert("이름을 입력해야 합니다");
			$("#name").focus();
			flag = false;
		}
		
		if(!$.trim($("#content").val()))
		{l
			alert("내용을 입력");
			$("#content").focus();
			flag= false;
		}
		
		return flag;
				
	}
	
</script>

</head>
<body>

<div>
	<h1>jQuery 의 ajax() 메소드 실습</h1>
	<p>xml control</p>
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
<br>
<br>


</body>
</html>