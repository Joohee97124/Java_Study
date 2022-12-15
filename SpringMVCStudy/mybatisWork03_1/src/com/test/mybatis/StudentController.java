package com.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController
{
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/studentlist.action", method=RequestMethod.GET)
	public String studentlist(ModelMap model)
	{
		IStudentDAO dao = sqlSession.getMapper(IStudentDAO.class);
		
		model.addAttribute("list", dao.list());
		
		return "/WEB-INF/views/StudentList.jsp";
	}

}
