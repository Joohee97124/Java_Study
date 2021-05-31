package com.test.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInsertFormModel
{
	public String actionCount(HttpServletRequest request, HttpServletResponse response)
	{
		String result ="";
		
		
		result = "WEB-INF/view/MemberInsertForm.jsp";
		return result;
	}
}
