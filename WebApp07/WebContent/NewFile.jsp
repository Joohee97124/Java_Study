<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//데이터 수신 후 처리하는 부분
	// 이전페이지로부터 수신한 데이터를 담아둔 변수 이전:자기 자신.
	
	String sYear = request.getParameter("year");
	String sMonth = request.getParameter("month");
	
	// Calendar 객체 생성
	Calendar cal = Calendar.getInstance();
	
		//달력객체로 부터 얻어온 현재값들. 
		//현재 년 , 월,일 수신->현재의 년,월,일 확인
		int nowYear = cal.get(Calendar.YEAR); //2019
		int nowMonth = cal.get(Calendar.MONTH) + 1; //10
		int nowDay = cal.get(Calendar.DAY_OF_MONTH); //24
	
		//화면에 표시할(그릴) 달력의 년,월
		int selectYear = nowYear;
		int selectMonth = nowMonth;
	
		if (sYear != null || sMonth != null)
		{
			selectYear = Integer.parseInt(sYear);
			selectMonth = Integer.parseInt(sMonth);
		}
	/*   
	   <!--<select id="year" name ="year" onchange="formCalendar(this.form)">
	   <option value="2009">2009</option>
	   <option value="2010">2010</option>
	   <option value="2011">2011</option>
	   <option value="2012">2012</option>
	   <option value="2013">2013</option>
	   <option value="2014">2014</option>
	   <option value="2015">2015</option>
	   <option value="2016">2016</option>
	   <option value="2017">2017</option>
	   <option value="2018">2018</option>
	   <option value="2019">2019</option>
	   <option value="2020">2020</option>
	   <option value="2021">2021</option>
	   <option value="2022">2022</option>
	   <option value="2023">2023</option>
	   <option value="2024">2024</option>
	   <option value="2025">2025</option>
	   <option value="2026">2026</option>
	   <option value="2027">2027</option>
	   <option value="2028">2028</option>
	   <option value="2029">2029</option>
	</select>년    
	<select id="month" name="month" onchange="formCalendar(this.form)">
	   <option value="01">01</option>
	   <option value="02">02</option>
	   <option value="03">03</option>
	   <option value="04">04</option>
	   <option value="05">05</option>
	   <option value="06">06</option>
	   <option value="07">07</option>
	   <option value="08">08</option>
	   <option value="09">09</option>
	   <option value="10">10</option>
	   <option value="11">11</option>
	   <option value="12">12</option>
	
	</select>월     -*/
	   
	   //----------------- 확인한 날짜로 년도 select option 구성
	   String yOptions="";
	   
	   for(int year=(selectYear-10); year<=(selectYear+10); year++)
	   {
	      // 상황1. 페이지 최초 요청 --> sYear 는 null, 현재 년도와 옵션값이 같을때
	      // 상황2. 페이지 최초 요청 아닐 때 
	      // 상황3. 나머지 
	      
	      if(sYear==null && year==nowYear)
	      {
	         yOptions += "<option value='"+year+"'selected='selected'>"+year+"</option>";
	      }
	      else if(sYear!=null && Integer.parseInt(sYear)==year)
	      {
	         yOptions += "<option value='"+year+"'selected='selected'>"+year+"</option>";
	      }
	      else
	      {
	         yOptions += "<option value='"+year+"'>"+year+"</option>";   
	      }
	   }
	   
	   String mOptions = "";
	   for(int month=1; month<=12; month++)
	   {
	      // 상황1. 페이지 최초 요청 --> sMonth 는 null, 현재 년도와 옵션값이 같을때
	      // 상황2. 페이지 최초 요청 아닐 때 
	      // 상황3. 나머지 
	      if(sMonth==null && month==nowMonth)
	      {
	         mOptions += "<option value='"+month+"'selected='selected'>"+month+"</option>";
	      }
	      else if(sMonth!=null &&Integer.parseInt(sMonth)==month)
	      {
	         mOptions += "<option value='"+month+"'selected='selected'>"+month+"</option>";
	      }
	      else
	      {   
	         mOptions += "<option value='"+month+"'>"+month+"</option>";
	   
	      }
	   }
	   
	   // 그려야 할 달력의 1일이 무슨 요일인지 확인하기 위한 연산
	   // (만년 달력)--------------------------------------------------------------------------
	   int [] months = {31,28,31,30,31,30,31,31,30,31,30,31};
	   if(selectYear%4==0 && selectYear%100!=0 || selectYear%400==0)
	   {
	      months[1]=29;
	   }
	   
	   //총 날 수 누적
	   int nalsu;
	   
	   //요일 항목 배열 구성
	   String[] weekName = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
	   
	   // 현재년도 -> 일벽받은 년도의 이전 년도 까지의 날 수 연산
	   nalsu = (selectYear-1)*365 + (selectYear-1)/4 - (selectYear-1)/100 + (selectYear-1)/400;
	   
	   // 현재 월 -> 입력
	   for(int i=0; i<selectMonth-1; i++)
	   {
	      nalsu += months[i];
	   }
	   nalsu ++;
	   
	   int week = nalsu%7;   //-- 요일 변수
	   int lastDay = months[selectMonth-1];   //--akwlakr skfWK qustn
	   
	   String calStr = "";
	   calStr += "<table border=1>";
	   calStr += "<tr>";
	   for(int i=0; i<weekName.length; i++)
	   {
	      if(i==0)
	      {
	         calStr += "<th style='color:red;'>" + weekName[i] + "</th>";
	      }
	      else if(i==6)
	      {
	         calStr += "<th style='color:blue;'>" + weekName[i] + "</th>";
	      }
	      else 
	      {
	         calStr += "<th>" + weekName[i] + "</th>";
	      }
	   }
	   
	   calStr +="</tr>";
	   
	   calStr += "<tr>";
	   // 빈 칸 공백 td 발생
	   for(int i=1; i<=week; i++)
	   {
	      calStr += "<td></td>";
	   }
	   //날짜 td 발생
	   for(int i =1; i<=lastDay; i++)
	   {
	      week++;
	
	      //토요일인 오늘
	      if(selectYear ==nowYear && selectMonth==nowMonth && i ==nowDay&& week%7==0)
	      {
	         calStr += "<td class='nowSat' >"+i+"</td>";
	      }
	    //일요일 오늘
	      else if(selectYear ==nowYear && selectMonth==nowMonth && i ==nowDay&& week%7==1)
	      {
	         calStr += "<td class='nowSun' >"+i+"</td>";
	      }
	    //평일인 오늘
	      else if(selectYear ==nowYear && selectMonth==nowMonth && i ==nowDay)
	      {
	         calStr += "<td class='now' >"+i+"</td>";
	      }
	      //오늘이 아닌 토요일
	      else if(week%7==0)
	      {
	         calStr += "<td class='sat' >"+i+"</td>";
	      }
	    //오늘이 아닌 일요일
	      else if(week%7==1)
	      {
	         calStr += "<td class='sun' >"+i+"</td>";
	      }
	    //오늘이 아닌 평일
	      else
	      {
	         calStr += "<td>"+i+"</td>";
	      }
	    //일요일을 찍고 개행하는 곳
	      if(week%7 ==0)
	         calStr += "</tr><tr>";// 닫고 여는 코드가 들어가야함
	   }
	   
	
	   
	   //빈칸 공백 td 발생
	   
	   for(int i=1; i<=week; i++,week++)
	   {	
		   if(week%7==0)
		   {
			   break;
		   }
		   calStr+="<td></td>";
		   
	   }
	   
	   calStr +="</tr>";
	   
	   calStr +="</table>";
	   
	   
	   
	   // --------------------------------------------------------------------------(만년 달력)
	   // 그려야 할 달력의 1일이 무슨 요일인지 확인하기 위한 연산
   
   
   
   
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SendAndReceive11.jsp</title>
<link rel="stylesheet" type ="text/css" href="css/main.css">
<style type="text/css">

	td{text-align:right;}
	td.now{background-color:aqua; font-weight:bold;}
	td.nowSun{background-color:aqua; font-weight:bold; color:red;}
	td.nowSat{background-color:aqua; font-weight:bold; color:blue;}
	td.sun{color:red;}
	td.sat{color:blue;}

