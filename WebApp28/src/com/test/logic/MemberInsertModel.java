package com.test.logic;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mvc.MemberDAO;
import com.test.mvc.MemberDTO;

public class MemberInsertModel
{
	public String process(HttpServletRequest request, HttpServletResponse response) throws SQLException, UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		String result = "";
		
		MemberDTO dto = new MemberDTO();
		
		// MemberInsertForm.jsp 에서 데이터 받아오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		// dto 구성
		
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setTel(tel);
		dto.setEmail(email);
		
		// MemberDAO 메소드 통해 DB에 데이터 insert
		MemberDAO dao = new MemberDAO();
		int temp = dao.insertMember(dto);
		
		// 데이터 넘겨주기 (추가된 리스트)
		request.setAttribute("lists", dao.lists());
		
		
		// 데이터가 추가되었을 때 이동시키기
		if(temp > 0)
			result = "WEB-INF/view/MemberInsert.jsp";
		
		// dao.close();
		
		return result;
	}
}
