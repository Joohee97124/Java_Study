package com.test.logic;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInsertFormModel
{
	public String process(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		String result ="";
		
		request.setCharacterEncoding("UTF-8");
		
		result = "WEB-INF/view/MemberInsertForm.jsp";
		return result;
	}
}
