/*=================================================================
   PositionUpdateController.java
   - 사용자 정의 컨트롤러 클래스
   - DAO 객체에 대한 의존성 주입(DI)을 위한 준비
     → 인터페이스 형태의 자료형을 속성으로 구성
     → setter 메소드 구성
==================================================================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ※ Spring 의 `Controller` 인터페이스를 구현하는 방법을 통해
//   사용자 정의 컨트롤러 클래스를 구현한다.

public class PositionUpdateController implements Controller
{
	private IPositionDAO positionDAO;
	
	public void setPositionDAO(IPositionDAO positionDAO)
	{
		this.positionDAO = positionDAO;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 액션 코드
		ModelAndView mav = new ModelAndView();

		// 세션 처리과정 추가 ----------------------------------------------------
		HttpSession session = request.getSession();
		
		if (session.getAttribute("name")==null)		//-- 로그인이 되어있지 않은 상황
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		else if (session.getAttribute("admin")==null)	//-- 관리자 아닌 일반사원으로 로그인된 상황
		{
			mav.setViewName("redirect:logout.action");
			// 기존의 로그인 풀어주기
			return mav;
		}
		// ---------------------------------------------------- 세션 처리과정 추가 
		
		// 데이터 수신(EmployeeUpdateForm.jsp)로 부터
		String positionId = request.getParameter("positionId");
		String name = request.getParameter("name");
		String MinBasicPay = request.getParameter("MinBasicPay");
		
		try
		{
			Position position = new Position();
			
			position.setPositionId(positionId);
			position.setPositionName(name);
			position.setMinBasicPay(Integer.parseInt(MinBasicPay));
			
			positionDAO.modify(position);
			
			mav.setViewName("redirect:positionlist.action");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
		
	}
	
}
