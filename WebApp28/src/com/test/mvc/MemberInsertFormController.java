/*======================
 	SampleServlet.java
 	- 서블릿 샘플
======================*/


package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.logic.MemberInsertFormModel;

public class MemberInsertFormController extends HttpServlet
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
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) 
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			
			// 모델 객체 생성
			MemberInsertFormModel model = new MemberInsertFormModel();
			String view = model.process(request, response);
			
			// Dispatcher 이용
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		

	}
	
}
