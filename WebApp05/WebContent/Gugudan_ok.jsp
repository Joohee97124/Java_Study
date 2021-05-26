<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
   // 이전 페이지(Gugudan.jsp)로부터 데이터 수신 → 스크립트 릿 영역
   // request 객체의 getParameter() 메소드 활용 → 이름(name) 식별자
   String danStr = request.getParameter("dan");
   int n = 0;
   
   try
   {
      n = Integer.parseInt(danStr);
   
   } catch (Exception e)
   {
      System.out.println(e.toString());
   }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan_ok.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>

   <div>
      <h1>JSP 데이터 송수신 실습</h1>
      <hr>
      <p>Gugudan.jsp → Gugudan_ok.jsp ●</p>
   </div>

<!-- html 주석문 -->
<%-- JSP 주석문 --%>


<!-- 우리 눈에는 전체적인 for 문이지만 ... 이 body 에서 보여지려면... -->
<%-- 
<%
   for (int i=1; i<=9; i++)
   {%>
      <%=n %> * <%=i %> = <%=(n*i) %><br>   <!-- 이렇게 해야 i가 보여지게 됨 -->   
   <%}

%>
 --%>

<%

   for(int i=1; i<9; i++)
   {
      out.print(n + " * " + i + " = " + (n*i) + "<br>");
   }

%>
 
 

</body>
</html>