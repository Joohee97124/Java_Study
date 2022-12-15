/*=======================================================
■■■ 메소드 재귀호출(재귀 메소드) ■■■
========================================================*/


public class Test067
{
	public static void main(String[] args)
	{	
		showHi(5);
	}
	
	/*
	public static void showHi(int cnt)	// 5 
	{
				// 아무것도 두고오지 X
		
		System.out.println("Hi~~~");
		
		showHi(cnt--);					// showHi(5);

		if (cnt==1)
			return;
	*/

	//→

	public static void showHi(int cnt)	// 5			4
	{
				// 아무것도 두고오지 X
		
		System.out.println("Hi~~~");
		
		if (cnt==1)						// if문 (1인지) 을 확인하기 위해
			return;

		showHi(--cnt);					// showHi(4);	3







		


	}

}