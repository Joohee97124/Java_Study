/*==================================================
 RegionupdateFormController.java  
       (regionupdateform.action)
   - 사용자 정의 컨트롤러 클래스
   - 지역 데이터 수정 폼 요청에 대한 액션 처리
   - DAO 객체에 대한 의존성 주입(DI)을 위한 준비
     → 인터페이스 형태의 자료형을 속성으로 구성
     → setter 메소드 구성
===================================================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ※ Spring 의 『Controller』 인터페이스를 구현하는 방법을 통해
//   사용자 정의 컨트롤러 클래스를 구현한다.

public class RegionUpdateFormController implements Controller
{
	private IRegionDAO regionDAO;
	
	public void setRegionDAO(IRegionDAO regionDAO)
	{
		this.regionDAO = regionDAO;
	}

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// 액션 코드
		
		ModelAndView mav = new ModelAndView();
		
		
		// 세션 처리에 따른 추가 구성 → 로그인 여부 확인 → 관리자여야 수정 가능 -------------------
		HttpSession session = request.getSession();
		
		if(session.getAttribute("name")==null)
		{
			// 로그인 못한 상황  → 로그인창으로 가라!
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		else if (session.getAttribute("admin")==null)
		{
			// 일반직원 로그인 상황  → 로그인창으로 가라!
			mav.setViewName("redirect:loginform.action");
			return mav;
		}		
		// ------------------- 세션 처리에 따른 추가 구성 → 로그인 여부 확인 → 관리자여야 수정 가능 

		
		// 관리자로 로그인 된 상황
		
		try
		{
			// 데이터 수신 (→ RegionList.jsp 로 부터... RegionId 수신)
			String regionId = request.getParameter("regionId");
			
			Region region = new Region();
			
			region = regionDAO.searchId(regionId);
			
			mav.addObject("region",region);

			mav.setViewName("WEB-INF/views/RegionUpdateForm.jsp");
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		
		
		return mav;
		
	}
	
}
