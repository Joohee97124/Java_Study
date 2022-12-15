package com.test.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.mvc.MemberDAO;
import com.test.mvc.MemberDTO;

public class MemberListModel
{
	public String actionCount(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException
	{
		String result = "";
		
		MemberDAO dao = new MemberDAO();
		
		Connection conn = dao.getConnection();
		
		ArrayList<MemberDTO> lists = dao.lists();
		
		request.setAttribute("lists", lists);
		
		result = "WEB-INF/view/MemberList.jsp";
		return result;
	}
}
