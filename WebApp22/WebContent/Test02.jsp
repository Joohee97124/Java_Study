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
<title>Test02.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=cp%>/css/main.css">

</head>
<body>

<div>
   <h1>JSTL 코어(Core) if문 실습</h1>
   <hr>
</div>

<div>
   <!-- form 태그에서 action 속성을 생략할 경우 
      전송하는 데이터의 수신처는 자기 자신이다.-->
   <form method="post">
      정수 : <input type="text" name="su"><br><br>
      <button type="submit" class="btn"
      style="width: 120px; font-size: 16pt;">결과 확인</button>
   </form>
</div>

<div>
   <%-- <h2>${param.su }</h2> --%>
   
   <%-- 『<c:if test=""></c:if>』 : JSTL Core if문. Else 가 없고 if만 존재한다. --%>
   <%-- 『test=""』  : 조건식 지정. 파라미터로 수신한 su에 값이 있으면 … --%>
   <%-- 『param.su』 : EL을 활용한 폼 전송 데이터 수신하는 부분--%>
   
   <c:if test="${!empty param.su }">
   <!-- El에서 수신하지 못한값에 대한 처리는 empty 로 처리된다. 
       앞에 부정 논리연산자 사용 가능-->
   
      <c:if test="${param.su % 2 == 0}">
         <h2>${param.su } : 짝수</h2>
      </c:if>
      
      <c:if test="${param.su % 2 != 0 }">
         <h2>${param.su } : 홀수</h2>
      </c:if>
   </c:if>
   
</div>

</body>
</html>