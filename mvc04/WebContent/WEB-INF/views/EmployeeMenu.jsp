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
<title>EmployeeMenu.jsp </title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/menuStyle.css"> 
</head>
<body>

<!--------------------------------------------
	#13. EmployeeMenu.jsp
	- 메인 메뉴 페이지 구성
------------------------------------------------> 

<div id="menu">
	<ul>
		<li>
			<a href="" class="menu">직원관리</a>
		</li>
		<li>
			<a href="" class="menu">지역관리</a>
		</li>
		<li>
			<a href="" class="menu">부서관리</a>
		</li>
		<li>
			<a href="" class="menu">직위관리</a>
		</li>
		<li>
			<a href="" class="menu">로그아웃</a>
		</li>
	</ul>
</div>

</body>
</html>