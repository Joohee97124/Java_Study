<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	
	// 결과값
	String str = "";

	// 데이터베이스 연결
	Connection conn =DBConn.getConnection();
	
	// 쿼리문 준비(select)
	String sql = "SELECT SID, NAME, KOR, ENG, MAT FROM TBL_SCORE ORDER BY 1";
	
	// 작업객체 생성
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	// 출력 테이블 구성을 위한 준비
	str += "<table><tr><th>번호</th><th>이름</th><th>국어</th><th>영어</th><th>수학</th><th>총점</th><th>평균</th>";
	
	int tot = 0;
	double avg = 0;
	
	while(rs.next())
	{
		tot = rs.getInt("KOR") + rs.getInt("ENG") + rs.getInt("MAT");
		avg = tot/3.0;
		
		
		str += "<tr>";
		
		str += "<td>" + rs.getString("SID") + "</td>";
		str += "<td>" + rs.getString("NAME") + "</td>";
		str += "<td>" + rs.getInt("KOR") + "</td>";
		str += "<td>" + rs.getInt("ENG") + "</td>";
		str += "<td>" + rs.getInt("MAT") + "</td>";
		str += "<td>" + tot + "</td>";
		str += "<td>" + String.format("%.1f", avg) + "</td>";
		
		str += "</tr>";
		
	}
		str += "</table>";
		
		rs.close();
		stmt.close();
		DBConn.close();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ScoreList.jsp</title>

<style type="text/css">

	.nameMsg { font-size: small; color: red; display: none;}
	.korMsg { font-size: small; color: red; display: none;}
	.engMsg { font-size: small; color: red; display: none;}
	.matMsg { font-size: small; color: red; display: none;}
	
</style>

<script type="text/javascript">

	function formCheck()
	{
		//return false;
		
		var uName = document.getElementById("userName");
		var uKor = document.getElementById("userKor");
		var uEng = document.getElementById("userEng");
		var uMat = document.getElementById("userMat");
		
		var nMsg = document.getElementById("nameMsg");
		var korMsg = document.getElementById("korMsg");
		var engMsg = document.getElementById("engMsg");
		var matMsg = document.getElementById("matMsg");
		
		nMsg.style.display = "none";
		
		if (uName.value == "")
		{
			nMsg.style.display = "inline";
			userName.focus();
			return false;
		}
		
		// 여기부터 오류 겁나뜬다 ~~!!!
		if (uKor > 100 || uKor < 0)
		{
			korMsg.style.display = "inline";
			return false;
		}
		
		if (uEng > 100 || uEng < 0)
		{
			engMsg.style.display = "inline";
			return false;
		}
		
		if (uMat > 100 || uMat < 0)
		{
			matMsg.style.display = "inline";
			return false;
		}
		
		
		return true;
		
	}

</script>

</head>
<body>

<div>
	<h1>성적 처리 페이지</h1>
	<hr>
</div>

<div>
	<form action="ScoreInsert.jsp" method="post" onsubmit="return formCheck()">
		<table>
			<tr>
				<th>이름(*)</th>
				<td>
					<input type="text" id="userName" name="userName">
					<span class="nameMsg" id="nameMsg">이름 입력 확인</span>
				</td>
			</tr>
			<tr>
				<th>국어점수</th>
				<td>
					<input type="text" id="userKor" name="userKor">
					<span class="korMsg" id="korMsg">0~100 사이의 정수만 입력해주세요</span>
				</td>
			</tr>
			<tr>
				<th>영어점수</th>
				<td>
					<input type="text" id="userEng" name="userEng">
					<span class="engMsg" id="engMsg">0~100 사이의 정수만 입력해주세요</span>
				</td>
			</tr>
			<tr>
				<th>수학점수</th>
				<td>
					<input type="text" id="userMat" name="userMat">
					<span class="matMsg" id="matMsg">0~100 사이의 정수만 입력해주세요</span>
				</td>
			</tr>
			<tr>
				<th></th>
				<td>
					<button type="submit" id="btnAdd" class="btn">성적 추가</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<div>
	<%= str %>
</div>



</body>
</html>