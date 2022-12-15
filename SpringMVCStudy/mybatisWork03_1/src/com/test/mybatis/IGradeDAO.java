/*=================
 * IStudentDAO.java
 * - 인터페이스
==================*/
package com.test.mybatis;

import java.util.ArrayList;

public interface IGradeDAO
{
	public ArrayList<GradeDTO> list(GradeDTO dto);
	public int add(GradeDTO dto);
}
