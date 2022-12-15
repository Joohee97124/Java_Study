package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.util.DBConn;

public class ScoreDAO
{
	// 주요 속성 구성
	private Connection conn;
	
	
	// 주희야~ getConnection() 으로 DB 연결하기로 했으면
	// 이 메소드를 호출해야 데이터베이스 연동이 되는거잖아~~ ㅠㅠ
	//선생님 저는 바보에요,,,,,,,,,죄송해요,,,감사합니다ㅠㅠ
	
	// DB 연결 메소드
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		conn = DBConn.getConnection();
		return conn;
	}
	
	// 성적 입력 메소드
	public int insert(ScoreDTO dto) throws SQLException
	{
		int result = 0;
		
		String sql = "INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT) "
				+ " VALUES(SCORESEQ.NEXTVAL, '?', ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getKor());
		pstmt.setString(3, dto.getEng());
		pstmt.setString(4, dto.getMat());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	
	// 전체 출력 메소드
   public ArrayList<ScoreDTO> lists() throws SQLException
   {
      ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();
      
      String sql = "SELECT SID, NAME, KOR, ENG, MAT"
            + ", (KOR+ENG+MAT) AS TOT, ((KOR+ENG+MAT)/3) AS AVG "
            + " FROM TBL_SCORE ORDER BY SID ASC";
      
      PreparedStatement pstmt = conn.prepareStatement(sql);
      
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next())
      {
         ScoreDTO dto = new ScoreDTO();
         
         dto.setSid(rs.getString("SID"));
         dto.setName(rs.getString("NAME"));
         dto.setKor(rs.getString("KOR"));
         dto.setEng(rs.getString("ENG"));
         dto.setMat(rs.getString("MAT"));
         dto.setTot(rs.getString("TOT"));
         dto.setAvg(rs.getDouble("AVG"));
         
         result.add(dto);         
      }
      
      
      return result;
   }
	
	// 인원 수 확인 메소드
	public int count() throws SQLException
	{
		int result = 0;
		
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_SCORE";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
			result = rs.getInt("COUNT");
		
		System.out.println("count : " + result);
		
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	
	// DB 종료 메소드
	public void close() throws SQLException
	{
		DBConn.close();
	}
}
