<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	
	// 캘린더 인스턴스 생성
	Calendar cal  = Calendar.getInstance();
	
	// 현재 년, 월, 일
	int nowYear = cal.get(Calendar.YEAR);			//-- 2021
	int nowMonth = cal.get(Calendar.MONTH) + 1;		//-- 5
	int nowDay = cal.get(Calendar.DAY_OF_MONTH);	//-- 12
	
	// 이전 데이터 									// 화살표를 누르는 순간 바뀜
	String strYear = request.getParameter("year");	// null → 2021
	String strMonth = request.getParameter("month");// null → 5
	
	// 표시할 달력의 년, 월
	int year = nowYear;	
	int month = nowMonth;
	
	if (strYear!=null)						// html 부분에서 넘어온 데이터가 있다면
		year = Integer.parseInt(strYear);	// year,month에 넣어줌 (눌렀을때 달력을 바꿔주기 위해)
	if (strMonth!=null)	
		month = Integer.parseInt(strMonth);
	
	// preYear / preMonth
	int preYear = year;
	int preMonth = month-1;
	
	if (preMonth<1)
	{
		preYear= year-1;
		preMonth=12;
	}
	
	// nextYear / nextMonth
	int nextYear = year;
	int nextMonth = month+1;
	
	if (nextMonth>12)
	{
		nextYear = year+1;
		nextMonth = 1;
	}
	
	// 표시할 달력 셋팅
	cal.set(year,month-1, 1);
	
	int startDay = 1;	// 1일
	int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	// year년 month월 1일의 week 구하기
	// 일요일부터 토요일까지(0~6) 정하고 그 달의 첫번째 날의 요일을
	// 0~6사이의 숫자로 리턴해준다.
	int week = cal.get(Calendar.DAY_OF_WEEK);

	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SendAndReceive08.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<!-- 
	○ 데이터 송수신 실습 08
	   - 달력을 출력하는 JSP 페이지를 구성한다.
	   - 년도와 월을 입력받아 화면에 출력해주는 형태의 페이지로 구성한다.
	   - 단, submit 버튼 없이 이벤트 처리를 한다.
	   - 전송한 내용을 수신해서 출력해주는 형태의 페이지로 구성한다.
	   
	   ◀ 2021 년 5 월 ▶
	   ----------------------------
	   ----------------------------
	   
	   - 『◀』 이나 『▶』 클릭 시
	      해당 년 월의 달력을 출력해주는 형태의 페이지로 구성한다.
	      
	   - 사용자 최초 요청 주소는
	     http://localhost:8090/WebApp07/SendAndReceive08.jsp
	     로 한다.
	     
	○ SendAndReceive08.jsp
	     
 -->

<div>
	<h1>데이터 송수신 실습 08</h1>
	<hr>
</div>

<div>
	<h2>이전 / 이후 달력 출력하기</h2>
	<table>
		<tr>
			<td align="center">
			<a href="SendAndReceive08.jsp?year=<%=preYear %>&month=<%=preMonth %>">◀</a>
			
			<b>&nbsp;<%=year %>년&nbsp;&nbsp;<%=month %>월</b>
			
			<a href="SendAndReceive08.jsp?year=<%=nextYear %>&month=<%=nextMonth %>">▶</a>
			</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td><font color="red">일</font></td>
			<td>월</td>
			<td>화</td>
			<td>수</td>
			<td>목</td>
			<td>금</td>
			<td><font color="blue">토</font></td>
		</tr>
		
		<%
			int newLine=0;	
			
			// 빈칸
			out.print("<tr>");
			for(int i=1;i<week;i++)
			{
				out.print("<td></td>");
				newLine++;
			}
			
			// 1일부터 마지막날까지
			for(int i=startDay; i<=endDay; i++)
			{
				String fontColor=(newLine==0)?"red":(newLine==6)?"blue":"black";
				out.print("<td>" + i + "</td>");
				
				newLine++;
				
				// 7일이고 i가 말일이 아닐때 줄바꿈
				if(newLine==7&&i!=endDay)
				{
					out.print("</tr><tr>");
					newLine=0;
				}
				
				
			}
			
			out.println("</tr>");
		
		%>
	</table>
</div>


</body>
</html>