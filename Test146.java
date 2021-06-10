/*======================================
■■■ 예외(Exception) 처리 ■■■
======================================*/

// Test145.java 파일과 비교~!!!


class Demo2
{
	// 주요 속성 구성
	private int value;

	
	// setter
	public void setValue(int value) throws Exception // 발생한 예외를 처리해줘야함
	{
		if (value<=0)
			throw new Exception("value는 0보다 작거나 같을 수 없습니다.");
			//-- 새로운 예외 발생~!!!
			
		this.value = value;
	}

	// getter
	public int getValue()
	{
		return value;
	}
}


public class Test146
{
	public static void main(String[] args) // ① throws Exception // 여기서도 던져줘~!
	{
		/*
		①
		Demo2 ob = new Demo2();
		ob.setValue(-10);	// Exception 여기로 떨어짐
		int result = ob.getValue();
		System.out.println(result);
		

		Exception in thread "main" java.lang.Exception: value는 0보다 작거나 같을 수 없습니다.
        at Demo2.setValue(Test146.java:18)
        at Test146.main(Test146.java:37)
		계속하려면 아무 키나 누르십시오 . . .
		*/

		
		// ②
		try
		{
			Demo2 ob = new Demo2();
			ob.setValue(-10);	// Exception 여기로 떨어짐
			int result = ob.getValue();
			System.out.println(result);
		}
		catch (Exception e)
		{
			System.out.println("예외처리하기~!!");
			System.out.println(e.toString());
		}
		/*
		예외처리하기~!!
		java.lang.Exception: value는 0보다 작거나 같을 수 없습니다.
		계속하려면 아무 키나 누르십시오 . . .
		*/
	}
}