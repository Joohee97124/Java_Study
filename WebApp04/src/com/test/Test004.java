/*====================
 	Test004.java
 	- Servlet 실습
====================*/

// 현재... 자바 기본 클래스 Test004
// 이를 Servlet 으로 구성하는 방법

// GenericServlet 을 상속받는 클래스로 설계 → Servlet 
// (정체성이 서블릿이 된다)

package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test004 extends GenericServlet
{
	private static final long serialVersionUID = 1L;
	// 서블릿으로 구성하게 되는 객체 -> 객체 직렬화와 관련이 있음
	// 직렬화 = 쪼개져있는 것들을 번호 붙여서 나열
	// 그 아이디를 이렇게 붙이라고 하는거! 
	// 우리가 직접 쓸 것은 아님~ 걍 붙여놓고 끝내면 돼

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		// 서비스 메소드 → 서블릿 코드에서 나오는 그 서비스 메소드! 
		// 매개변수가 http request, http response 였는데 여기는 서블릿 request, response
		// 서블릿 컨테이너가 서비스메소드를 호출함~ = 클의 요청이 있을 때 자동 호출
		// request = 클의 요청, response = 서버측의 응답
		
		response.setContentType("text/html; charset=UTF-8");
		// 이런 유형의 응답을 해줄거야~
		
		try
		{
			PrintWriter out  = response.getWriter();
			// 출력 스트림에 html 도큐먼트 출력
			
			out.print("<html> ");
			out.print("<head> ");
			out.print("<title> ");
			out.print("Test004.java ");
			out.print("</title> ");
			out.print("</head> ");
			out.print("<body> ");
			out.print("<div> ");
			out.print("<h1> ");
			out.print("서블릿 관련 실습 ");
			out.print("</h1> ");
			out.print("<hr> ");
			out.print("</div> ");
			out.print("<div> ");
			out.print("<h2> ");
			out.print("GenericServlet 클래스를 이용한 서블릿 테스트 ");
			out.print("</h2> ");
			out.print("</div> ");
			out.print("</body> ");
			out.print("</html> ");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		
	}
	
}
