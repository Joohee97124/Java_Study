<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmployeeList.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/css/main.css">
</head>
<body>

<!--------------------------------------------
	#14. Employee.List.jsp
	→ 직원 리스트 출력 페이지
	- 관리자가 접근하는 직원 데이터 출력 페이지
	(일반 직원이 접근하는 직원 데이터 출력 페이지는
	 EmpList.jsp 로 구성할 예정)
----------------------------------------------->

<div>
	<!-- 메뉴 영역 -->
	<div>
		<c:import url="EmployeeMenu.jsp"></c:import>
	</div>
	
	
	<!-- 콘텐츠 영역 -->
	<div id="content">
	
		<h1>[ 직원 관리 ]</h1>
		<hr>
		
		<div>
			<form action="">
				<input type="button" value="직원 추가" class="btn">
			</form>
		</div>
		
		<br><br>
		
		
		<!-- EMPLOYEEID NAME BIRTHDAY LUNAR TELEPHONE DEPARTMENTID POSITIONID       
		     REGIONID BASICPAY EXTRAPAY SSN1 SSN2 GRADE   -->
		
		<table id="customers" class="table">
			<tr>
				<!-- 항목 15EA -->
				<th>번호</th>
				<th>이름</th>
				<th>주민번호</th>
				<th>생년월일</th>
				<th>양/음력</th>
				<th>전화번호</th>
				<th>지역</th>
				<th>부서</th>
				<th>직위</th>
				<th>기본급</th>
				<th>수당</th>
				<th>급여</th>
				<th>등급</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			
			<!-- 
			<tr>
				<th>1</th>
				<th>박나현</th>				
				<th>631212</th>				
				<th>1963-12-12</th>				
				<th>양력</th>				
				<th>010-1111-1111</th>				
				<th>서울</th>				
				<th>개발부</th>				
				<th>사원</th>				
				<th>1,500,000</th>				
				<th>1,000,000</th>				
				<th>2,500,000</th>				
				<th>관리자</th>				
				<td><button type="button" class="btn">수정</button></td>			
				<td><button type="button" class="btn">삭제</button></td>			
			</tr> 
			-->
			
			
			<c:forEach var="employee" items="${employeeList }">
				<tr>
					<th>${employee.employeeId }</th>
					<th>${employee.name }</th>
					<th>${employee.ssn }-*******</th>
					<th>${employee.birthday }</th>
					<th>${employee.lunarName }</th>
					<th>${employee.telephone }</th>
					<th>${employee.regionName }</th>
					<th>${employee.departmentName }</th>
					<th>${employee.positionName }</th>
					
					
					<%-- <th>${employee.basicPay }</th> --%>
					<td>
						<fmt:formatNumber value="${employee.basicPay }"
						groupingUsed="true"></fmt:formatNumber>
					</td>
					
					
					<%-- <th>${employee.extraPay }</th> --%>
					<td>
						<fmt:formatNumber value="${employee.extraPay }"
						groupingUsed="true"></fmt:formatNumber>
					</td>
					
				    <%--<th>${employee.pay }</th> --%>
				    <td>
				    	<fmt:formatNumber value="${employee.pay }"
				    	groupingUsed="true"></fmt:formatNumber>
				    </td>
					
					
					<!-- <th>관리자</th> -->	
					<%-- <th>${employee.grade }</th> --%>
					<td>${employee.grade==0 ? "관리자" : "일반직원" }</td>
					
					
					<td><button type="button" class="btn">수정</button></td>			
					<td><button type="button" class="btn">삭제</button></td>
				</tr>
			</c:forEach>
		
		</table>
	</div>
	
	<!-- 회사 소개 및 어플리케이션 소개 영역 -->
	<div id="footer">
		
	</div>
	
 
	
	
</div>

</body>
</html>