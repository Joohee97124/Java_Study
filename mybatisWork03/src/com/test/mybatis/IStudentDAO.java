/*=================
 * IStudentDAO.java
 * - 인터페이스
==================*/
package com.test.mybatis;

import java.util.ArrayList;

public interface IStudentDAO
{
	public ArrayList<StudentDTO> list();
	public int add(StudentDTO dto);
}
