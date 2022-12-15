/*====================
 * GradeDTO
=====================*/

package com.test.mybatis;

public class GradeDTO
{
	// 속성 구성
	String sid;
	int sub1, sub2, sub3;
	
	// getter / setter 
	public String getSid()
	{
		return sid;
	}
	public void setSid(String sid)
	{
		this.sid = sid;
	}
	public int getSub1()
	{
		return sub1;
	}
	public void setSub1(int sub1)
	{
		this.sub1 = sub1;
	}
	public int getSub2()
	{
		return sub2;
	}
	public void setSub2(int sub2)
	{
		this.sub2 = sub2;
	}
	public int getSub3()
	{
		return sub3;
	}
	public void setSub3(int sub3)
	{
		this.sub3 = sub3;
	}
	
}
