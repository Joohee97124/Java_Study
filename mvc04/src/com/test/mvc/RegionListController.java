/*=================================
   SampleController.java
   - 사용자 정의 컨트롤러 클래스
=================================*/

package com.test.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ※ Spring 의 `Controller` 인터페이스를 구현하는 방법을 통해
//   사용자 정의 컨트롤러 클래스를 구현한다.

public class RegionListController implements Controller
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
		
		
		// 관리자로 로그인 된 상황
		ArrayList<Region> regionList= new ArrayList<Region>();
		
		try
		{
			regionList = regionDAO.list();
			
			mav.addObject("regionList", regionList);
			mav.setViewName("/WEB-INF/views/RegionList.jsp");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}

		
		return mav;
		
	}
	
}
