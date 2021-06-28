/*=============================================================
   PosListController.java
   - 사용자 정의 컨트롤러 클래스
   - 리스트 페이지 요청에 대한 액션 처리 (일반직원 전용)
   - DAO 객체에 대한 의존성 주입(DI)을 위한 준비
    → 인터페이스 형태의 자료형을 속성으로 구성
    → setter 메소드 구성
============================================================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.print.DocFlavor.READER;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javafx.geometry.Pos;

// ※ Spring 의 `Controller` 인터페이스를 구현하는 방법을 통해
//   사용자 정의 컨트롤러 클래스를 구현한다.

public class PosListController implements Controller
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
		
		
		// 세션 처리에 따른 추가 구성 → 로그인 여부 확인 → 관리자 확인 할 필요 없음 --------------------------
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name")==null)	//-- 로그인을 하지 못한 상황
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		//  -------------------------- 세션 처리에 따른 추가 구성 → 로그인 여부 확인 → 관리자 확인 할 필요 없음
		
		
		// 로그인 성공한 상황
		ArrayList<Position> positionList = new ArrayList<Position>();
		
		try
		{
			positionList = positionDAO.list();
			// 실무 → 필요한 애들만 가져오는 dao.메소드() 를
			// 따로 만들어서 여기서 이용하는게 맞다! 
			
			mav.addObject("positionList", positionList);
			
			mav.setViewName("/WEB-INF/views/PosList.jsp");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		
		return mav;
		
	}
	
}