</style>


<script type="text/javascript">

   function formCalendar(obj) //스크립트입장에서는 무언가를 매개변수 형태로 넘겨 받아야함
   {      
      obj.submit();
   }
   
   
</script>

</head>
<body>

<!-- 
   ○ 데이터 송수신 실습
      - 달력을 출력하는 JSP 페이지를 구성한다.
      - 년도와 월을 입력받아 화면에 출력해주는 형태의 페이지로 구성한다.
      - 단, submit 버튼 없이 이벤트를 처리한다.
      - 전송한 내용을 자기 자신이 수신해서 출력해주는 형태의 페이지로 구성한다.
      - 년도 구성은 현재 년도 기준으로 이전 10년, 이후 10년으로 구성한다.
      - 월은 1월부터 12월 까지로 구성한다.
      
      [ 2019 ▼ ] 년 [ 10 ▼ ] 월
      
      ---------------------------
      ---------------------------
      ---------------------------
      
      - 년도의 select box 나 월의 select box 의 내용 변화 시
        해당 년 월의 달력을 출력해주는 형태의 페이지로 구성한다.
        
      - 사용자 최초 요충 주소는
        『http://localhost:8090/WebApp05/SendAndReceive11.jsp』로 한다.
         

 -->




<div>
   <h1>JSP 를 이용한 데이터 송수신 실습</h1>
   <hr>
</div>

<div>



   <h2>SendAndReceive11.jsp → SendAndReceive11.jsp </h2>
</div>

   <div>
   <h3>달력 출력</h3>
   </div>
   <div>
   <form action="" method="post">
      <select id="year" name ="year" onchange="formCalendar(this.form)">
      <%=yOptions %>
      </select>년
      <select id="month" name="month" onchange="formCalendar(this.form)">
      <%=mOptions %>
      </select>월
      
    

    
   </form>
   </div>

<div>
<%--
    <h2><%=selectYear %></h2>
   <h2><%=selectMonth %></h2> 
--%>
<%=calStr %>
</div>


</body>
</html>
 



