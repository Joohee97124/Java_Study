/*====================
 * FriendDTO.java
=====================*/

package com.test;

public class FriendDTO
{
	// 속성 (이름, 나이, 성별, 이상형)
	private String userName;		//--  이름
	private int userAge;			//--  나이
	private String userGender;		//--  성별
	private String[] handsome;		//--  이상형
	//-- 이상형은 여러 개의 데이터가 동시에 전달되므로
	//	 즉, 다중 선택이 가능하도록 구성된 컨트롤이기 때문에
	//	 배열로 처리한다

	
	// getter / setter
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public int getUserAge()
	{
		return userAge;
	}
	public void setUserAge(int userAge)
	{
		this.userAge = userAge;
	}
	public String getUserGender()
	{
		return userGender;
	}
	public void setUserGender(String userGender)
	{
		this.userGender = userGender;
	}
	public String[] getHandsome()
	{
		return handsome;
	}
	public void setHandsome(String[] handsome)
	{
		this.handsome = handsome;
	}

	
	
}
