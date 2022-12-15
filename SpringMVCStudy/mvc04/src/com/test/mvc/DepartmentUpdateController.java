/*=================================================================
   RegionUpdateController.java
   (regionupdate.action)
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

public class DepartmentUpdateController implements Controller
{
	private IDepartmentDAO departmentDAO;

	public void setDepartmentDAO(IDepartmentDAO departmentDAO)
	{
		this.departmentDAO = departmentDAO;
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
		
		// 데이터 수신로 부터
		String departmentId = request.getParameter("departmentId");
		String name = request.getParameter("name");
		
		try
		{
			Department department = new Department();
			
			department.setDepartmentId(departmentId);
			department.setDepartmentName(name);
			
			departmentDAO.modify(department);
			
			mav.setViewName("redirect:departmentlist.action");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mav;
		
	}
	
}
