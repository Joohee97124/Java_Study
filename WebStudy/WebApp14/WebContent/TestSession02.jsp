<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 데이터 수신 (TestSession01.jsp 페이지로부터)
	// → userName, userBirth
	
	request.setCharacterEncoding("UTF-8");
	
	String userName = request.getParameter("userName");
	String userBirth = request.getParameter("userBirth");
	
	session.setAttribute("userName", userName);
	session.setAttribute("userBirth", userBirth);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestSession02.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

<script type="text/javascript">

	function sendIt()
	{
		var f = document.forms[0];
		
		if(!f.userId.value)
		{
			alert("아이디 입력~!!!");
			f.userId.focus();
			return;
		}
		
		if(!f.userPwd.value)
		{
			alert("패스워드 입력~!!!");
			f.userPwd.focus();
			return;
		}
		
		f.submit();
	}

</script>

</head>
<body>

<div>
	<h1>아이디 패스워드(TestSession02.jsp)</h1>
	<hr>
</div>

<div>
	<form action="TestSession03.jsp %>" method="post">
		<%-- 여기는 html 주석이 아닌 jsp 주석이 필요하다!
		     html 주석이면 빨간불은 안들어오지만 페이지에서 오류날 수 있음 
		<input type="hidden" name="userName" value="<%=userName %>">
		<input type="hidden" name="userBirth" value="<%=userBirth %>">
		--%>
		
		
		<table class="table">
			
			<tr>
				<th>아이디 </th>
					<td>
						<input type="text" name="userId" >
					</td>
			</tr>
			
			<tr>
				<th>패스워드</th> 
					<td>
						<input type="text" name="userPwd" >
					</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<button type="button" onclick="sendIt()">다음 페이지로 전송</button>
				</td>
			</tr>
			
		</table>
	</form>
</div>

</body>
</html>