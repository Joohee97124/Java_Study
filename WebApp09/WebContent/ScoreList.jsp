<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%
    request.setCharacterEncoding("UTF-8");

   //TBL_MEMBER테이블에 저장된값을 주세요

   //결과값 변수 구성
   String str = "";
     
   //데이터베이스 연결
   Connection conn = DBConn.getConnection();

   // 쿼리문 준비  
   String sql = "SELECT SID, NAME,KOR,ENG,MAT,(KOR+ENG+MAT) AS TOT , ((KOR+ENG+MAT)/3) AS AVG FROM TBL_SCORE ORDER BY SID ASC";
   
   //작업 객체 생성 및 준비된 쿼리문 수행
   //처음 생성한거니  statement작업객체
   Statement stmt = conn.createStatement();
   ResultSet rs = stmt.executeQuery(sql);

   //결과 ResultSet에 대한 처리 ->반복문 구성
   str += "<table class='tb'>";
   str += "<tr>";
   str += "<th>번호</th>";
   str += "<th>이름</th>";
   str += "<th>국어점수</th>";
   str += "<th>영어점수</th>";
   str += "<th>수학점수</th>";
   str += "<th>총점</th>";
   str += "<th>평균</th>";
   str += "</tr>";

   while (rs.next()) {
      str += "<tr>";
      str += "<td>" + rs.getString("SID") + "</td>";
      str += "<td>" + rs.getString("NAME") + "</td>";
      str += "<td class = 'txtNum'>" + rs.getString("KOR") + "</td>";
      str += "<td class = 'txtNum'>" + rs.getString("ENG") + "</td>";
      str += "<td class = 'txtNum'>" + rs.getString("MAT") + "</td>";
      str += "<td class = 'txtNum'>" + rs.getString("TOT") + "</td>";
      str += "<td class = 'txtNum'>" + String.format("%.1f", rs.getDouble("AVG")) + "</td>"; //getDouble만 조심~ ㅋ 스트링으로 더블 갖고오면 어떻게 됨?
      str += "</tr>";
      //<tr>, <td>, </td>없이 아래 표현식에 str찍구 확인하면 번호 이름 국어 영어 수학 총점의 행이 나온다. 
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
<link rel="stylesheet" type="text/css" href="css/main.css">
<style type="text/css">
.listTd {
   text-align: center;
}

.errMsg {
   font-size: small;
   color: red;
   display: none;
}

.txtNum {text-align: center;}

</style>

<script type="text/javascript">
   function formCheck()
   {
      var uName = document.getElementById("userName");
      var nErr = document.getElementById("userMsg");

      var sKor = document.getElementById("scoreKor");
      var kErr = document.getElementById("korMsg");

      var sEng = document.getElementById("scoreEng");
      var eErr = document.getElementById("engMsg");

      var sMat = document.getElementById("scoreMat");
      var mErr = document.getElementById("matMsg");

      nErr.style.display = "none";//이유가 이게 없으면 입력했을 때 남아있게 됨 ! 
      kErr.style.display = "none";
      eErr.style.display = "none";
      mErr.style.display = "none";

      if (uName.value == "")
      {
         nErr.style.display = "inline";
         uName.focus();
         return false;
      }
      
      if (sKor.value == "" || isNaN(sKor.value) || Number(sKor.value) < 0 || Number(sKor.value) > 100)
      {
         kErr.style.display = "inline";
         sKor.focus();
         return false;
      }
      
      if (sEng.value == "" || isNaN(sEng.value) || Number(sEng.value) < 0 || Number(sEng.value) > 100)
      {
         eErr.style.display = "inline";
         sEng.focus();
         return false;
      }
      
      if (sMat.value == "" || isNaN(sMat.value) || Number(sMat.value) < 0 || Number(sMat.value) > 100)
      {
         mErr.style.display = "inline";
         sMat.focus();
         return false;
      }
      return true;

   }
</script>

</head>
<body>

   <div>
      <h1>성적 정보 리스트</h1>
      <hr>
   </div>

   <div>
      <form  action = "ScoreInsert.jsp" method="post" onsubmit="return formCheck()">
         <table class="tbl">
            <tr>
               <th style="width: 80px;">이름(*)</th>
               <td><input type="text" id="userName" name="userName">
                  <span class="errMsg" id="userMsg">이름을 입력해야 합니다.</span></td>
            </tr>
            <tr>
               <th>국어점수</th>
               <td><input type="text" id="scoreKor" name="scoreKor" class="txtNumber"> 
                  <!-- <span class="errMsg" id="korMsg">0에서 100 사이의 점수 입력</span></td> -->
            </tr>

            <tr>
               <th>영어점수</th>
               <td><input type="text" id="scoreEng" name="scoreEng"
                  class="txtNumber"> <span class="errMsg" id="engMsg">0에서
                     100 사이의 점수 입력</span></td>
            </tr>
            <tr>
               <th>수학점수</th>
               <td><input type="text" id="scoreMat" name="scoreMat"
                  class="txtNumber"> <span class="errMsg" id="matMsg">0에서
                     100 사이의 점수 입력</span></td>
            </tr>
            <tr>
               <td colspan="2" style="text =align: left;"><input
                  type="submit" value="등록" class="btn"
                  style="width: 280px; height: 50px font-weight: bold;"></td>
            </tr>
         </table>
      </form>

      <div class="div01"></div>

   </div>
   <div class="div01">
    <%=str%> 
   </div>
</body>
</html>