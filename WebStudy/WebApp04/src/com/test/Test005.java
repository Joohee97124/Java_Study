/*===================
 	Test005.java
 	- Servlet 실습
===================*/

package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test005 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	// 직렬화때문에 해줘야 함
	
	// HttpServlet → 추상메소드가 아니다 (재정의할 메소드가 없다!)
	// 서비스 메소드가 호출시켜줄때 get, post 방식이 따로 있다

	
	// get 방식의 요청에 대해 호출되어 실행되는 메소드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
		// doGet에서 받은 매개변수를 doGetPost()로 넘겨서 일처리하게 함
	}
	
	// post 방식의 요청에 대해 호출되어 실행되는 메소드
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGetPost(request, response);
	}
	
	// get 방식의 요청이든 post 방식의 요청이든
	// 모두 처리할 수 있는 사용자 정의 메소드
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 한글 깨짐 방지 처리
		// getParameter 전에 처리해줘야 함
		// 얻어낸 ㄷ이터에 대한 인코딩 방식 지정
		request.setCharacterEncoding("UTF-8");
		
		// 이전 페이지로부터 데이터 수신 (Test005.jsp)
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// 응답을 위한 인코딩 방식 지정
		response.setContentType("text/html; charset=UTF-8");
		
		String str = "아이디 : " + userId + ", 패스워드 : " + userPwd;
		
		try
		{
			PrintWriter out = response.getWriter();
			
			// 출력스트림으로 html 도큐먼트 그려내기
			out.print("<html>");
			out.print("<head>");
			out.print("<title>");
			out.print("Test005.java");
			out.print("</title>");
			out.print("</head>");
			
			out.print("<body>");
			
			out.print("<div>");
			out.print("<h1>");
			out.print("서블릿 관련 실습");
			out.print("<hr>");
			out.print("</h1>");
			out.print("</div>");
			
			out.print("<div>");
			out.print("<h2>");
			out.print("HttpServlet 클래스를 활용한 서블릿 테스트");
			out.print("</h2>");
			
			out.print("<p>" + str + "</p>");			
			out.print("<p>" + "method :" + request.getMethod() + "</p>");			
			
			out.print("<p>" );	
			out.print("클라이언트 IP Address : "+ request.getRemoteAddr() );	
			out.print("</p>" );
			
			out.print("<p>" + "URI : "+ request.getRequestURI() + "</p>" );	
			
			out.print("</div>");
			out.print("</body>");
			out.print("</html>");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
	}
	
	
}
