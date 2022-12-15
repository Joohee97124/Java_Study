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
<title>MemberInsertForm.jsp</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	$(function()
	{
		$("#submitBtn").click(function()
		{
			// 데이터 검사(공란이 있는지 없는 지에 대한 여부 확인)
			if($("#id").val()=="" || $("#name").val()=="" || 
					$("#tel").val()=="" || $("#email").val()=="" )
			{
				$("#err").html("필수 입력 항목이 누락되었습니다.");
				$("#err").css("display", "inline");
				return;		// submit 액션 처리 중단
			}
				
			// 폼 submit 액션 처리 수행
			$("#memberForm").submit();
			
		});
	});

</script>

</head>
<body>

<div>
	<h1>회원 등록</h1>
	<hr>
</div>

<div>
	<form action="memberinsert.action" method="post" id="memberForm">
	<!-- action 확인 -->
	<!-- ※ id의 이름 = DTO의 속성 이름 과 같아야 함 -->
	<table>
		<tr>
			<td>
				<button type="button" style="width: 50px;" class="btn" id="listBtn"
				onclick="location.href='memberlist.action'">회원명단</button>
			</td>
		</tr>	
	
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="id" class="id" placeholder="아이디">
			</td>
 		</tr>
 		
 		<tr>
			<th>패스워드</th>
			<td>
				<input type="text" name="pw" class="pw" placeholder="패스워드">
			</td>
 		</tr>
 		
 		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" class="name" placeholder="이름">
			</td>
		</tr>
			
 		<tr>
			<th>전화</th>
			<td>
				<input type="text" name="tel" class="tel"  placeholder="전화">
			</td>
		</tr> 

 		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="email" class="email" placeholder="이메일">
			</td>
		</tr>	
		
 		<tr>
			<td>
				<button type="button" style="width: 50px;" class="btn" id="submitBtn">회원추가</button>
				
				<span id="err"
             	  style="color: red; font-weight: bold; display: none;"></span>
			</td>
		</tr>	

	</table>
	</form>
</div>

</body>
</html>