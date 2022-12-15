/*======================
 	MemberListController.java

======================*/


package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.logic.MemberListModel;

public class MemberListController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 모델 객체 생성
		try
		{
		MemberListModel model = new MemberListModel();
		String view = model.actionCount(request,response);
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
}
