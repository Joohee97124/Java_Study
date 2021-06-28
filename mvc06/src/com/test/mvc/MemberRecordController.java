/*==============================
 * MemberRecordController.java 
==============================*/

package com.test.mvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberRecordController
{
	// 액션처리를 위한 메소드는 사용자 지정
	
	/*
	@RequestMapping("URL 매핑 주소")
	public String 메소드 이름(매개변수)
	{
		// ※ 비즈니스 로직 처리 (모델 활용)
		
		return "뷰 이름.jsp";
	}
	*/
	
	// 데이터베이스의 데이터를 읽어오는 과정
	@RequestMapping("/memberlist.action")
	public String memberList(Model model)
	{
		// ※ 비즈니스 로직 처리 (모델 활용)
		String result = "";
		
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDAO dao = new MemberDAO();
		
		try
		{
			dao.connection();
			list = dao.lists();
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally 
		{
			try
			{
				dao.close();
				
			} catch (Exception e2)
			{
				System.out.println(e2.toString());
			}
		}
		
		model.addAttribute("list", list);
		
		result = "/WEB-INF/views/MemberList.jsp";		
		return result;
	}
	
	
	
	
	// 데이터 입력 (회원등록) 폼 요청 관련 액션 메소드 정의
	@RequestMapping("/memberinsertform.action")
	public String memberInsertForm(ModelAndView model)
	{
		String result = "";
		
		result = "/WEB-INF/views/MemberInsertForm.jsp";
		return result;
	}
	
	
	
	
	// 데이터 입력 (회원등록) 액션 메소드 정의
	@RequestMapping("/memberinsert.action")
	public String memberInsert(MemberDTO dto)	// id , name , tel , email
	{
		// 매개변수 dto 에는 MemberInsertForm.jsp에서 추가한 데이터들이 담겨있다
		
		
		String result = "";
		MemberDAO dao = new MemberDAO();
		
		try
		{
			dao.connection();
			dao.insertQuery(dto);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}		
		
		result = "redirect:memberlist.action";
		return result;
	}
}
