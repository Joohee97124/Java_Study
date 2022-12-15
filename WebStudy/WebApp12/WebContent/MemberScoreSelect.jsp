<%@page import="com.test.MemberScoreDTO"%>
<%@page import="com.test.MemberScoreDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%

   StringBuffer str  =  new StringBuffer();
   MemberScoreDAO dao = new MemberScoreDAO();

   try
   {
      //데이터 베이스 연결
      dao.connection();
      
      str.append("<table class='table'>");
      str.append("<tr>");
      str.append("<th class='numTh'>번호</th>");
      str.append("<th class='nameTh'>번호</th>");
      str.append("<th class='txtScore'>국어</th><th>영어</th><th>수학</th>");
      str.append("<th class='txtScore'>총점</th><th>평균</th><th>석차</th>");
      str.append("<th>성적관리</th>");
      str.append("</tr>");

      for(MemberScoreDTO score : dao.lists())
      {
         str.append("<tr>");
         
         str.append("<td>"+score.getSid()+"</td>");
         str.append("<td>"+score.getName()+"</td>");
         str.append("<td>"+score.getKor()+"</td>");
         str.append("<td>"+score.getEng()+"</td>");
         str.append("<td>"+score.getMat()+"</td>");
         str.append("<td>"+score.getTot()+"</td>");
         str.append("<td>"+score.getAvg()+"</td>");
         str.append("<td>"+score.getRank()+"</td>");
         
         if (score.getKor()==-1 && score.getEng()==-1 && score.getMat()==-1)
            {
               str.append("<td>");
               str.append("<a href='MemberScoreInsertForm.jsp?sid="+ score.getSid()+ "'>");
               str.append("<button type='button' class='btn01'>"+"입력"+"</button>");
               str.append("</a>");
               
               /* 기능하지 않음 */
               str.append("<button type='button' class='btn02'>"+"수정"+"</button>");
               str.append("<button type='button' class='btn02'>"+"삭제"+"</button>");
               
               str.append("</td>");
            }
            else
            {
               str.append("<td>");
               /* 기능하지 않음 */
               str.append("<button type='button' class='btn02'>"+"입력"+"</button>");
               
               /* 기능함 */
               str.append("<a href='MemberScoreUpdateForm.jsp?sid="+ score.getSid() +"'>");
               str.append("<button type='button' class='btn01'>"+"수정"+"</button>");
               str.append("</a>");
               
               str.append("<a href='javascript:memberScoreDelete("+ score.getSid() + ", \"" + score.getName() + "\")'>");
               str.append("<button type='button' class='btn01'>"+"삭제"+"</button>");
               str.append("</a>");
               
               str.append("</td>");
            }
         
         str.append("</tr>");
      
      }
      
      str.append("</table>");
   }
   catch(Exception e)
   {
      System.out.println(e.toString());
   }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberScoreSelect.jsp</title>
<link rel="stylesheet" type="text/css" href="css/MemberScore.css">

<script type="text/javascript">
	
	function memberScoreDelete(sid, name)
	{
		//alert("성공");
		
		var res = confirm("번호 : "+ sid +"이름 : " + name +" 의 데이터를 삭제하시겠습니까?");
		
		if(res)
			window.location.href="MemberScoreDelete.jsp?sid="+sid;

	}

</script>
</head>
<body>

<!-- http://localhost:8090:WebApp12/MemberScoreSelect.jsp -->
<div>
   <h1>회원 명단 관리 및 출력 페이지</h1>
   <hr>
</div>

<div>
   <a href="MemberSelect.jsp"><button type = "button">회원 명단 관리</button></a>
</div>

<div>
<br><br>
<%=str %>
</div>
</body>
</html>