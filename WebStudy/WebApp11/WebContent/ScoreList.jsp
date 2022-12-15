<%@page import="com.test.ScoreDTO"%>
<%@page import="com.test.ScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	StringBuffer str = new StringBuffer();
	ScoreDAO dao = null;
	
	String scoreCount = "<span>전체 인원 수 : ";
	
	try
	{
		dao = new ScoreDAO();
		dao.getConnection();
		
		scoreCount += dao.count() + "명</span>";
	   
	   
	   
	   str.append("<table class='table'>");
	   str.append("<th>번호</th><th>이름</th>"
	   + "<th>국어점수</th><th>영어점수</th><th>수학점수</th>"
	   + "<th>총점</th><th>평균</th>");
	   
	   for(ScoreDTO score : dao.lists())
	   {
	      str.append("<tr>");
	      str.append("<td class='record'>" + score.getSid() + "</td>");
	      str.append("<td class='record'>" + score.getName() + "</td>");
	      str.append("<td class='record'>" + score.getKor() + "</td>");
	      str.append("<td class='record'>" + score.getEng() + "</td>");
	      str.append("<td class='record'>" + score.getMat() + "</td>");
	      str.append("<td class='record'>" + score.getTot() + "</td>");
	      str.append("<td class='record'>" + String.format("%.1f", score.getAvg()) + "</td>");
	      str.append("</tr>");
	   }
	   
	   str.append("");
	   str.append("</table>");
	   
	   
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
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SampleTest.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 
<style type="text/css">
	.errMsg {color:red; font-weight:bold; font-size:small; display:none; }
</style>


<script type="text/javascript">
	function formCheck()
	{
		// alert("성공");
		
	  	var userName = document.getElementById("name");
	  	var uKor = document.getElementById("kor");
	  	var uEng = document.getElementById("eng");
	  	var uMat = document.getElementById("mat");
	  	
	  	var nameMsg = document.getElementById("nameMsg");
	  	var korMsg = document.getElementById("korMsg");
	  	var engMsg = document.getElementById("engMsg");
	  	var matMsg = document.getElementById("matMsg");
	  	
	  	nameMsg.style.display = "none";
	  	korMsg.style.display = "none";
	  	engMsg.style.display = "none";
	  	matMsg.style.display = "none";
	  	
	  	if(userName.value =="")
	  	{
	  		nameMsg.style.display="inline";
	  		userName.focus();
	  		return false;	  		
	  	}
	  	
	  	if(uKor.value =="")
	  	{
	  		korMsg.style.display="inline";
	  		uKor.focus();
	  		return false;	  		
	  	}
	  	
	  	if(uEng.value =="")
	  	{
	  		engMsg.style.display="inline";
	  		uEng.focus();
	  		return false;	  		
	  	}
	  	
	  	if(uMat.value =="")
	  	{
	  		matMsg.style.display="inline";
	  		uMat.focus();
	  		return false;	  		
	  	}
	  	
	  	return true;
	  	
	}
</script>

</head>
<body>

<div>
	<h1>데이터베이스 연동 성적처리</h1>
	<hr>
</div>

<div>
	<p>DTO DAO 적용</p>
	<form action="ScoreInsert.jsp" method="post" onsubmit="return formCheck()">
		<table class="table">
			<tr>
				<th>이름(*)</th>
				<td>
					<input type="text" id="name" name="name">
					<span class="errMsg" id="nameMsg">이름을 입력하세요</span>
				</td>
			</tr>
			
			<tr>
				<th>국어점수</th>
				<td>
					<input type="text" id="kor" name="kor">
					<span class="errMsg" id="korMsg">국어 점수를 입력하세요</span>
				</td>
			</tr>
			
			<tr>
				<th>영어점수</th>
				<td>
					<input type="text" id="eng" name="eng">
					<span class="errMsg" id="engMsg">영어 점수를 입력하세요</span>
				</td>
			</tr>
			
			<tr>
				<th>수학점수</th>
				<td>
					<input type="text" id="mat" name="mat">
					<span class="errMsg" id="matMsg">수학 점수를 입력하세요</span>
				</td>
			</tr>
			
			<tr>
				<td>
					<button type="submit" class="btn" id=btnAdd>성적 추가</button>
				</td>
			</tr>
		</table>
	
	</form>
</div>

<div>
	 <%=scoreCount %>
	<br>
	<%=str %>
</div>

</body>
</html>